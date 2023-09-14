package com.example.jiangshan.open.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jiangshan.open.api.param.PersonAddParam;
import com.example.jiangshan.open.api.vo.PersonVO;
import com.example.jiangshan.open.client.OpenBasicClient;
import com.example.jiangshan.open.client.response.PersonPageResponse;
import com.example.jiangshan.open.client.response.PersonResponse;
import com.example.jiangshan.open.domain.PersonCardMapper;
import com.example.jiangshan.open.domain.PersonMapper;
import com.example.jiangshan.open.domain.entity.Person;
import com.example.jiangshan.open.domain.entity.PersonCard;
import com.example.jiangshan.open.util.UuidUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yanyuechao
 * @date 2020-05-19 19:51
 **/
@Service
@Slf4j
public class PersonService {

    @Autowired
    private OpenBasicClient openBasicClient;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private PersonCardMapper cardMapper;
    public void addPerson(PersonAddParam personAddParam) {

        PersonResponse.PersonData personResponse = openBasicClient.addPerson(personAddParam);
        personMapper.insertSelective(toPerson(personResponse));
    }

    public List<PersonVO> listPerson() {

        List<Person> persons = personMapper.listPersons();
        return toPersonVO(persons);
    }

    private Person toPerson(PersonResponse.PersonData personResponse) {

        return Person.aBuilder.aPerson().setId(UuidUtil.create()).setEmployeeNo(personResponse.getEmployeeNo())
                .setName(personResponse.getPersonName()).setFaceUrl(personResponse.getFaceUrl()).build();
    }


    private List<PersonVO> toPersonVO(List<Person> persons) {

        return persons.stream().map(person -> {
            List<PersonCard> personCards = cardMapper.listByEmployeeNo(person.getEmployeeNo());
            return PersonVO.aBuilder.aPersonVO().setEmployeeNo(person.getEmployeeNo()).setFaceUrl(person.getFaceUrl())
                    .setPersonName(person.getName())
                    .setCardNo(CollectionUtils.isEmpty(personCards) ? null : personCards.get(0).getCardNo()).build();
        }).collect(Collectors.toList());
    }

    public List<Person> batchAddPersons(List<PersonPageResponse.PersonPage.PersonRow> personRows) {
        if (CollectionUtils.isNotEmpty(personRows)) {
            List<Person>  persons = personRows.stream().map(this::toPerson).collect(Collectors.toList());
            personMapper.batchInsert(persons);
            return persons;
        }
        return Collections.emptyList();
    }

    private Person toPerson(PersonPageResponse.PersonPage.PersonRow personRow) {

        return Person.aBuilder.aPerson().setId(UuidUtil.create()).setEmployeeNo(personRow.getEmployeeNo())
                .setName(personRow.getPersonName()).setFaceUrl(personRow.getFaceUrl()).build();
    }
}
