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

import xin.tianchuang.modules.dataparser.dao.CreditchinaPubPermissionDao;
import xin.tianchuang.modules.dataparser.entity.CreditchinaPubPermissionEntity;
import xin.tianchuang.modules.dataparser.service.CreditchinaPubPermissionService;


@Service("creditchinaPubPermissionService")
public class CreditchinaPubPermissionServiceImpl extends ServiceImpl<CreditchinaPubPermissionDao, CreditchinaPubPermissionEntity> implements CreditchinaPubPermissionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String entName=(String)params.get("xkXdr");
        String legal =(String) params.get("xkFr");

        params.put("sidx","createTime");
        params.put("order","DESC");

        Page<CreditchinaPubPermissionEntity> page = this.selectPage(
                new Query<CreditchinaPubPermissionEntity>(params).getPage(),
                new EntityWrapper<CreditchinaPubPermissionEntity>()
                        .like(StringUtils.isNotBlank(entName),"xk_xdr",entName.trim())
                        .like(StringUtils.isNotBlank(legal),"xk_fr",legal.trim())
                        .eq("data_status", DataStatusEnum.ACTIVE.key())
        );

        return new PageUtils(page);
    }

    @Override
    public int deleteByEntName(String entName) {
        return this.baseMapper.delete(new EntityWrapper<CreditchinaPubPermissionEntity>()
                .eq("xk_xdr",entName.trim())
                .eq("data_status", DataStatusEnum.ACTIVE.key())
        );
    }

    @Override
    public PageUtils queryPageByXkXdr(Map<String, Object> params) {
        String entName=(String)params.get("xkXdr");

        params.put("sidx","createTime");
        params.put("order","DESC");

        Page<CreditchinaPubPermissionEntity> page = this.selectPage(
                new Query<CreditchinaPubPermissionEntity>(params).getPage(),
                new EntityWrapper<CreditchinaPubPermissionEntity>()
                        .eq("xk_xdr",entName.trim())
                        .eq("data_status", DataStatusEnum.ACTIVE.key())
        );

        return new PageUtils(page);
    }
}
