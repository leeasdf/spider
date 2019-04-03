package xin.tianchuang.modules.spider.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.spider.dao.CsSfgwTaxInformationDao;
import xin.tianchuang.modules.spider.entity.CsSfgwTaxInformationEntity;
import xin.tianchuang.modules.spider.service.CsSfgwTaxInformationService;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("csSfgwTaxInformationService")
public class CsSfgwTaxInformationServiceImpl extends ServiceImpl<CsSfgwTaxInformationDao, CsSfgwTaxInformationEntity> implements CsSfgwTaxInformationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
    	String nsrmc = (String) params.get("nsrmc");
        Page<CsSfgwTaxInformationEntity> page = this.selectPage(
                new Query<CsSfgwTaxInformationEntity>(params).getPage(),
                new EntityWrapper<CsSfgwTaxInformationEntity>()
                .like(StringUtils.isNotBlank(nsrmc), "nsrmc", nsrmc) //
        );

        return new PageUtils(page);
    }

}
