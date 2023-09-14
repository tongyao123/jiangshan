package com.example.jiangshan.open.client.response;

import java.util.List;

import lombok.Data;
import lombok.ToString;

/**
 * @author yanyuechao
 * @date 2020-05-19 19:06
 **/
@Data
@ToString(callSuper =true)
public class ChannelPageResponse extends BasicResponse{

    private ChannelPage data;

    @Data
    public static class ChannelPage {
        private Integer pageNo;
        private Integer pageSize;
        private Integer total;
        private List<ChannelRow> rows;

        @Data
        public static class ChannelRow {
            private String deviceSerial;
            private String channelId;
            private String channelName;
            private Integer channelNo;
            private Integer channelStatus;
            private String channelType;
        }

    }
}
