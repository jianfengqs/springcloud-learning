package com.macro.cloud.interceptor;

import cn.hutool.core.util.StrUtil;
import com.macro.cloud.constant.CommonConstants;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;


/**
 * feign请求头拦截器
 *
 * @author zhaijianfeng
 * @date 2022/11/02
 */
@Configuration
public class FeignHeaderInterceptor implements RequestInterceptor {


    @Override
    public void apply(RequestTemplate requestTemplate) {

        String traceId = MDC.get(CommonConstants.TRACE_ID);
        if (StrUtil.isNotBlank(traceId)){
            requestTemplate.header(CommonConstants.TRACE_ID,traceId);
        }
    }
}
