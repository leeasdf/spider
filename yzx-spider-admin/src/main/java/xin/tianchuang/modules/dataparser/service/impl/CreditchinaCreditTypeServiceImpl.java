package xin.tianchuang.modules.dataparser.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.dataparser.dao.CreditchinaCreditTypeDao;
import xin.tianchuang.modules.dataparser.entity.CreditchinaCreditTypeEntity;
import xin.tianchuang.modules.dataparser.enums.CreditChinaCreditTypeEnum;
import xin.tianchuang.modules.dataparser.service.CreditchinaCreditTypeService;


@Service("creditchinaCreditTypeService")
public class CreditchinaCreditTypeServiceImpl extends ServiceImpl<CreditchinaCreditTypeDao, CreditchinaCreditTypeEntity> implements CreditchinaCreditTypeService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        params.put("sidx","createTime");
        params.put("order","DESC");

        Page<CreditchinaCreditTypeEntity> page = this.selectPage(
                new Query<CreditchinaCreditTypeEntity>(params).getPage(),
                new EntityWrapper<CreditchinaCreditTypeEntity>()
                        .eq("data_status", DataStatusEnum.ACTIVE.key())
        );

        return new PageUtils(page);
    }

    @Override
    public List<CreditchinaCreditTypeEntity> getAllCreditTypeEntity() {
        return selectList(new EntityWrapper<CreditchinaCreditTypeEntity>().eq("data_status", DataStatusEnum.ACTIVE.key()));
    }

    @Override
    public List<CreditchinaCreditTypeEntity> getByCreditType(CreditChinaCreditTypeEnum creditType) {
        return selectList(new EntityWrapper<CreditchinaCreditTypeEntity>()
                .eq("credit_type",creditType.getValue())
                .eq("data_status", DataStatusEnum.ACTIVE.key()));

    }
}
