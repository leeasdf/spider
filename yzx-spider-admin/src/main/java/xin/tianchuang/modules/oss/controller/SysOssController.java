
package xin.tianchuang.modules.oss.controller;

import com.google.gson.Gson;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import xin.tianchuang.common.constant.ConfigConstant;
import xin.tianchuang.common.constant.Constant;
import xin.tianchuang.common.exception.SpiderException;
import xin.tianchuang.common.utils.PageUtils;
import xin.tianchuang.common.utils.R;
import xin.tianchuang.common.validator.ValidatorUtils;
import xin.tianchuang.common.validator.group.AliyunGroup;
import xin.tianchuang.common.validator.group.QcloudGroup;
import xin.tianchuang.common.validator.group.QiniuGroup;
import xin.tianchuang.common.validator.group.TcreditGroup;
import xin.tianchuang.modules.oss.cloud.CloudStorageConfig;
import xin.tianchuang.modules.oss.cloud.OSSFactory;
import xin.tianchuang.modules.oss.entity.SysOssEntity;
import xin.tianchuang.modules.oss.service.SysOssService;
import xin.tianchuang.modules.sys.service.SysConfigService;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * 文件上传
 * 
 * @author hui.deng
 * 
 * @date 2017-03-25 12:13:26
 */
@RestController
@RequestMapping("sys/oss")
public class SysOssController {
	@Autowired
	private SysOssService sysOssService;
    @Autowired
    private SysConfigService sysConfigService;

    private final static String KEY = ConfigConstant.CLOUD_STORAGE_CONFIG_KEY;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("sys:oss:all")
	public R list(@RequestParam Map<String, Object> params){
		PageUtils page = sysOssService.queryPage(params);

		return R.ok().put("page", page);
	}


    /**
     * 云存储配置信息
     */
    @GetMapping("/config")
    @RequiresPermissions("sys:oss:all")
    public R config(){
        CloudStorageConfig config = sysConfigService.getConfigObject(KEY, CloudStorageConfig.class);

        return R.ok().put("config", config);
    }


	/**
	 * 保存云存储配置信息
	 */
	@PostMapping("/saveConfig")
	@RequiresPermissions("sys:oss:all")
	public R saveConfig(@RequestBody CloudStorageConfig config){
		//校验类型
		ValidatorUtils.validateEntity(config);

		if(config.getType() == Constant.CloudService.QINIU.getValue()){
			//校验七牛数据
			ValidatorUtils.validateEntity(config, QiniuGroup.class);
		}else if(config.getType() == Constant.CloudService.ALIYUN.getValue()){
			//校验阿里云数据
			ValidatorUtils.validateEntity(config, AliyunGroup.class);
		}else if(config.getType() == Constant.CloudService.QCLOUD.getValue()){
			//校验腾讯云数据
			ValidatorUtils.validateEntity(config, QcloudGroup.class);
		}else if (config.getType() == Constant.CloudService.TCREDIT.getValue()){
			//校验天创云
			ValidatorUtils.validateEntity(config, TcreditGroup.class);
		}
        sysConfigService.updateValueByKey(KEY, new Gson().toJson(config));

		return R.ok();
	}
	

	/**
	 * 上传文件
	 */
	@PostMapping("/upload")
	@RequiresPermissions("sys:oss:all")
	public R upload(@RequestParam("file") MultipartFile file) throws Exception {
		if (file.isEmpty()) {
			throw new SpiderException("上传文件不能为空");
		}

		//上传文件
		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String url = OSSFactory.build().uploadSuffix(file.getBytes(), suffix);

		//保存文件信息
		SysOssEntity ossEntity = new SysOssEntity();
		ossEntity.setUrl(url);
		ossEntity.setCreateDate(new Date());
		sysOssService.insert(ossEntity);

		return R.ok().put("url", url);
	}


	/**
	 * 删除
	 */
	@PostMapping("/delete")
	@RequiresPermissions("sys:oss:all")
	public R delete(@RequestBody Long[] ids){
		sysOssService.deleteBatchIds(Arrays.asList(ids));

		return R.ok();
	}

}
