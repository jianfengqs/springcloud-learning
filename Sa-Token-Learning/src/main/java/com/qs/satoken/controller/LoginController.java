package com.qs.satoken.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录测试
 *
 * @author zhaijianfeng
 * @date 2023/01/13
 */
@RestController
@RequestMapping("/acc/")
public class LoginController {


    /**
     * 测试登录  ---- http://localhost:8081/acc/doLogin?name=zhang&pwd=123456
     *
     * @param name 账号
     * @param pwd  密码
     * @return {@link SaResult}
     */
    @RequestMapping("doLogin")
    public SaResult doLogin(String name, String pwd) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对 
        if ("zhang".equals(name) && "123456".equals(pwd)) {
            StpUtil.login(10001);
            return SaResult.ok("登录成功");
        }
        return SaResult.error("登录失败");
    }


    /**
     * 查询登录状态  ---- http://localhost:8081/acc/isLogin
     *
     * @return {@link SaResult}
     */
    @RequestMapping("isLogin")
    public SaResult isLogin() {
        return SaResult.ok("是否登录：" + StpUtil.isLogin());
    }

    /**
     * 查询 Token 信息  ---- http://localhost:8081/acc/tokenInfo
     *
     * @return {@link SaResult}
     */
    @RequestMapping("tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }

    /**
     * 测试注销  ---- http://localhost:8081/acc/logout
     *
     * @return {@link SaResult}
     */
    @RequestMapping("logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }

    /**
     * 查询会话相关
     *
     * @return {@link String}
     */
    @RequestMapping("sessionQuery")
    public void sessionQuery() {
// 获取当前会话账号id, 如果未登录，则抛出异常：`NotLoginException`
        Object loginId = StpUtil.getLoginId();

// 类似查询API还有：
        String loginIdAsString = StpUtil.getLoginIdAsString();// 获取当前会话账号id, 并转化为`String`类型
        int loginIdAsInt = StpUtil.getLoginIdAsInt();// 获取当前会话账号id, 并转化为`int`类型
        long loginIdAsLong = StpUtil.getLoginIdAsLong();// 获取当前会话账号id, 并转化为`long`类型

// ---------- 指定未登录情形下返回的默认值 ----------

// 获取当前会话账号id, 如果未登录，则返回null
        Object loginIdDefaultNull = StpUtil.getLoginIdDefaultNull();

// 获取当前会话账号id, 如果未登录，则返回默认值 （`defaultValue`可以为任意类型）
//        StpUtil.getLoginId(T defaultValue);


    }

}
