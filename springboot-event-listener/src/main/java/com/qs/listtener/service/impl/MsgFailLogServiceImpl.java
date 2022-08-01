package com.qs.listtener.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qs.listtener.dataobject.MsgFailLogDO;
import com.qs.listtener.mapper.MsgFailLogMapper;
import com.qs.listtener.service.MsgFailLogService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 【消息失败日志表】生产者多次投递消息失败，做记录日志处理 服务实现类
 * </p>
 *
 * @author zhaijianfeng
 * @since 2022-08-01
 */
@Service
public class MsgFailLogServiceImpl extends ServiceImpl<MsgFailLogMapper, MsgFailLogDO> implements MsgFailLogService {

    @Override
    public List<MsgFailLogDO> test() {
        List<MsgFailLogDO> list = list();
        MsgFailLogDO list1 = getById(1);
        return list;
    }
}
