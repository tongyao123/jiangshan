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

import com.example.jiangshan.open.api.param.ChannelParam;
import com.example.jiangshan.open.api.vo.ChannelVO;
import com.example.jiangshan.open.client.response.LiveVideoAddressResponse.LiveVideoAddress;
import com.example.jiangshan.open.client.response.LiveVideoOpenResponse.LiveVideoConfig;
import com.example.jiangshan.open.service.ChannelService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 开发者服务demo-通道管理相关API
 */
@Api(value = "Channel_Controller")
@RestController
@RequestMapping("/demo/channels")
public class ChannelController {
    @Autowired
    private ChannelService channelService;

    @CrossOrigin
    @GetMapping("/list")
    @ApiOperation(value = "获取设备下通道列表")
    public HttpResult<List<ChannelVO>> listChannels(@RequestParam("deviceSerial") String deviceSerial) {
        return new HttpResult<>(channelService.listChannels(deviceSerial));
    }

    @CrossOrigin
    @PostMapping("/actions/live/video/open")
    @ApiOperation(value = "开通直播")
    public HttpResult<LiveVideoConfig> liveVideoOpen(@RequestBody ChannelParam param) {
        return new HttpResult<>(channelService.liveVideoOpen(param.getDeviceSerial(), param.getChannelNo()));
    }

    @CrossOrigin
    @PostMapping("/actions/live/video/address")
    @ApiOperation(value = "获取直播地址")
    public HttpResult<LiveVideoAddress> getLiveVideoAddress(@RequestBody ChannelParam param) {
        return new HttpResult<>(channelService.getLiveVideoAddress(param.getDeviceSerial(), param.getChannelNo()));
    }

}
