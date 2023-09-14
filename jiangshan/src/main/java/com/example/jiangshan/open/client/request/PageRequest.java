package com.example.jiangshan.open.client.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yanyuechao
 * @date 2020-06-09 17:20
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequest {
    private Integer pageNo;
    private Integer pageSize;
}
