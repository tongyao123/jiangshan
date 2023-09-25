package com.example.jiangshan.service.domain;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jiangshan.controller.vo.ChannelVO;
import com.example.jiangshan.client.OpenBasicClient;
import com.example.jiangshan.client.response.ChannelPageResponse;
import com.example.jiangshan.client.response.DevicePageResponse;
import com.example.jiangshan.client.response.LiveVideoAddressResponse;
import com.example.jiangshan.client.response.LiveVideoOpenResponse;
import com.example.jiangshan.constant.ChannelTypeEnum;
import com.example.jiangshan.constant.ExceptionEnum;
import com.example.jiangshan.mapper.domain.DeviceChannelMapper;
import com.example.jiangshan.entity.DeviceChannel;
import com.example.jiangshan.exception.BusinessException;

import lombok.extern.slf4j.Slf4j;

/**
 * 开发者服务Demo通道管理
 */
@Service
@Slf4j
public class ChannelService {

    @Autowired
    private OpenBasicClient openBasicClient;
    @Autowired

    private DeviceChannelMapper channelMapper;


    public List<ChannelVO> listChannels(String deviceSerial) {

        List<DeviceChannel> deviceChannels = channelMapper.listChannelsBySerial(deviceSerial);
        if (CollectionUtils.isEmpty(deviceChannels)) {
            List<ChannelPageResponse.ChannelPage.ChannelRow> channelResponses = openBasicClient
                    .listChannels(deviceSerial);
            channelMapper.batchInsert(toChannels(channelResponses));
            return toChannelVOs(channelMapper.listChannelsBySerial(deviceSerial));
        }
        return toChannelVOs(deviceChannels);
    }

    public LiveVideoOpenResponse.LiveVideoConfig liveVideoOpen(String deviceSerial, Integer channelNo) {
        DeviceChannel deviceChannel = channelMapper.selectByChannel(deviceSerial, channelNo);
        if (deviceChannel == null) {
            throw new BusinessException(ExceptionEnum.CHANNEL_NOT_EXIST);
        }
        return openBasicClient.liveVideoOpen(deviceChannel.getChannelId()).getData().get(0);
    }

    public LiveVideoAddressResponse.LiveVideoAddress getLiveVideoAddress(String deviceSerial, Integer channelNo) {
        DeviceChannel deviceChannel = channelMapper.selectByChannel(deviceSerial, channelNo);
        if (deviceChannel == null) {
            throw new BusinessException(ExceptionEnum.CHANNEL_NOT_EXIST);
        }
        return openBasicClient.getLiveVideoAddress(deviceChannel.getChannelId()).getData();
    }

    private List<DeviceChannel> toChannels(List<ChannelPageResponse.ChannelPage.ChannelRow> channelResponses) {

        return channelResponses.stream()
                .map(channel -> DeviceChannel.aBuilder.aDeviceChannel().setChannelId(channel.getChannelId())
                        .setChannelName(channel.getChannelName()).setChannelNo(channel.getChannelNo())
                        .setChannelStatus(channel.getChannelStatus()).setChannelType(channel.getChannelType())
                        .setDeviceSerial(channel.getDeviceSerial()).build())
                .collect(Collectors.toList());
    }

    private List<ChannelVO> toChannelVOs(List<DeviceChannel> deviceChannels) {

        return deviceChannels.stream().map(deviceChannel -> ChannelVO.aBuilder.aChannelVO().setChannelId(deviceChannel
                        .getChannelId()).setChannelName(deviceChannel.getChannelName())
                .setChannelNo(deviceChannel.getChannelNo()).setChannelStatus(deviceChannel.getChannelStatus())
                .setDeviceSerial(deviceChannel.getDeviceSerial())
                .setChannelType(ChannelTypeEnum.getChannelTypeById(deviceChannel.getChannelType()))
                .build()).collect(Collectors.toList());
    }

    public void batchAddChannels(List<DevicePageResponse.DevicePage.DeviceRow> deviceRows) {

        if (CollectionUtils.isNotEmpty(deviceRows)) {
            List<ChannelPageResponse.ChannelPage.ChannelRow> channelRows = deviceRows.stream()
                    .map(deviceRow -> openBasicClient
                            .listChannels(deviceRow.getDeviceSerial()))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
            channelMapper.batchInsert(toChannels(channelRows));
        }
    }
}
