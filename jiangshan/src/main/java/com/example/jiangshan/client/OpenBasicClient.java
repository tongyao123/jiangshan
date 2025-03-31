package com.example.jiangshan.client;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import com.example.jiangshan.client.response.*;
import com.example.jiangshan.client.response.StorePageResponse;
import com.example.jiangshan.controller.param.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Lists;
import com.example.jiangshan.client.request.CardRequest;
import com.example.jiangshan.client.request.DeviceAddRequest;
import com.example.jiangshan.client.request.GroupAddRequest;
import com.example.jiangshan.client.request.LiveVideoOpenRequest;
import com.example.jiangshan.constant.ExceptionEnum;
import com.example.jiangshan.entity.Group;
import com.example.jiangshan.dto.OAuth2TokenDTO;
import com.example.jiangshan.util.Assert;
import com.example.jiangshan.util.HttpHelper;
import com.example.jiangshan.util.JsonUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yanyuechao
 * @date 2020-05-18 19:09
 **/
@Slf4j
@Component
public class OpenBasicClient extends BasicClient {
    /**
     * 获取云眸Token
     */
    public static final String TOKEN_URL = "/oauth/token?client_id=#{clientId}&client_secret=#{clientSecret}&grant_type=#{grantType}";

    public static final String ACCOUNT_TOKEN_URL = "/v1/ezviz/account/info";

    private static final String OPEN_BASIC_GROUP_ADD = "/api/v1/open/basic/groups/create";

    private static final String OPEN_BASIC_DEVICE_ADD = "/api/v1/open/basic/devices/create";

    private static final String OPEN_BASIC_DEVICE_ENCRYPT_OFF = "/api/v1/open/basic/devices/actions/encrypt/off";

    private static final String OPEN_BASIC_CHANNEL_LIST = "/api/v1/open/basic/channels/list?deviceSerial=#{deviceSerial}&pageNo=#{pageNo}&pageSize=#{pageSize}";

    private static final String OPEN_CHANNEL_LIVE_VIDEO_OPEN = "/api/v1/open/basic/channels/actions/live/video/open";

    private static final String OPEN_CHANNEL_LIVE_ADDRESS = "/api/v1/open/basic/channels/actions/live/address/get?channelId=#{channelId}";

    private static final String OPEN_BASIC_PERSON_ADD = "/api/v1/open/basic/persons/create";

    private static final String OPEN_BASIC_CARD_ADD = "/api/v1/open/basic/cards/batchCreate";

    private static final String OPEN_BASIC_GROUP_LIST = "/api/v1/open/basic/groups/actions/listAll";

    private static final String OPEN_BASIC_DEVICE_LIST = "/api/v1/open/basic/devices/list?pageNo=#{pageNo}&pageSize=#{pageSize}";

    private static final String OPEN_BASIC_PERSON_LIST = "/api/v1/open/basic/persons/list?pageNo=#{pageNo}&pageSize=#{pageSize}";

    private static final String OPEN_BASIC_CARD_LIST = "/api/v1/open/basic/cards/list?employeeNo=#{employeeNo}&pageNo=#{pageNo}&pageSize=#{pageSize}";

    private static final String OPEN_BASIC_STORE_LIST = "/v1/customization/storeInfo?pageNo={pageNo}&pageSize={pageSize}&storeNo={storeNo}";
    @Value("${OPEN_URL}")
    private String host;
    @Autowired
    private RestTemplate openRestTemplate;

    public OAuth2TokenDTO getOauth2TokenDTO(String clientId, String clientSecret) {

        URI url = HttpHelper.buildURI(TOKEN_URL, false, clientId, clientSecret, "client_credentials");
        OAuth2TokenDTO oAuth2TokenDTO = openRestTemplate.postForObject(host + url, null, OAuth2TokenDTO.class);
        log.info("获取token:tokenUrl:{},clientId:{},clientSecret:{},oAuth2TokenDTO:{}", url, clientId, clientSecret,
                oAuth2TokenDTO);
        Assert.isTrue(oAuth2TokenDTO != null, ExceptionEnum.GET_TOKEN_ERROR);
        return oAuth2TokenDTO;
    }

    public AccountTokenResponse getAccountToken() {
        HttpEntity<String> request = new HttpEntity<>(null, getHttpHeaders());
        ResponseEntity<AccountTokenResponse> response = openRestTemplate.exchange(host + ACCOUNT_TOKEN_URL,
                HttpMethod.GET,
                request,
                AccountTokenResponse.class);
        log.info("获取取流token结果:", response);
        Assert.isTrue(BasicResponse.isSuccess(response) && BasicResponse.isSuccess(response.getBody()),
                response.getBody(), ExceptionEnum.GET_ACCOUNT_TOKEN_ERROR);
        return response.getBody();
    }

    public void addGroup(GroupAddParam groupAddParam, String parentNo) {

        GroupAddRequest groupAddRequest = new GroupAddRequest(groupAddParam.getGroupName(), groupAddParam.getGroupNo(),
                parentNo);
        HttpEntity<String> request = new HttpEntity<>(JsonUtil.toJson(groupAddRequest), getHttpHeaders());
        BasicResponse openResult = openRestTemplate.postForObject(host + OPEN_BASIC_GROUP_ADD, request,
                BasicResponse.class);
        log.info("addGroup,groupAddParam:{} basicResponse:{}", groupAddParam, openResult);
        Assert.isTrue(BasicResponse.isSuccess(openResult), openResult, ExceptionEnum.GROUP_ADD_ERROR);
    }

    public DeviceResponse.DeviceData addDevice(DeviceAddParam deviceAddParam, Group group) {

        DeviceAddRequest deviceAddRequest = new DeviceAddRequest(group.getGroupNo(), deviceAddParam.getDeviceSerial(),
                deviceAddParam.getValidateCode());
        HttpEntity<String> request = new HttpEntity<>(JsonUtil.toJson(deviceAddRequest), getHttpHeaders());
        DeviceResponse openResult = openRestTemplate.postForObject(host + OPEN_BASIC_DEVICE_ADD, request,
                DeviceResponse.class);
        log.info("addDevice,deviceAddParam:{} basicResponse:{}", deviceAddParam, openResult);
        Assert.isTrue(BasicResponse.isSuccess(openResult), openResult, ExceptionEnum.DEVICE_ADD_ERROR);
        return openResult.getData();
    }

    public void encryptOff(DeviceEncryptOffParam param) {
        HttpEntity<String> request = new HttpEntity<>(JsonUtil.toJson(param), getHttpHeaders());
        BasicResponse openResult = openRestTemplate.postForObject(host + OPEN_BASIC_DEVICE_ENCRYPT_OFF, request,
                BasicResponse.class);
        log.info("deviceEncryptOff,DeviceEncryptOffParam:{} basicResponse:{}", param, openResult);
        Assert.isTrue(BasicResponse.isSuccess(openResult), openResult, ExceptionEnum.DEVICE_ADD_ERROR);
    }

    public List<ChannelPageResponse.ChannelPage.ChannelRow> listChannels(String deviceSerial) {

        HttpEntity<String> request = new HttpEntity<>(null, getHttpHeaders());
        URI url = HttpHelper.buildURI(OPEN_BASIC_CHANNEL_LIST, false, deviceSerial, "1", "999");
        ResponseEntity<ChannelPageResponse> openResult = openRestTemplate.exchange(host + url, HttpMethod.GET, request,
                ChannelPageResponse.class);
        log.info("listChannels,deviceSerial:{} basicResponse:{}", deviceSerial, openResult);
        Assert.isTrue(BasicResponse.isSuccess(openResult.getBody()), ExceptionEnum.LIST_CHANNEL_ERROR);
        ChannelPageResponse.ChannelPage data = openResult.getBody().getData();
        return data.getRows();
    }

    public LiveVideoOpenResponse liveVideoOpen(String channelId) {
        LiveVideoOpenRequest requestBody = new LiveVideoOpenRequest();
        requestBody.setChannelIds(Collections.singletonList(channelId));
        HttpEntity<String> request = new HttpEntity<>(JsonUtil.toJson(requestBody), getHttpHeaders());
        LiveVideoOpenResponse openResult = openRestTemplate.postForObject(host + OPEN_CHANNEL_LIVE_VIDEO_OPEN, request,
                LiveVideoOpenResponse.class);
        log.info("liveVideoOpen,requestParam:{} response:{}", requestBody, openResult);
        Assert.isTrue(BasicResponse.isSuccess(openResult), openResult, ExceptionEnum.LIVE_VIDEO_OPEN_ERROR);
        return openResult;
    }

    public LiveVideoAddressResponse getLiveVideoAddress(String channelId) {
        HttpEntity<String> request = new HttpEntity<>(null, getHttpHeaders());
        URI url = HttpHelper.buildURI(OPEN_CHANNEL_LIVE_ADDRESS, false, channelId, channelId);
        ResponseEntity<LiveVideoAddressResponse> response = openRestTemplate.exchange(host + url, HttpMethod.GET,
                request, LiveVideoAddressResponse.class);
        log.info("getLiveVideoAddress response:{}", response);
        Assert.isTrue(BasicResponse.isSuccess(response) && BasicResponse.isSuccess(response.getBody()),
                response.getBody(), ExceptionEnum.LIVE_VIDEO_ADDRESS_ERROR);
        return response.getBody();
    }

    public PersonResponse.PersonData addPerson(PersonAddParam personAddParam) {

        HttpEntity<String> request = new HttpEntity<>(JsonUtil.toJson(personAddParam), getHttpHeaders());
        PersonResponse openResult = openRestTemplate.postForObject(host + OPEN_BASIC_PERSON_ADD, request,
                PersonResponse.class);
        log.info("addPerson,personAddParam:{} basicResponse:{}", personAddParam, openResult);
        Assert.isTrue(BasicResponse.isSuccess(openResult), openResult, ExceptionEnum.PERSON_ADD_ERROR);
        return openResult.getData();
    }

    public void addCard(CardAddParam cardAddParam) {

        CardRequest cardRequest = new CardRequest();
        CardRequest.CardsBean cardsBean = new CardRequest.CardsBean();
        cardsBean.setCardNo(cardAddParam.getCardNo());
        cardsBean.setEmployeeNo(cardAddParam.getEmployeeNo());
        cardRequest.setCards(Lists.newArrayList(cardsBean));
        HttpEntity<String> request = new HttpEntity<>(JsonUtil.toJson(cardRequest), getHttpHeaders());
        BasicResponse basicResponse = openRestTemplate.postForObject(host + OPEN_BASIC_CARD_ADD, request,
                BasicResponse.class);
        log.info("addCard,cardAddParam:{} basicResponse:{}", cardAddParam, basicResponse);
        Assert.isTrue(BasicResponse.isSuccess(basicResponse), basicResponse, ExceptionEnum.CARD_ADD_ERROR);
    }

    public List<GroupListResponse.GroupRow> listGroups() {

        HttpEntity<String> request = new HttpEntity<>(null, getHttpHeaders());
        ResponseEntity<GroupListResponse> openResult = openRestTemplate.exchange(host + OPEN_BASIC_GROUP_LIST,
                HttpMethod.GET, request, GroupListResponse.class);
        log.info("listGroups,deviceSerial:{} basicResponse:{}", openResult);
        Assert.isTrue(BasicResponse.isSuccess(openResult.getBody()), ExceptionEnum.GET_DATA_ERROR);
        return openResult.getBody().getData();
    }

    public List<DevicePageResponse.DevicePage.DeviceRow> listDevices() {

        HttpEntity<String> request = new HttpEntity<>(null, getHttpHeaders());
        URI url = HttpHelper.buildURI(OPEN_BASIC_DEVICE_LIST, false, "1", "10");
        ResponseEntity<DevicePageResponse> openResult = openRestTemplate.exchange(host + url, HttpMethod.GET, request,
                DevicePageResponse.class);
        log.info("listDevices, basicResponse:{}", openResult);
        Assert.isTrue(BasicResponse.isSuccess(openResult.getBody()), ExceptionEnum.GET_DATA_ERROR);
        DevicePageResponse.DevicePage data = openResult.getBody().getData();
        return data.getRows();
    }

    public List<PersonPageResponse.PersonPage.PersonRow> listPersons() {

        HttpEntity<String> request = new HttpEntity<>(null, getHttpHeaders());
        URI url = HttpHelper.buildURI(OPEN_BASIC_PERSON_LIST, false, "1", "10");
        ResponseEntity<PersonPageResponse> openResult = openRestTemplate.exchange(host + url, HttpMethod.GET, request,
                PersonPageResponse.class);
        log.info("listPersons,groupNo:{} basicResponse:{}", openResult);
        Assert.isTrue(BasicResponse.isSuccess(openResult.getBody()), ExceptionEnum.GET_DATA_ERROR);
        PersonPageResponse.PersonPage data = openResult.getBody().getData();
        return data.getRows();
    }

    public List<CardPageResponse.CardPage.CardRow> listCards(String employeeNo) {

        HttpEntity<String> request = new HttpEntity<>(null, getHttpHeaders());
        URI url = HttpHelper.buildURI(OPEN_BASIC_CARD_LIST, false, employeeNo, "1", "999");
        ResponseEntity<CardPageResponse> openResult = openRestTemplate.exchange(host + url, HttpMethod.GET, request,
                CardPageResponse.class);
        log.info("listCards employeeNo:{} basicResponse:{}", employeeNo, openResult);
        Assert.isTrue(BasicResponse.isSuccess(openResult.getBody()), ExceptionEnum.GET_DATA_ERROR);
        CardPageResponse.CardPage data = openResult.getBody().getData();
        return data.getRows();
    }

    public List<StorePageResponse.StorePage.StoreRow> listStore() {

        HttpEntity<String> request = new HttpEntity<>(null, getHttpHeaders());
        URI url = HttpHelper.buildURI(OPEN_BASIC_STORE_LIST, false, "1", "10");
        ResponseEntity<StorePageResponse> openResult = openRestTemplate.exchange(host + url, HttpMethod.GET, request,
                StorePageResponse.class);
        log.info("listStore, basicResponse:{}", openResult);
        Assert.isTrue(BasicResponse.isSuccess(openResult.getBody()), ExceptionEnum.GET_DATA_ERROR);
        StorePageResponse.StorePage data = openResult.getBody().getData();
        return data.getRows();
    }
}