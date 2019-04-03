package xin.tianchuang.modules.dataparser.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.dataparser.dao.CreditchinaCreditTypeRecordDao;
import xin.tianchuang.modules.dataparser.entity.CreditchinaCreditTypeRecordEntity;
import xin.tianchuang.modules.dataparser.service.CreditchinaCreditTypeRecordService;


@Service("creditchinaCreditTypeRecordService")
public class CreditchinaCreditTypeRecordServiceImpl extends ServiceImpl<CreditchinaCreditTypeRecordDao, CreditchinaCreditTypeRecordEntity> implements CreditchinaCreditTypeRecordService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        params.put("sidx","createTime");
        params.put("order","DESC");

        Page<CreditchinaCreditTypeRecordEntity> page = this.selectPage(
                new Query<CreditchinaCreditTypeRecordEntity>(params).getPage(),
                new EntityWrapper<CreditchinaCreditTypeRecordEntity>()
                        .eq("data_status", DataStatusEnum.ACTIVE.key())
        );

        return new PageUtils(page);
    }

    @Override
    public List<CreditchinaCreditTypeRecordEntity> selectByEntName(String entName) {
        return selectList(new EntityWrapper<CreditchinaCreditTypeRecordEntity>()
                .eq("ent_name",entName)
                .eq("data_status", DataStatusEnum.ACTIVE.key()));
    }

    @Override
    public int deleteByEntName(String entName) {
        return this.baseMapper.delete(new EntityWrapper<CreditchinaCreditTypeRecordEntity>()
                .eq("ent_name",entName)
                .eq("data_status", DataStatusEnum.ACTIVE.key()));
    }

}
