package xin.tianchuang.modules.app.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import xin.tianchuang.modules.app.interceptor.JwtAuthorizationInterceptor;
import xin.tianchuang.modules.app.resolver.LoginUserHandlerMethodArgumentResolver;

/**
 * MVC配置
 *
 * @author hui.deng
 * 
 * @date 2017-04-20 22:30
 */
@Configuration
public class AppWebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private JwtAuthorizationInterceptor authorizationInterceptor;
    @Autowired
    private LoginUserHandlerMethodArgumentResolver loginUserHandlerMethodArgumentResolver;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/app/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginUserHandlerMethodArgumentResolver);
    }
}