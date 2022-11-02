package com.macro.cloud.controller;

import com.macro.cloud.domain.UserDTO;
import com.macro.cloud.holder.LoginUserHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/currentUser")
    public UserDTO currentUser() {
        log.info("打印日志");
        return loginUserHolder.getCurrentUser();
    }

}
