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


    /*获取传感器列表*/
    @ResponseBody
    @RequestMapping("/getSensorIDList")
    public List<String> getSensorIDList(@Param("sensorType") String sensorType) throws Exception {
        return sensorService.getSensorIdList(sensorType);
    }


    /*获取传感器最新数据*/
    @ResponseBody
    @RequestMapping("/getSensorLatestData")
    public HashMap getSensorLatestData(@Param("sensorType") String sensorType, @Param("sensorId") String sensorId) throws Exception {
        return sensorService.getSensorLatestData(sensorType, sensorId);

    }

    /*获取不同类型的传感器的可查询曲线类型*/
    @ResponseBody
    @RequestMapping("/getCurveType")
    public HashMap<String, String> getCurveType(@Param("sensorType") String sensorType) {

        return sensorService.getCurveType(sensorType);
    }

    /*获取不同类型的某个设备号的指定曲线*/
    @ResponseBody
    @RequestMapping("/getSensorCurve")
    public List<HashMap> getSensorCurve(@Param("sensorType") String sensorType, @Param("sensorId") String sensorId, @Param("curveType") String curveType) {
        return sensorService.getSensorCurve(sensorType, sensorId, curveType);
    }


}
