package com.qs.satoken;

import cn.dev33.satoken.SaManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * sa-token演示应用程序
 *
 * @author zhaijianfeng
 * @date 2023/01/13
 */
@SpringBootApplication
public class SaTokenDemoApplication {
    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(SaTokenDemoApplication.class, args);
        System.out.println("启动成功：Sa-Token配置如下：" + SaManager.getConfig());
    }
}
