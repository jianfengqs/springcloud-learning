package com.qs.listtener.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qs.listtener.dataobject.MsgFailLogDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 【消息失败日志表】生产者多次投递消息失败，做记录日志处理 Mapper 接口
 * </p>
 *
 * @author zhaijianfeng
 * @since 2022-08-01
 */
@Mapper
public interface MsgFailLogMapper extends BaseMapper<MsgFailLogDO> {

}
