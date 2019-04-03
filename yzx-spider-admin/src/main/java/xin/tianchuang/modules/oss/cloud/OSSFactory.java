
package xin.tianchuang.modules.oss.cloud;


import xin.tianchuang.common.component.spring.SpringContextUtils;
import xin.tianchuang.common.constant.ConfigConstant;
import xin.tianchuang.common.constant.Constant;
import xin.tianchuang.modules.sys.service.SysConfigService;

/**
 * 文件上传Factory
 * @author hui.deng
 * 
 * @date 2017-03-26 10:18
 */
public final class OSSFactory {
    private static SysConfigService sysConfigService;

    static {
        OSSFactory.sysConfigService = (SysConfigService) SpringContextUtils.getBean("sysConfigService");
    }

    public static CloudStorageService build(){
        //获取云存储配置信息
        CloudStorageConfig config = sysConfigService.getConfigObject(ConfigConstant.CLOUD_STORAGE_CONFIG_KEY, CloudStorageConfig.class);

        if(config.getType() == Constant.CloudService.QINIU.getValue()){
            return new QiniuCloudStorageService(config);
        }else if(config.getType() == Constant.CloudService.ALIYUN.getValue()){
            return new AliyunCloudStorageService(config);
        }else if(config.getType() == Constant.CloudService.QCLOUD.getValue()){
            return new QcloudCloudStorageService(config);
        }else if (config.getType()== Constant.CloudService.TCREDIT.getValue()){
            return new TcreditCloudStorageService(config);
        }

        return null;
    }

}
