package xin.tianchuang.modules.dataparser.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by lee on 2018/10/25.
 * 企业名称标示注解
 * 主要是用于信用湖南红名单 黑名单 重点关注的动态增加的表数据定于企业名称的列
 */
@Target({ ElementType.PARAMETER, ElementType.TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EntName {
}
