package com.example.jiangshan.open.api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.jiangshan.open.api.param.PersonAddParam;
import com.example.jiangshan.open.api.vo.PersonVO;
import com.example.jiangshan.open.service.PersonService;

/**
 * @author yanyuechao
 * @date 2020-05-19 19:49
 **/
@RestController
@RequestMapping("/demo/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @CrossOrigin
    @PostMapping("/add")
    public HttpResult addPerson(@RequestBody PersonAddParam personAddParam) {

        personService.addPerson(personAddParam);
        return new HttpResult<>();
    }

    @CrossOrigin
    @GetMapping("/list")
    public HttpResult<List<PersonVO>> listPerson() {

        return new HttpResult<>(personService.listPerson());
    }
}
