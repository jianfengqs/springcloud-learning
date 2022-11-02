package com.macro.cloud.config;

import com.macro.cloud.interceptor.TraceIdInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 拦截器适配器配置
 *
 * @author zhaijianfeng
 * @date 2022/11/02
 */
@Configuration
public class InterceptorAdapterConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //将加一个拦截器，检查会话，所有的请求都经过此拦截器
        registry.addInterceptor(new TraceIdInterceptor()).addPathPatterns("/**");
    }
}
