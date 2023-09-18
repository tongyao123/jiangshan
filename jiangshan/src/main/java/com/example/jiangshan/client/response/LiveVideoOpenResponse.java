package com.example.jiangshan.client.response;

import java.util.List;

import lombok.Data;

@Data
public class LiveVideoOpenResponse extends BasicResponse {

    private List<LiveVideoConfig> data;

    @Data
    public static class LiveVideoConfig {
        /**
         * 设备序列号
         */
        private String deviceSerial;
        /**
         * 通道号
         */
        private Integer channelNo;
        /**
         * 设备开通状态码，参考萤石返回码
         */
        private String ret;
        /**
         * 设备开通状态描述
         */
        private String desc;
    }
}
