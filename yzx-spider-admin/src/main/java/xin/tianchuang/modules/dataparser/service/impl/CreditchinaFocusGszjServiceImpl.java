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

import xin.tianchuang.modules.dataparser.dao.CreditchinaFocusGszjDao;
import xin.tianchuang.modules.dataparser.entity.CreditchinaFocusGszjEntity;
import xin.tianchuang.modules.dataparser.service.CreditchinaFocusGszjService;


@Service("creditchinaFocusGszjService")
public class CreditchinaFocusGszjServiceImpl extends ServiceImpl<CreditchinaFocusGszjDao, CreditchinaFocusGszjEntity> implements CreditchinaFocusGszjService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        params.put("sidx","createTime");
        params.put("order","DESC");

        String regNo=(String )params.get("regNo");
        String enterpriseName=(String )params.get("enterpriseName");
        String legal=(String )params.get("legal");
        Page<CreditchinaFocusGszjEntity> page = this.selectPage(
                new Query<CreditchinaFocusGszjEntity>(params).getPage(),
                new EntityWrapper<CreditchinaFocusGszjEntity>()
                        .eq(StringUtils.isNotBlank(regNo),"reg_no",regNo)
                        .like(StringUtils.isNotBlank(enterpriseName),"enterprise_name",enterpriseName)
                        .like(StringUtils.isNotBlank(legal),"legal",legal)
                        .eq("data_status", DataStatusEnum.ACTIVE.key())
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPageByEnterpriseName(Map<String, Object> params) {

        params.put("sidx","createTime");
        params.put("order","DESC");

        String enterpriseName=(String )params.get("enterpriseName");
        Page<CreditchinaFocusGszjEntity> page = this.selectPage(
                new Query<CreditchinaFocusGszjEntity>(params).getPage(),
                new EntityWrapper<CreditchinaFocusGszjEntity>()
                        .eq("enterprise_name",enterpriseName)
                        .eq("data_status", DataStatusEnum.ACTIVE.key())

        );

        return new PageUtils(page);
    }
}
