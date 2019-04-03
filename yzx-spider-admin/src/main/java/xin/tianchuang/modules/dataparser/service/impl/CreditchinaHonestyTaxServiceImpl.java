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

import xin.tianchuang.common.utils.tcredit.StringUtil;
import xin.tianchuang.modules.dataparser.dao.CreditchinaHonestyTaxDao;
import xin.tianchuang.modules.dataparser.entity.CreditchinaHonestyTaxEntity;
import xin.tianchuang.modules.dataparser.service.CreditchinaHonestyTaxService;


@Service("creditchinaHonestyTaxService")
public class CreditchinaHonestyTaxServiceImpl extends ServiceImpl<CreditchinaHonestyTaxDao, CreditchinaHonestyTaxEntity> implements CreditchinaHonestyTaxService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String year= (String)params.get("year");
        String taxName=(String )params.get("taxName");

        params.put("sidx","createTime");
        params.put("order","DESC");

        Page<CreditchinaHonestyTaxEntity> page = this.selectPage(
                new Query<CreditchinaHonestyTaxEntity>(params).getPage(),
                new EntityWrapper<CreditchinaHonestyTaxEntity>()
                        .like(StringUtils.isNotBlank(taxName),"tax_name",taxName.trim())
                        .eq(StringUtils.isNotBlank(year),"year",year.trim())
                        .eq("data_status", DataStatusEnum.ACTIVE.key())
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPageByTaxName(Map<String, Object> params) {
        String taxName=(String )params.get("taxName");

        params.put("sidx","createTime");
        params.put("order","DESC");

        Page<CreditchinaHonestyTaxEntity> page = this.selectPage(
                new Query<CreditchinaHonestyTaxEntity>(params).getPage(),
                new EntityWrapper<CreditchinaHonestyTaxEntity>()
                        .eq("tax_name",taxName.trim())
                        .eq("data_status", DataStatusEnum.ACTIVE.key())
        );

        return new PageUtils(page);
    }
}
