package com.example.jiangshan.service.second;


import com.example.jiangshan.mapper.second.SensorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SensorService {
    @Autowired
    private SensorMapper sensorMapper;

    public List<String> getSensorIdList(String sensorType) throws Exception {

        if (sensorType.equals("weather")) {
            sensorType = "`st_pptn_r`";
        } else if (sensorType.equals("soil")) {
            sensorType = "`st_soil_r`";
        } else {
            throw new RuntimeException("Error sensorType input! Please check what you entered!");
        }

        return sensorMapper.selectSensorIdList(sensorType);
    }

    public HashMap getSensorData(String sensorType, String sensorId) {
        return sensorMapper.selectSensorData(sensorType, sensorId);
    }


}
