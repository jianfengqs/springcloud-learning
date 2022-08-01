package com.qs.listtener.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 【消息失败日志表】生产者多次投递消息失败，做记录日志处理
 * </p>
 *
 * @author zhaijianfeng
 * @since 2022-08-01
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("msg_fail_log")
public class MsgFailLogDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id自增长
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 状态：0-未投递，1-已投递，2-投递失败
     */
    @TableField("`status`")
    private Boolean status;

    /**
     * 数据id，表的主键id
     */
    @TableField("data_id")
    private Integer dataId;

    /**
     * 确认回调的beanName
     */
    @TableField("confirm_callback_bean_name")
    private String confirmCallbackBeanName;

    /**
     * 回调的beanName
     */
    @TableField("return_callback_bean_name")
    private String returnCallbackBeanName;

    /**
     * 交换机
     */
    @TableField("`exchange`")
    private String exchange;

    /**
     * 队列
     */
    @TableField("queue")
    private String queue;

    /**
     * 路由key
     */
    @TableField("routing_key")
    private String routingKey;

    /**
     * 投递失败的消息
     */
    @TableField("fail_msg")
    private String failMsg;

    /**
     * 业务场景描述
     */
    @TableField("biz_scene_desc")
    private String bizSceneDesc;

    /**
     * 创建时间
     */
    @TableField("created_time")
    private LocalDateTime createdTime;

    /**
     * 修改时间
     */
    @TableField("updated_time")
    private LocalDateTime updatedTime;


}
