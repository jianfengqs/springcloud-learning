package com.macro.cloud.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 异步工具类
 *
 * @author zhaijianfeng
 * @date 2022/10/13
 * @since 1.18.0
 */
@Component
@Slf4j
public class AsyncUtils {



    /**
     *
     */
    @Async("commonExecutor")
    public void asyncTestTraceId() {
        log.info("测试traceId异步传入");
    }



}
