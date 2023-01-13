package com.macro.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池配置
 *
 * @author zhaijianfeng
 * @date 2022/10/20
 */
@Configuration
public class ThreadPoolConfig {

    /**
     * 线程池
     *
     * @return {@link Executor}
     */
    @Bean
    public Executor commonExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数量
        executor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        // 设置最大线程池大小
        executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors() * 2);
        // 设置队列容量为300个
        executor.setQueueCapacity(300);
        executor.setThreadNamePrefix("micro-oauth2-api-");
        // 由调用线程处理该任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 线城池等待其它任务完成再销毁
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 设置线城池的等待时间,如果超过这个时间还没有销毁就强制销毁.
        executor.setAwaitTerminationSeconds(60);
        executor.initialize();
        return executor;
    }


}
