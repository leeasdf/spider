package xin.tianchuang.modules.dataparser.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;
import xin.tianchuang.modules.dataparser.dao.CreditchinaPubPenaltyDao;
import xin.tianchuang.modules.dataparser.entity.CreditchinaPubPenaltyEntity;
import xin.tianchuang.modules.dataparser.service.CreditchinaPubPenaltyService;

import java.util.Map;


@Service("creditchinaPubPenaltyService")
public class CreditchinaPubPenaltyServiceImpl extends ServiceImpl<CreditchinaPubPenaltyDao, CreditchinaPubPenaltyEntity> implements CreditchinaPubPenaltyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String entName=(String)params.get("cfXdrMc");
        String legal=(String) params.get("cfFr");

        params.put("sidx","createTime");
        params.put("order","DESC");

        Page<CreditchinaPubPenaltyEntity> page = this.selectPage(
                new Query<CreditchinaPubPenaltyEntity>(params).getPage(),
                new EntityWrapper<CreditchinaPubPenaltyEntity>()
                        .like(StringUtils.isNotBlank(entName),"cf_xdr_mc",entName)
                        .like(StringUtils.isNotBlank(legal),"cf_fr",legal)
                        .eq("data_status", DataStatusEnum.ACTIVE.key())
        );

        return new PageUtils(page);
    }

    @Override
    public int deleteByEntName(String entName) {
        return this.baseMapper.delete(new EntityWrapper<CreditchinaPubPenaltyEntity>()
                .eq("cf_xdr_mc",entName.trim())
                .eq("data_status", DataStatusEnum.ACTIVE.key()));
    }

    @Override
    public PageUtils queryPageByCfXdrMc(Map<String, Object> params) {
        String entName=(String)params.get("cfXdrMc");

        params.put("sidx","createTime");
        params.put("order","DESC");

        Page<CreditchinaPubPenaltyEntity> page = this.selectPage(
                new Query<CreditchinaPubPenaltyEntity>(params).getPage(),
                new EntityWrapper<CreditchinaPubPenaltyEntity>()
                        .eq("cf_xdr_mc",entName)
                        .eq("data_status", DataStatusEnum.ACTIVE.key())
        );

        return new PageUtils(page);
    }
}
