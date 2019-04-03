package xin.tianchuang.common.utils.tcredit;

import java.util.concurrent.Future;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.nio.reactor.ConnectingIOReactor;
import org.apache.http.nio.reactor.IOReactorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {
	
	
	private static final Logger logger = LoggerFactory.getLogger(LogUtil.class);
//	private static final String PRE_URL="http://10.149.58.101:8091/";
	
//	private static final String PRE_URL="http://220.181.25.233:8091/";
//    private static final String PRE_URL = PropertiesUtil.getProperties("log.url", "http://s.tcredit.com/");
	private static final String PRE_URL = "http://112.74.187.95/";

	
//	private static final String PRE_URL="http://test.log.ypcredit/";
	
	private static CloseableHttpAsyncClient httpAsyncClient;
	
//	public static final String TAG_TEST = "test/test";
	public static final String TAG_TEST = "";
	
	static{
		ConnectingIOReactor ioReactor;
		try {
			ioReactor = new DefaultConnectingIOReactor();
			PoolingNHttpClientConnectionManager cm = new PoolingNHttpClientConnectionManager(ioReactor);
	        cm.setMaxTotal(500);
	        httpAsyncClient = HttpAsyncClients.custom().setConnectionManager(cm).build();
	        httpAsyncClient.start();
		} catch (IOReactorException e) {
			e.printStackTrace();
		}
      
	}
	
	
//	public static void main(String[] args) throws Exception {
//		// LogUtil.doPost(LOG_PATH, one.toJSONString());
//		for(int i = 0;i<10;i++){
//			
//			new Thread(new Runnable() {
//				
//				@Override
//				public void run() {
//					// TODO Auto-generated method stub
//					long s1 = System.currentTimeMillis();
//					doPost(TAG_TEST, "[{\"主要人员信息\":[],\"分支机构信息\":[],\"变更信息\":[],\"基本信息\":{\" 住所\":\"武汉市江汉区青年路276号\",\"名称\":\"武汉子午线信息咨询有限公司\",\"成立日期\":\"2007年4月25日\",\"核准日期\":\"2007年4月25日\",\"法定代表 人\":\"周俊\",\"注册资本\":\"10万人民币元\",\"登记机关\":\"武汉市工商行政管 理局江汉分局\",\"登记状态\":\"吊销，未注销\",\"类型\":\"有限责任公司(自然 人投资或控股)\",\"经营范围\":\"商务信息咨询，经济信息咨询，企业形象策 划。\",\"统一社会信用代码/注册号\":\"4201032106507\",\"营业期限自\":\"2007年4月25日\",\"营业期限至\":\"2017年4月24日\"},\"清算信息\":{\"清算组成员\":\"\",\"清算组负责人\":\"\"},\"股东信息\":[\"自然人股东###袁振中###中华人民 共和国居民身份证###*****###详情###\",\"自然人股东###周俊###中华人民 共和国居民身份证###*****###详情###\",\"自然人股东###刘勇###中华人民 共和国居民身份证###*****###详情###\"]}]");
//					long s2 = System.currentTimeMillis();
//					System.out.println(s2-s1);
//				}
//			}).start();
//			
//		}
		
//	}
	
	
	/**
	 * @param tag  11315/11315
	 * @param xml
	 */
	public static void doPost(String tag,String xml){
		
		try {
			String htmlurl = PRE_URL;
			HttpPost post = new HttpPost(htmlurl);
			post.setEntity(new  StringEntity(xml,"utf-8"));
			Future<HttpResponse> future = httpAsyncClient.execute(post, null);
//            Future<HttpResponse> future = httpclient.execute(request, null);
            HttpResponse response = future.get();
            System.out.println("R: " + response.getStatusLine());
            System.out.println("Shutting down");
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
        }
	}
	
//	public static void doPost(String tag, String xml) {
//		
//		/* 1.生成 HttpClinet 对象并设置参数 */
//	
//			String htmlurl = PRE_URL+tag;
//			// 设置 Http 连接超时 5s
//			PostMethod method = new PostMethod(htmlurl);
//			try {
//				method.setRequestEntity(new StringRequestEntity(xml, null,"utf-8"));
////				method.addRequestHeader(
////						"User-Agent",
////						"Mozilla/5.0 (Windows NT 6.1) AppleWebKit/535.7 (KHTML, like Gecko) Chrome/16.0.912.63 Safari/535.7 360EE");
//				httpClient.executeMethod(method);
//			}catch (Exception e1) {
//				e1.printStackTrace();
//				int retry = 3;
//				while(retry > 0){
//					try {
//						int statusCode = httpClient.executeMethod(method);
//						if(statusCode == HttpStatus.SC_OK){
//							break;
//						}
//					} catch (Exception e) {
//					}
//					retry--;
//				}
//			} finally {
//				method.abort();
//				method.releaseConnection();
//			}
//	}
	
	

}
