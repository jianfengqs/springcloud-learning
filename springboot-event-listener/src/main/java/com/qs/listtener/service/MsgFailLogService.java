package com.qs.listtener.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qs.listtener.dataobject.MsgFailLogDO;

import java.util.List;

/**
 * <p>
 * 【消息失败日志表】生产者多次投递消息失败，做记录日志处理 服务类
 * </p>
 *
 * @author zhaijianfeng
 * @since 2022-08-01
 */
public interface MsgFailLogService extends IService<MsgFailLogDO> {

    List<MsgFailLogDO> test();

}
