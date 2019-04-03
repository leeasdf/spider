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

import xin.tianchuang.modules.dataparser.dao.CreditchinaBlackLawDao;
import xin.tianchuang.modules.dataparser.entity.CreditchinaBlackLawEntity;
import xin.tianchuang.modules.dataparser.service.CreditchinaBlackLawService;


@Service("creditchinaBlackLawService")
public class CreditchinaBlackLawServiceImpl extends ServiceImpl<CreditchinaBlackLawDao, CreditchinaBlackLawEntity> implements CreditchinaBlackLawService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String dishonestName = (String) params.get("dishonestName") ;
        String enterpriseLegal= (String) params.get("enterpriseLegal");

        params.put("sidx","createTime");
        params.put("order","DESC");

        Page<CreditchinaBlackLawEntity> page = this.selectPage(
                new Query<CreditchinaBlackLawEntity>(params).getPage(),
                new EntityWrapper<CreditchinaBlackLawEntity>()
                        .like(StringUtils.isNotBlank(dishonestName),"dishonest_name",dishonestName)
                        .like(StringUtils.isNotBlank(enterpriseLegal),"enterprise_legal",enterpriseLegal)
                        .eq("data_status", DataStatusEnum.ACTIVE.key())
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPageByDishonestName(Map<String, Object> params) {
        String dishonestName = (String) params.get("dishonestName") ;

        params.put("sidx","createTime");
        params.put("order","DESC");

        Page<CreditchinaBlackLawEntity> page = this.selectPage(
                new Query<CreditchinaBlackLawEntity>(params).getPage(),
                new EntityWrapper<CreditchinaBlackLawEntity>()
                        .eq("dishonest_name",dishonestName)
                        .eq("data_status", DataStatusEnum.ACTIVE.key())
        );
        return new PageUtils(page);
    }
}
