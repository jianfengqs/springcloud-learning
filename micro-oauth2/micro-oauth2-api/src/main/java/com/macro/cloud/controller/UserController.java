package com.macro.cloud.controller;

import com.macro.cloud.domain.UserDTO;
import com.macro.cloud.holder.LoginUserHolder;
import com.macro.cloud.util.AsyncUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 获取登录用户信息接口
 * Created by macro on 2020/6/19.
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController{

    @Autowired
    private LoginUserHolder loginUserHolder;

    @Resource
    private AsyncUtils asyncUtils;

    @GetMapping("/currentUser")
    public UserDTO currentUser() {
        asyncUtils.asyncTestTraceId();
        log.info("打印日志");
        UserDTO currentUser = loginUserHolder.getCurrentUser();

        return currentUser;
    }

}
