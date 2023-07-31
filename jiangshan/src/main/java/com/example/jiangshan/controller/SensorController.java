package com.example.jiangshan.controller;


import com.example.jiangshan.service.second.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@Scope()
@RequestMapping("/SensorMessage")
@CrossOrigin
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @ResponseBody
    @RequestMapping("/getSensorIDList")
    public List<String> getSensorIDList(@Param("sensorType") String sensorType) throws Exception {
        return sensorService.getSensorIdList(sensorType);
    }


}
