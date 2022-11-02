package com.macro.cloud.filter;

import cn.hutool.core.lang.UUID;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 跟踪id过滤器
 *
 * @author zhaijianfeng
 * @date 2022/11/02
 */
@Slf4j
@Component
public class TraceIdFilter implements GlobalFilter, Ordered {

    private static final String TRACE_ID = "traceId";
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String traceId = UUID.randomUUID().toString(true);
        ServerHttpRequest req = request.mutate().headers(httpHeaders -> {
            // httpHeaders 封装了所有的请求头

            MDC.put(TRACE_ID, traceId);
            httpHeaders.set(TRACE_ID, traceId);
        }).build();

        response.getHeaders().add(TRACE_ID, traceId);
        // 设置增强的request到exchange对象中
        exchange.mutate().request(req);

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }
}
