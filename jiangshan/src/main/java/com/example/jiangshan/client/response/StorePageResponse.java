package com.example.jiangshan.client.response;

import com.example.jiangshan.client.response.BasicResponse;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author yanyuechao
 * @date 2020-05-19 19:06
 **/
@Data
@ToString(callSuper = true)
public class StorePageResponse extends BasicResponse {

    private StorePage data;

    @Data
    public static class StorePage {
        private Integer pageNo;
        private Integer pageSize;
        private Integer total;
        private List<StoreRow> rows;

        @Data
        public static class StoreRow {
            private String storeId;
            private String storeName;
            private String storeMeasure;
            private String storeDetailAddress;
            private String addressProvince;
            private String addressCity;
            private String addressCounty;
            private String addressDetail;
            private String mangerName;
            private String storeTel;
            private String mangerTel;
            private String storeNo;
            private String storeLng;
            private String storeLat;
            private String storeRemark;
            private String areaPath;
            private String insertTime;
            private String updateTime;
            private String xydm;
            private String xkzbh;
        }

    }
}
