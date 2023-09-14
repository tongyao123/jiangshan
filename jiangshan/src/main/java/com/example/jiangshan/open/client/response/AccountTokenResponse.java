package com.example.jiangshan.open.client.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * <p>取流认证token</p>
 *
 * @author  zhangkai21  
 * @date 2020年5月26日 下午8:47:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountTokenResponse extends BasicResponse {

    private Account data;

    @Data
    public static class Account {
        private String appKey;
        private String token;
    }
}
