package xin.tianchuang.modules.spider.biz.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.component.dozer.EjbDozerGenerator;
import xin.tianchuang.common.enums.DataSourceEnum;
import xin.tianchuang.common.enums.HnaicMarkTypeEnum;
import xin.tianchuang.common.enums.HndsTaxAYearsEnum;
import xin.tianchuang.common.enums.HndsTaxKeyEnum;
import xin.tianchuang.common.enums.TaxUserTypeEnum;
import xin.tianchuang.common.utils.XSteamUtils;
import xin.tianchuang.modules.spider.bean.hnaic.HnaicCmsbResult;
import xin.tianchuang.modules.spider.bean.hnds.HndsTaxResultsDTO;
import xin.tianchuang.modules.spider.bean.hnentenvcredit.HnEntEnvResultDTO;
import xin.tianchuang.modules.spider.bean.task.HnEntEnvCreditTaskParamDTO;
import xin.tianchuang.modules.spider.biz.CreditSpiderBiz;
import xin.tianchuang.modules.spider.entity.CcgpPurchaseIllegalEntity;
import xin.tianchuang.modules.spider.entity.HnEntEnvCreditEntity;
import xin.tianchuang.modules.spider.entity.HnaicMarkInfoEntity;
import xin.tianchuang.modules.spider.entity.HndsCreditLevelEntity;
import xin.tianchuang.modules.spider.entity.HndsTaxInfoEntity;
import xin.tianchuang.modules.spider.entity.HntaxOweTaxInfoEntity;
import xin.tianchuang.modules.spider.service.CcgpPurchaseIllegalService;
import xin.tianchuang.modules.spider.service.HnEntEnvCreditService;
import xin.tianchuang.modules.spider.service.HnaicMarkInfoService;
import xin.tianchuang.modules.spider.service.HndsCreditLevelService;
import xin.tianchuang.modules.spider.service.HndsTaxInfoService;
import xin.tianchuang.modules.spider.service.HntaxOweTaxInfoService;

import com.alibaba.fastjson.JSON;

@Service
public class CreditSpiderBizImpl implements CreditSpiderBiz {

	private static Logger logger = LoggerFactory.getLogger(CreditSpiderBiz.class);
	@Autowired
	private HnEntEnvCreditService hnEntEnvCreditService;

	@Autowired
	private HntaxOweTaxInfoService hntaxOweTaxInfoService;

	@Autowired
	private HnaicMarkInfoService hnaicMarkInfoService;

	@Autowired
	private CcgpPurchaseIllegalService ccgpPurchaseIllegalService;

	@Autowired
	private HndsCreditLevelService hndsCreditLevelService;
	@Autowired
	private HndsTaxInfoService hndsTaxInfoService;

	@Autowired
	protected EjbDozerGenerator ejbGenerator;

	@Override
	public void resultShow(HnEntEnvCreditTaskParamDTO paramDTO) {
		// 评定等级 [{'id':'1','name':'环境诚信'}, {'id':'2','name':'环境合格'}, {'id':'3','name':'环境风险'}, {'id':'4','name':'环境不良'},
		String url = "http://202.103.114.13:8085/xypj/xypj/website/result_show.jsp?bg_class=topimg&area_id=430000&";
		Connection conn = Jsoup.connect(url);
		conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		conn.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");

		try {
			Response response = conn.ignoreContentType(true).followRedirects(true).method(Method.GET).execute();
			Map<String, String> cookies = response.cookies();
			String page = StringUtils.isNotBlank(paramDTO.getPage()) ? "1" : paramDTO.getPage(); // 分页号
			String rows = StringUtils.isNotBlank(paramDTO.getRows()) ? "200" : paramDTO.getRows(); // 每页数
			List<HnEntEnvCreditEntity> entityList = new ArrayList<HnEntEnvCreditEntity>();
			List<HnEntEnvCreditEntity> resultList = null; // 转换后结果
			String year = paramDTO.getYear();
			// for (CreditResultBeanYearEnum year : CreditResultBeanYearEnum.values()) {
			Response execute = getQueryPage(cookies, page, rows, paramDTO);
			// 计算page页面，循环爬取
			String body = execute.body();
			logger.info("返回数据{}", body);
			// 总分页数获取
			HnEntEnvResultDTO dto = JSON.parseObject(body, HnEntEnvResultDTO.class);
			Integer total = dto.getTotal();
			int totalPageNum = (total + Integer.valueOf(rows) - 1) / Integer.valueOf(rows); // 总分页数

			for (int i = 1; i <= totalPageNum; i++) {
				execute = getQueryPage(cookies, String.valueOf(i), rows, paramDTO);
				// 计算page页面，循环爬取
				dto = JSON.parseObject(execute.body(), HnEntEnvResultDTO.class);

				resultList = ejbGenerator.convert(dto.getRows(), HnEntEnvCreditEntity.class);
				for (HnEntEnvCreditEntity entity : resultList) {

					HnEntEnvCreditEntity dataResult = hnEntEnvCreditService.selectByOne(entity, year);
					if (null == dataResult) {
						entity.setEntName(entity.getComName());
						entity.setYears(year);
						entity.setDataSource(DataSourceEnum.HNTAX.key());
						entityList.add(entity);
					}
				}
			}
			// 批量插入
			if (null != entityList && entityList.size() == 500) {
				hnEntEnvCreditService.insertBatch(entityList);
				entityList.clear();
			}

			// }
			// 最后全部批量提交
			if (null != entityList && entityList.size() >= 1) {
				hnEntEnvCreditService.insertBatch(entityList);
			}

		} catch (IOException e) {
			logger.error("", e);
		}

	}

	private Response getQueryPage(Map<String, String> cookies, String page, String rows, HnEntEnvCreditTaskParamDTO paramDTO) throws IOException {
		String queryUrl = "http://202.103.114.13:8085/xypj/xypj/website/inquiryAction!queryRredit_result.do";
		Connection conn = Jsoup.connect(queryUrl);
		conn.header("Accept", "text/plain, */*; q=0.01");
		conn.header("Accept-Encoding", "gzip, deflate");
		conn.header("Accept-Language", "zh-CN,zh;q=0.9");
		conn.header("Connection", "keep-alive");
		conn.header("Content-Length", "133");
		conn.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");

		Map<String, String> postFormParams = new HashMap<String, String>();
		String comName = paramDTO.getComName();
		if (StringUtils.isNotBlank(comName)) {
			postFormParams.put("creditResultBean.com_name", comName);
		}
		String areaId = paramDTO.getAreaId();
		if (StringUtils.isNotBlank(areaId)) {
			postFormParams.put("creditResultBean.area_id", areaId);
		}
		String year = paramDTO.getYear();
		if (StringUtils.isNotBlank(year)) {
			postFormParams.put("creditResultBean.year", year);
		}
		postFormParams.put("userRole", "430000");
		postFormParams.put("page", page);
		String level = paramDTO.getLevel();
		if (StringUtils.isNotBlank(level)) {
			postFormParams.put("creditResultBean.levl", level);
		}
		postFormParams.put("rows", rows);

		conn = conn.ignoreContentType(true).method(Method.POST).cookies(cookies).data(postFormParams);
		Response execute = conn.execute();
		logger.info(execute.body());
		return execute;
	}

	@Override
	public void hnTaxQsgg() {
		for (TaxUserTypeEnum typeEnum : TaxUserTypeEnum.values()) {
			int type = typeEnum.key();
			String url = "http://www.hntax.gov.cn/zhuanti/qsgg/article_list.jsp?city_id=-1&type=" + type; // 查询湖南省所有
			Connection conn = Jsoup.connect(url);
			conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
			conn.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");

			try {
				// 获取分页总数
				Response response = conn.ignoreContentType(true).followRedirects(true).method(Method.GET).execute();
				Map<String, String> cookies = response.cookies();
				Document doc = response.parse();
				String pageUrl = doc.getElementsByClass("clstbldata").get(0).getElementsByTag("a").last().attr("href");
				String[] params = pageUrl.split("&&");
				Map<String, String> hm = new HashMap<>();
				for (String param : params) {
					String[] keyValue = param.split("=");
					hm.put(keyValue[0], keyValue[1]);
				}
				Integer pageCount = Integer.parseInt(hm.get("article_list.jsp?pagenum"));
				// 获取结果集
				List<HntaxOweTaxInfoEntity> ls = new ArrayList<HntaxOweTaxInfoEntity>();
				for (int i = 0; i < pageCount; i++) {
					String queryUrl = " http://www.hntax.gov.cn/zhuanti/qsgg/article_list.jsp?pagenum=" + i + "&&type=" + type + "&city_id=-1";
					conn = Jsoup.connect(queryUrl);
					conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
					conn.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");

					Document document = conn.ignoreContentType(true).method(Method.GET).cookies(cookies).get();
					logger.info("返回数据：{}", document.body());
					Element table = document.getElementsByClass("clstbldata").get(0);
					Elements trs = table.select("tr");
					for (Element tr : trs) {
						Elements tds = tr.select("td");
						String taxName = tds.get(0).text();
						// 首行标题和翻页行需要移除
						if (StringUtils.isNotBlank(taxName) && (taxName.contains("纳税人名称") || taxName.contains("首页") || taxName.contains("无")) || (StringUtils.isBlank(taxName))) {
							continue;
						}

						HntaxOweTaxInfoEntity reqEntity = new HntaxOweTaxInfoEntity();

						reqEntity.setTaxName(taxName.trim());
						reqEntity.setTaxNo(tds.get(1).text());
						reqEntity.setLegalName(tds.get(2).text());
						reqEntity.setCertType(tds.get(3).text());
						reqEntity.setCertNo(tds.get(4).text());
						reqEntity.setAddress(tds.get(5).text());
						reqEntity.setOweTaxType(tds.get(6).text());
						reqEntity.setOweTaxBalance(tds.get(7).text());

						if (tds.size() >= 8) {
							String currentOccurreAmount = tds.get(8).text();
							if (StringUtils.isNotBlank(currentOccurreAmount) && currentOccurreAmount.contains("null")) {
								currentOccurreAmount = currentOccurreAmount.replace("null", "");
							}
							reqEntity.setCurrentOccurreAmount(currentOccurreAmount);
						}

						if (tds.size() >= 9) {
							reqEntity.setPublishDate(tds.get(9).text());
						}
						reqEntity.setUserType("" + type);
						reqEntity.setDataSource(DataSourceEnum.HNTAX.key());

						HntaxOweTaxInfoEntity dataEntity = hntaxOweTaxInfoService.selectByOne(reqEntity);
						if (null == dataEntity) {

							if (typeEnum == TaxUserTypeEnum.ENTERPRISE) { // 如果为企业，则更新企业名称
								reqEntity.setEntName(taxName);
								reqEntity.setDataSource(DataSourceEnum.HNTAX.key());
							}

							ls.add(reqEntity);
						}
					}
					// 批量插入
					if (null != ls && ls.size() == 100) {
						hntaxOweTaxInfoService.insertBatch(ls);
						ls.clear();
					}
				}
				// 最后全部批量提交
				hntaxOweTaxInfoService.insertBatch(ls);

			} catch (IOException e) {
				logger.error("", e);
			}
		}

	}

	@Override
	public void hnaicListmark() {
		for (HnaicMarkTypeEnum type : HnaicMarkTypeEnum.values()) {
			int reqMarkType = type.key();
			String url = "http://www.hnaic.gov.cn/visit/socialservice/a/listmark?marktype=" + reqMarkType;
			Connection conn = Jsoup.connect(url);
			conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
			conn.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");

			try {
				Response response = conn.ignoreContentType(true).followRedirects(true).method(Method.GET).execute();
				Map<String, String> cookies = response.cookies();
				String body = response.body();
				logger.info(body);
				String queryUrl = "http://www.hnaic.gov.cn/visit/socialservice/a/listMarkByTypeForAjax?nocache=" + System.currentTimeMillis();
				conn = Jsoup.connect(queryUrl);
				conn.header("Accept", "*/*");
				conn.header("Accept-Encoding", "gzip, deflate");
				conn.header("Accept-Language", "zh-CN,zh;q=0.9");
				conn.header("Connection", "keep-alive");
				conn.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");

				Map<String, String> postFormParams = new HashMap<String, String>();
				postFormParams.put("marktype", "" + reqMarkType);
				postFormParams.put("page", "1");
				// postFormParams.put("key", "");
				// postFormParams.put("keyselect", "");

				conn = conn.ignoreContentType(true).method(Method.POST).cookies(cookies).data(postFormParams);
				Response execute = conn.execute();
				String xml = execute.body();
				HnaicCmsbResult xmlToObj = XSteamUtils.xmlToObj(xml, HnaicCmsbResult.class);
				// 获取总条数
				String div = xmlToObj.getDiv();
				String total = div.substring(div.indexOf("color=\'red\'hnaicfzngt"), div.indexOf("hnaicfznlt/fonthnaicfzngt记录")).replace("color=\'red\'hnaicfzngt", "");
				Integer rows = 15; // 每条15
				int totalPageNum = (Integer.valueOf(total) + Integer.valueOf(rows) - 1) / Integer.valueOf(rows); // 总分页数
				List<HnaicMarkInfoEntity> ls = new ArrayList<HnaicMarkInfoEntity>();
				HnaicMarkInfoEntity entity = null;
				for (int page = 1; page <= totalPageNum; page++) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						logger.error("线程休息2s异常", e);
					}
					queryUrl = "http://www.hnaic.gov.cn/visit/socialservice/a/listMarkByTypeForAjax?nocache=" + System.currentTimeMillis();
					conn = Jsoup.connect(queryUrl);
					conn.header("Accept", "*/*");
					conn.header("Accept-Encoding", "gzip, deflate");
					conn.header("Accept-Language", "zh-CN,zh;q=0.9");
					conn.header("Connection", "keep-alive");
					conn.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");

					postFormParams = new HashMap<String, String>();
					postFormParams.put("marktype", "" + reqMarkType);
					postFormParams.put("page", "" + page);
					// postFormParams.put("key", "");
					// postFormParams.put("keyselect", "");

					conn = conn.ignoreContentType(true).method(Method.POST).cookies(cookies).data(postFormParams);
					execute = conn.execute();
					xml = execute.body();
					logger.info("返回信息:{}", xml);
					if (StringUtils.isBlank(xml) || (StringUtils.isBlank(xml) && xml.contains("<html>"))) {
						continue;
					}
					xmlToObj = XSteamUtils.xmlToObj(xml.replace("&", "&amp;"), HnaicCmsbResult.class);

					for (int i = 0; i < xmlToObj.getMarkId().size(); i++) {
						String markId = xmlToObj.getMarkId().get(i);

						HnaicMarkInfoEntity dataMarkInfo = hnaicMarkInfoService.selectByMarkId(markId);
						if (null == dataMarkInfo) {
							String markType = xmlToObj.getMarkType().get(i);
							String markName = xmlToObj.getMarkName().get(i);
							String markPassNumb = xmlToObj.getMarkPassNum().get(i);
							String blongToEnterprise = xmlToObj.getBlongToEnterprise().get(i);
							String markToPro = xmlToObj.getMarkToPro().get(i);
							String selectTime = xmlToObj.getSelectTime().get(i);
							String enterpriseAddr = xmlToObj.getEnterpriseAddr().get(i);

							entity = new HnaicMarkInfoEntity();
							entity.setMarkId(markId);
							entity.setMarkType(markType);
							entity.setMarkName(markName);
							entity.setMarkPassNumb(markPassNumb);
							entity.setBlongToEnterprise(blongToEnterprise);
							entity.setEntName(blongToEnterprise);
							entity.setMarkToPro(markToPro);
							entity.setSelectTime(selectTime);
							entity.setEnterpriseAddr(enterpriseAddr);
							entity.setDataSource(DataSourceEnum.HNAIC.key());

							ls.add(entity);
						}

					}
					// 分配次提交
					if (null != ls && ls.size() == 500) {
						hnaicMarkInfoService.insertBatch(ls);
						ls.clear();
					}

				}

				if (null != ls && ls.size() > 0) {
					hnaicMarkInfoService.insertBatch(ls);
				}
			} catch (IOException e) {
				logger.error("", e);
			}
		}
	}

	@Override
	public void ccgpCr() {
		String url = "http://www.ccgp.gov.cn/cr/list";
		Connection conn = Jsoup.connect(url);
		conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		conn.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");

		try {
			Response response = conn.ignoreContentType(true).followRedirects(true).method(Method.GET).execute();
			Map<String, String> cookies = response.cookies();
			String body = response.body();
			Document doc = response.parse();
			logger.info(body);

			// 获取总条数
			String text = doc.getElementById("totalPag").text();
			if (StringUtils.isBlank(text)) {
				// return R.error("分页数为空");
				return;
			}
			int totalPageNum = Integer.parseInt(text); // 总分页数
			List<CcgpPurchaseIllegalEntity> ls = new ArrayList<CcgpPurchaseIllegalEntity>();
			for (int page = 1; page <= totalPageNum; page++) {

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					logger.error("线程休息2s异常", e);
				}
				// 获取翻页数和记录
				String queryUrl = "http://www.ccgp.gov.cn/cr/list";
				conn = Jsoup.connect(queryUrl);
				conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
				conn.header("Accept-Encoding", "gzip, deflate");
				conn.header("Accept-Language", "zh-CN,zh;q=0.9");
				conn.header("Connection", "keep-alive");
				conn.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");

				Map<String, String> postFormParams = new HashMap<String, String>();
				// postFormParams.put("orgName", "");
				// postFormParams.put("enforceUnit", "");
				// postFormParams.put("punishTime", "");
				// postFormParams.put("punishTimeMax", "");
				postFormParams.put("gp", "" + page);
				// postFormParams.put("key", "");
				// postFormParams.put("keyselect", "");

				conn = conn.ignoreContentType(true).method(Method.POST).cookies(cookies).data(postFormParams);
				Response execute = conn.execute();

				Document parse2 = execute.parse();
				Element tableInfo = parse2.getElementById("tableInfo");
				Elements trs = tableInfo.getElementsByClass("trShow");
				for (Element tr : trs) {
					Elements tds = tr.getElementsByTag("td");
					if (null == tds || tds.size() <= 0) {
						logger.debug("无可用数据行");
						continue;
					}
					String creditCode = tds.get(2).text();
					String punishDate = tds.get(7).text();
					CcgpPurchaseIllegalEntity entity = ccgpPurchaseIllegalService.selectByCreditCodeDate(creditCode, punishDate);
					if (null == entity) {
						String enterpriseName = tds.get(1).text();
						String address = tds.get(3).text();
						String illegalDetail = tds.get(4).text();
						String punishResult = tds.get(5).text();
						String base = tds.get(6).text();
						String publishDate = tds.get(8).text();
						String authority = tds.get(9).text();

						entity = new CcgpPurchaseIllegalEntity();
						entity.setEntName(enterpriseName);
						entity.setCreditCode(creditCode);
						entity.setAddress(address);
						entity.setIllegalDetail(illegalDetail);
						entity.setPunishResult(punishResult);
						entity.setBase(base);
						entity.setPublishDate(publishDate);
						entity.setPunishDate(punishDate);
						entity.setAuthority(authority);
						entity.setDataSource(DataSourceEnum.CCGP.key());

						ls.add(entity);
					}

				}
				// 分配次提交
				if (null != ls && ls.size() == 500) {
					ccgpPurchaseIllegalService.insertBatch(ls);
					ls.clear();
				}

			}

			if (null != ls && ls.size() > 0) {
				ccgpPurchaseIllegalService.insertBatch(ls);
			}
		} catch (IOException e) {
			logger.error("", e);
		}
	}

	@Override
	public void hndsXydj() {
		String url = "http://www.hnds.gov.cn/hnmh/bsfw/zxcx/djcx/default.htm"; // 进入页面
		Connection conn = Jsoup.connect(url);
		conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		conn.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");

		try {
			Response response = conn.ignoreContentType(true).followRedirects(true).method(Method.GET).execute();
			Map<String, String> cookies = response.cookies();
			String body = response.body();
			logger.info(body);

			String newCreditQueryUrl = "http://www.hnds.gov.cn/webapp/credit/newCreditQuery.jsp";
			Integer rows = 15; // 分页数
			String creditLvl = "A";
			for (HndsTaxAYearsEnum year : HndsTaxAYearsEnum.values()) {

				conn = Jsoup.connect(newCreditQueryUrl);
				conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
				conn.header("Accept-Encoding", "gzip, deflate");
				conn.header("Accept-Language", "zh-CN,zh;q=0.9");
				conn.header("Connection", "keep-alive");
				conn.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");

				String planId = year.key();
				Map<String, String> postFormParams = new HashMap<String, String>();
				postFormParams.put("planId", planId);
				postFormParams.put("creditLvl", creditLvl);
				// postFormParams.put("accName", "");
				// postFormParams.put("tax_cer_sn", "");
				postFormParams.put("__max_page_size", "" + rows);
				postFormParams.put("queryString", "pager.offset=0&pager.desc=true");

				conn = conn.ignoreContentType(true).method(Method.POST).cookies(cookies).data(postFormParams);
				String total = conn.execute().parse().getElementById("list_tb").getElementsByClass("Total").get(0).text();
				// 获取总条数
				if (StringUtils.isBlank(total)) {
					// return R.error("总记录数为空");
					return;
				}
				int pageSize = (Integer.valueOf(total) + Integer.valueOf(rows) - 1) / Integer.valueOf(rows); // 总分页数

				for (int page = 0; page < pageSize; page++) {
					// 获取翻页数和记录
					conn = Jsoup.connect(newCreditQueryUrl + "?planId=" + planId + "&accName=&tax_cer_sn=&assess_org_name=&pager.offset=" + rows * page + "&pager.desc=true");

					conn = conn.ignoreContentType(true).method(Method.GET).cookies(cookies).data(postFormParams);
					Response execute = conn.execute();

					Document doc = execute.parse();
					Elements trs = doc.getElementById("list_tb").getElementsByTag("tr");
					for (Element tr : trs) {
						Elements ths = tr.select("th");
						Elements fybj = tr.getElementsByClass("fybj");
						Elements totals = tr.getElementsByClass("Total");
						// 剔除空行、首行、翻页行等
						if ((null != ths && ths.size() >= 1) || (null != fybj && fybj.size() >= 1) || (null != totals && totals.size() >= 1)) {
							continue;
						}
						Elements tds = tr.getElementsByTag("td");
						String taxper = tds.get(0).text();
						if (StringUtils.isBlank(taxper)) {
							continue;
						}
						String taxNo = tds.get(1).text();
						String level = tds.get(2).text();
						String authority = tds.get(3).text();
						String years = tds.get(4).text();
						String evaluateDate = tds.get(5).text();

						HndsCreditLevelEntity entity = hndsCreditLevelService.selectByTaxNoYearsDate(taxper, taxNo, years, evaluateDate, authority);
						if (null != entity) {
							logger.info("数据已插入");
							continue;
						}
						entity = new HndsCreditLevelEntity();
						entity.setEntName(taxper);
						entity.setTaxper(taxper);
						entity.setTaxNo(taxNo);
						entity.setLevel(level);
						entity.setAuthority(authority);
						entity.setYears(years);
						entity.setEvaluateDate(evaluateDate);
						entity.setDataSource(DataSourceEnum.HNDS.key());

						try {
							hndsCreditLevelService.insert(entity);
						} catch (Exception e) {
							logger.error("", e);
							continue;
						}

					}

				}
			}
		} catch (IOException e) {
			logger.error("", e);
		}
	}

	@Override
	public void hndsSwdj() {
		String url = "http://www.hnds.gov.cn/webapp/account/accountQuery.jsp"; // 进入页面
		Connection conn = Jsoup.connect(url);
		conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		conn.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");

		try {
			Response response = conn.ignoreContentType(true).followRedirects(true).method(Method.GET).execute();
			Map<String, String> cookies = response.cookies();
			logger.info(response.body());

			Integer rows = 15; // 分页数
			int timeout = 1000 * 60 * 4;
			for (HndsTaxKeyEnum key : HndsTaxKeyEnum.values()) {

				String queryUrl = "http://www.hnds.gov.cn/creatorCMS/appManage/account/accountQueryList.page";
				conn = Jsoup.connect(queryUrl);
				conn.header("Accept", "text/plain, */*; q=0.01");
				conn.header("Accept-Encoding", "gzip, deflate");
				conn.header("Accept-Language", "zh-CN,zh;q=0.9");
				conn.header("Connection", "keep-alive");
				conn.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");

				String keyWord = key.key();
				Map<String, String> postFormParams = new HashMap<String, String>();
				postFormParams.put("accName", keyWord);
				// postFormParams.put("verify", "");
				postFormParams.put("rows", "" + rows);
				postFormParams.put("page", "1");

				conn = conn.ignoreContentType(true).method(Method.POST).cookies(cookies).data(postFormParams).timeout(timeout);
				Response resp = conn.execute();
				logger.info(resp.body());
				String resultJson = resp.parse().getElementsByTag("body").get(0).text();
				HndsTaxResultsDTO dto = JSON.parseObject(resultJson, HndsTaxResultsDTO.class);
				Integer total = dto.getTotal();
				int pageSize = (total + rows - 1) / rows; // 总分页数

				List<HndsTaxInfoEntity> ls = new ArrayList<HndsTaxInfoEntity>();
				for (int page = 1; page <= pageSize; page++) {
					// 获取翻页数和记录
					conn = Jsoup.connect(queryUrl);

					postFormParams = new HashMap<String, String>();
					postFormParams.put("accName", keyWord);
					// postFormParams.put("verify", "");
					postFormParams.put("rows", "" + rows);
					postFormParams.put("page", "" + page);

					conn = conn.ignoreContentType(true).method(Method.POST).cookies(cookies).data(postFormParams).timeout(timeout);
					resp = conn.execute();

					resultJson = resp.parse().getElementsByTag("body").get(0).text();
					logger.info("返回数据：{}", resultJson);
					dto = JSON.parseObject(resultJson, HndsTaxResultsDTO.class);
					if (!dto.isFound() || null == dto.getRows() || dto.getRows().size() <= 0) {
						logger.info("未查询到结果");
						break;
					}

					List<HndsTaxInfoEntity> resultLs = ejbGenerator.convert(dto.getRows(), HndsTaxInfoEntity.class);
					if (null == resultLs || resultLs.size() <= 0) {
						logger.info("转换结果为空");
						break;
					}
					for (HndsTaxInfoEntity entity : resultLs) {

						HndsTaxInfoEntity dbEntity = hndsTaxInfoService.selectByOne(entity.getTaxNo(), entity.getTaxper(), entity.getLegalName(), entity.getAuthority(), entity.getTaxStatus());
						if (null == dbEntity) {
							entity.setEntName(entity.getTaxper());
							entity.setDataSource(DataSourceEnum.HNDS.key());
							ls.add(entity);
							try {
								hndsTaxInfoService.insert(entity);
							} catch (Exception e) {
								logger.error("异常", e);
								continue;
							}
						}

					}

					if (!dto.isHasNext()) {
						logger.info("已经查询到最后一页结果");
						break;
					}

				}
			}
		} catch (IOException e) {
			logger.error("IO异常", e);
		}
	}

}
