package com.example.jiangshan.controller;

import com.example.jiangshan.controller.param.DeviceAddParam;
import com.example.jiangshan.controller.vo.DeviceVO;
import com.example.jiangshan.service.domain.CustomizationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Date: 2023/11/21
 * @Author: Xiao Lee
 * @Description:海康开发者服务，客流门店相关接口
 */
@RestController
@RequestMapping("/demo/customization")
public class CustomizationController {
    @Autowired
    CustomizationService customizationService;

    @CrossOrigin
    @ApiOperation(value = "查询所有门店")
    @PostMapping("/storeInfo")
    public HttpResult<List> storeInfo(@RequestBody DeviceAddParam deviceAddParam) {

        return customizationService.storeInfo(deviceAddParam);


    }
}
