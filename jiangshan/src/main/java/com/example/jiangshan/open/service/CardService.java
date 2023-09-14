package com.example.jiangshan.open.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jiangshan.open.api.param.CardAddParam;
import com.example.jiangshan.open.client.OpenBasicClient;
import com.example.jiangshan.open.client.response.CardPageResponse;
import com.example.jiangshan.open.constant.ExceptionEnum;
import com.example.jiangshan.open.domain.PersonCardMapper;
import com.example.jiangshan.open.domain.PersonMapper;
import com.example.jiangshan.open.domain.entity.Person;
import com.example.jiangshan.open.domain.entity.PersonCard;
import com.example.jiangshan.open.util.Assert;
import com.example.jiangshan.open.util.UuidUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yanyuechao
 * @date 2020-05-20 10:44
 **/
@Service
@Slf4j
public class CardService {

    @Autowired
    private PersonCardMapper cardMapper;
    @Autowired
    private OpenBasicClient openBasicClient;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private PersonCardMapper personCardMapper;

    public void addCard(CardAddParam cardAddParam) {

        Person person = personMapper.selectByEmployeeNo(cardAddParam.getEmployeeNo());
        Assert.isTrue(person != null, ExceptionEnum.PERSON_NOT_EXIST);
        openBasicClient.addCard(cardAddParam);
        cardMapper.insertSelective(toCard(cardAddParam,person));
    }

    public void batchAddCards(List<Person> people) {
        people.forEach(person -> {
            List<CardPageResponse.CardPage.CardRow> cardRows = openBasicClient.listCards(person.getEmployeeNo());
            if(CollectionUtils.isNotEmpty(cardRows)) {
                personCardMapper.batchAddCards(toCardDOs(cardRows, person.getId()));
            }
        });
    }

    private List<PersonCard> toCardDOs(List<CardPageResponse.CardPage.CardRow> cardRows, String personId) {

        return cardRows.stream()
                .map(cardRow -> PersonCard.aBuilder.aPersonCard().setId(UuidUtil.create())
                        .setCardNo(cardRow.getCardNo()).setEmployeeNo(cardRow.getEmployeeNo()).setPersonId(personId)
                        .build())
                .collect(Collectors.toList());
    }

    private PersonCard toCard(CardAddParam cardAddParam,Person person) {

        PersonCard personCard = new PersonCard();
        personCard.setId(UuidUtil.create());
        personCard.setCardNo(cardAddParam.getCardNo());
        personCard.setEmployeeNo(cardAddParam.getEmployeeNo());
        personCard.setPersonId(person.getId());
        return personCard;
    }
}
