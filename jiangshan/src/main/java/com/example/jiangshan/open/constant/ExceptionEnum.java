package com.example.jiangshan.open.constant;

import com.example.jiangshan.open.exception.ExceptionInfo;

/**
 * @author yanyuechao
 * @date 2020-05-19 10:59
 **/
public enum ExceptionEnum implements ExceptionInfo {


    GET_TOKEN_ERROR(10001,"获取token失败"),
    GROUP_ADD_ERROR(10002, "组新增失败"),
    PARENT_GROUP_NOT_EXIST(10003, "组的父节点不存在"),
    DEVICE_ADD_ERROR(10004, "设备新增失败"),
    GROUP_NOT_EXIST(10005, "组不存在"),
    LIST_CHANNEL_ERROR(10006, "获得通道异常"),
    PERSON_ADD_ERROR(10007, "人员新增失败"),
    PERSON_NOT_EXIST(10008,"人员不存在"),
    PERMISSION_GROUP_ADD_ERROR(10009, "组新增失败"),
    PERMISSION_GROUP_NOT_EXIST(10010,"权限组不存在" ),
    PERMISSION_ISSUE_ERROR(10011,"权限组下发失败"),
    PERMISSION_GROUP_ADD_DEVICE_ERROR(10012,"权限组添加设备失败"),
    PERMISSION_GROUP_ADD_PERSON_ERROR(10013,"权限组添加人员失败"),
    CARD_ADD_ERROR(10014, "卡号添加失败"),
    
    GET_ACCOUNT_TOKEN_ERROR(10015,"获取取流token失败"),
    
    CREATE_CONSUMER_ERROR(10090,"创建消费者失败"),
    CONSUME_MESSAGE_ERROR(10091,"消费消息失败"),
    SUBMIT_OFFSET_ERROR(10092,"提交偏移量失败"),
    
    CHANNEL_NOT_EXIST(10020, "通道不存在"),
    DEVICE_ENCRYPT_OFF_ERROR(10021, "设备关闭加密失败"),
    LIVE_VIDEO_OPEN_ERROR(10022, "开通直播失败"),
    LIVE_VIDEO_ADDRESS_ERROR(10023, "获取直播地址失败"),
    GET_DATA_ERROR(10024, "获取数据异常"),
    PERMISSION_GROUP_DEVICE_EXIST(10025,"设备已经在该权限组" ),
    PERMISSION_GROUP_PERSON_EXIST(10026,"人员已经在该权限组" ),
    ;

    private int code;
    private String message;

    ExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
