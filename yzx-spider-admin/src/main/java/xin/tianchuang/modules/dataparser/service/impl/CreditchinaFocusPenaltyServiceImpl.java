package xin.tianchuang.modules.dataparser.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import xin.tianchuang.common.enums.DataStatusEnum;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.Query;

import xin.tianchuang.modules.dataparser.dao.CreditchinaFocusPenaltyDao;
import xin.tianchuang.modules.dataparser.entity.CreditchinaFocusPenaltyEntity;
import xin.tianchuang.modules.dataparser.service.CreditchinaFocusPenaltyService;


@Service("creditchinaFocusPenaltyService")
public class CreditchinaFocusPenaltyServiceImpl extends ServiceImpl<CreditchinaFocusPenaltyDao, CreditchinaFocusPenaltyEntity> implements CreditchinaFocusPenaltyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        params.put("sidx","createTime");
        params.put("order","DESC");

        String obj=(String) params.get("punishmentObject");
        Page<CreditchinaFocusPenaltyEntity> page = this.selectPage(
                new Query<CreditchinaFocusPenaltyEntity>(params).getPage(),
                new EntityWrapper<CreditchinaFocusPenaltyEntity>()
                        .like(StringUtils.isNotBlank(obj),"punishment_object",obj)
                        .eq("data_status", DataStatusEnum.ACTIVE.key())
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPageByPunishmentObject(Map<String, Object> params) {

        params.put("sidx","createTime");
        params.put("order","DESC");

        String obj=(String) params.get("punishmentObject");
        Page<CreditchinaFocusPenaltyEntity> page = this.selectPage(
                new Query<CreditchinaFocusPenaltyEntity>(params).getPage(),
                new EntityWrapper<CreditchinaFocusPenaltyEntity>()
                        .eq("punishment_object",obj)
                        .eq("data_status", DataStatusEnum.ACTIVE.key())
        );

        return new PageUtils(page);
    }
}
