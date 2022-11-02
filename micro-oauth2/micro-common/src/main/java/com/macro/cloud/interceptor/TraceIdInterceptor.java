package com.macro.cloud.interceptor;

import cn.hutool.core.lang.UUID;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.macro.cloud.constant.CommonConstants;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 跟踪id拦截器
 *
 * @author zhaijianfeng
 * @date 2022/11/02
 */
@Component
public class TraceIdInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果有上层调用就用上层的ID
        String traceId = request.getHeader(CommonConstants.TRACE_ID);
        if (traceId == null) {
            traceId = UUID.randomUUID(true).toString();
        }
        MDC.put(CommonConstants.TRACE_ID, traceId);
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        MDC.remove(CommonConstants.TRACE_ID);
    }

}
