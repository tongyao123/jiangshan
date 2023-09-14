package com.example.jiangshan.open.client.response;

import lombok.Data;

@Data
public class LiveVideoAddressResponse extends BasicResponse {

    private LiveVideoAddress data;

    @Data
    public static class LiveVideoAddress {
        /**
         * 状态码，参考下方返回码。优先判断该错误码，返回200即表示成功。
         */
        private String ret;
        /**
         * 状态描述
         */
        private String desc;
        /**
         * 设备序列号
         */
        private String deviceSerial;
        /**
         * 通道号
         */
        private Integer channelNo;
        /**
         * 设备名称
         */
        private String deviceName;
        /**
         * HLS流畅直播地址
         */
        private String hls;
        /**
         * HLS高清直播地址
         */
        private String hlsHd;
        /**
         * RTMP流畅直播地址
         */
        private String rtmp;
        /**
         * RTMP高清直播地址
         */
        private String rtmpHd;
        /**
         * 开始时间，long格式如1472694964067，精确到毫秒。expireTime参数为空时该字段无效
         */
        private Long beginTime;
        /**
         * 过期时间，long格式如1472794964067，精确到毫秒。expireTime参数为空时该字段无效
         */
        private Long endTime;
        /**
         * 地址使用状态：0-未使用或直播已关闭，1-使用中，2-已过期，3-直播已暂停，0状态不返回地址，其他返回。-1表示ret不返回200时的异常情况，参考ret返回错误码。
         */
        private Integer status;
        /**
         * 地址异常状态：0-正常，1-设备不在线，2-设备开启视频加密，3-设备删除，4-失效，5-未绑定，6-账户下流量已超出，7-设备接入限制，0/1/2/6状态返回地址，其他不返回。-1表示ret不返回200时的异常情况，参考ret返回错误码。
         */
        private Integer exception;
    }
}
