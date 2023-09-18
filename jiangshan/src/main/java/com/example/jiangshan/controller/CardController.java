package com.example.jiangshan.controller;

import com.example.jiangshan.controller.param.CardAddParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.jiangshan.service.domain.CardService;

/**
 * @author yanyuechao
 * @date 2020-05-20 10:19
 **/
@RestController
@RequestMapping("/demo/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @CrossOrigin
    @PostMapping("/add")
    public HttpResult addCard(@RequestBody CardAddParam cardAddParam) {

        cardService.addCard(cardAddParam);
        return new HttpResult<>();
    }
}
