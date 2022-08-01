package com.qs.listtener.controller;


import com.qs.listtener.dataobject.MsgFailLogDO;
import com.qs.listtener.service.MsgFailLogService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 【消息失败日志表】生产者多次投递消息失败，做记录日志处理 前端控制器
 * </p>
 *
 * @author zhaijianfeng
 * @since 2022-08-01
 */
@RestController
@RequestMapping("/msgFailLogDO")
public class MsgFailLogController {

    @Resource
    private MsgFailLogService msgFailLogService;


    @GetMapping(value = "test")
    public List<MsgFailLogDO> test() {
        return msgFailLogService.test();
    }

}

