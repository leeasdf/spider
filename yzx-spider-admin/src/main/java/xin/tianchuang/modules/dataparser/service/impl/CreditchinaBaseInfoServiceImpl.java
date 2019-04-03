package xin.tianchuang.modules.dataparser.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.dataparser.dao.CreditchinaBaseInfoDao;
import xin.tianchuang.modules.dataparser.entity.CreditchinaBaseInfoEntity;
import xin.tianchuang.modules.dataparser.enums.DataTypeEnum;
import xin.tianchuang.modules.dataparser.service.CreditchinaBaseInfoService;


@Service("creditchinaBaseInfoService")
public class CreditchinaBaseInfoServiceImpl extends ServiceImpl<CreditchinaBaseInfoDao, CreditchinaBaseInfoEntity> implements CreditchinaBaseInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String entName= (String)params.get("entName");
        String regno= (String)params.get("regno");
        String creditCode= (String)params.get("creditCode");
        params.put("sidx","createTime");
        params.put("order","DESC");

        Page<CreditchinaBaseInfoEntity> page = this.selectPage(
                new Query<CreditchinaBaseInfoEntity>(params).getPage(),
                new EntityWrapper<CreditchinaBaseInfoEntity>()
                        .like(StringUtils.isNotBlank(entName),"ent_name",entName)
                        .eq(StringUtils.isNotBlank(regno),"regno",regno)
                        .eq(StringUtils.isNotBlank(creditCode),"credit_code",creditCode)
                        .eq("data_status", DataStatusEnum.ACTIVE.key())

        );

        return new PageUtils(page);
    }

    @Override
    public CreditchinaBaseInfoEntity getByNameOrCreditCode(String name, String creditCode) {
        return selectOne(new EntityWrapper<CreditchinaBaseInfoEntity>()
                .eq(StringUtils.isNotBlank(name),"ent_name",name)
                .eq(StringUtils.isNotBlank(creditCode),"credit_code",creditCode)
                .eq("data_status", DataStatusEnum.ACTIVE.key())
        );
    }

    @Override
    public int deleteByEntName(String entName) {
        return this.baseMapper.delete(new EntityWrapper<CreditchinaBaseInfoEntity>()
                .eq("ent_name",entName)
                .eq("data_status", DataStatusEnum.ACTIVE.key())
        );
    }
}
