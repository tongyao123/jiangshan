package com.example.jiangshan.controller;

import com.example.jiangshan.entity.User;
import com.example.jiangshan.service.master.wechat.MallOnlineService;
import com.example.jiangshan.service.master.wechat.MallSelfService;
import com.example.jiangshan.service.master.wechat.WeChatAuthService;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayResponse;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayWithRequestPaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@Scope()
@RequestMapping("/mall")
@CrossOrigin
public class MallController {
    private final WeChatAuthService weChatAuthService;
    private final MallSelfService mallSelfService;
    private final MallOnlineService mallOnlineService;

    public MallController(WeChatAuthService weChatAuthService, MallSelfService mallSelfService, MallOnlineService mallOnlineService) {
        this.weChatAuthService = weChatAuthService;
        this.mallSelfService = mallSelfService;
        this.mallOnlineService = mallOnlineService;
    }

    @ResponseBody
    @RequestMapping("/wechat/login")
    public String wechatLogin(String code) {
        return weChatAuthService.getAccessToken(weChatAuthService.getAuthorizeUrl(code));
        //return "redirect:" + weChatAuthService.getAuthorizeUrl(userId);
    }


    @ResponseBody
    @RequestMapping("/wechat/callback/")
    public String wechatCallback(@RequestParam("code") String code) {
        String accessToken = weChatAuthService.getAccessToken(code);
        User user = weChatAuthService.getUserInfo(accessToken);
        // 处理用户信息，进行登录逻辑
        return "redirect:/";
    }

    @ResponseBody
    @RequestMapping("/wechat/paySelf")
    public PrepayResponse wechatPaySelf(@Param("orderId") String orderId, @Param("orderAmount") String orderAmount, @Param("description") String description, @Param("openid") String openid) throws Exception {
        return mallSelfService.wechatPay(orderId, orderAmount, description, openid);
        // 处理用户信息，进行登录逻辑
    }

    @ResponseBody
    @RequestMapping("/wechat/payOnline")
    public PrepayWithRequestPaymentResponse wechatPayOnline(@Param("orderId") String orderId, @Param("orderAmount") String orderAmount, @Param("description") String description, @Param("openid") String openid) throws Exception {
        return mallOnlineService.wechatPay(orderId, orderAmount, description, openid);
        // 处理用户信息，进行登录逻辑
    }
}
