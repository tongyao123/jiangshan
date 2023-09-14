package com.example.jiangshan.open.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jiangshan.open.api.param.DeviceAddParam;
import com.example.jiangshan.open.api.param.DeviceEncryptOffParam;
import com.example.jiangshan.open.api.vo.DeviceVO;
import com.example.jiangshan.open.service.DeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 开发者服务demo-设备管理相关API
 */
@RestController
@RequestMapping("/demo/devices")
@Api(value = "Device_Controller")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @CrossOrigin
    @ApiOperation(value = "注册设备")
    @PostMapping("/add")
    public HttpResult addDevice(@RequestBody DeviceAddParam deviceAddParam) {

        deviceService.addDevice(deviceAddParam);
        return new HttpResult<>();

    }

    @CrossOrigin
    @ApiOperation(value = "查看设备列表")
    @GetMapping("/list")
    public HttpResult<List<DeviceVO>> listDevices(@RequestParam(value = "groupId", required = false) String groupId) {

        List<DeviceVO> deviceVOs = deviceService.listDevices(groupId);
        return new HttpResult<>(deviceVOs);
    }

    @CrossOrigin
    @ApiOperation(value = "关闭视频加密")
    @PostMapping("/actions/encrypt/off")
    public HttpResult<String> encryptOff(@RequestBody DeviceEncryptOffParam param) {

        deviceService.encryptOff(param);
        return new HttpResult<>();
    }

}
