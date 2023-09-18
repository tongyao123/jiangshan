package com.example.jiangshan.service.second;


import com.example.jiangshan.mapper.second.SensorMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SensorService {


    public static final HashMap<String, String> WEATHER_CURVE_TYPE = new HashMap<>();
    public static final HashMap<String, String> SOIL_CURVE_TYPE = new HashMap<>();

    static {
        WEATHER_CURVE_TYPE.put("DRP", "5分钟时段雨量");
        WEATHER_CURVE_TYPE.put("US", "'风速'");
        WEATHER_CURVE_TYPE.put("AI", "气温");
        WEATHER_CURVE_TYPE.put("MST", "空气湿度");
        WEATHER_CURVE_TYPE.put("FL", "气压");
        WEATHER_CURVE_TYPE.put("GZ", "光照");
        SOIL_CURVE_TYPE.put("GTP", "土壤温度");
        SOIL_CURVE_TYPE.put("M10", "土壤湿度");
        SOIL_CURVE_TYPE.put("COND", "电导率");
        SOIL_CURVE_TYPE.put("PH", "PH值");
        SOIL_CURVE_TYPE.put("TN", "氮");
        SOIL_CURVE_TYPE.put("TP", "磷");
        SOIL_CURVE_TYPE.put("K", "钾");
        SOIL_CURVE_TYPE.put("VT", "电压");

    }
    @Autowired
    private SensorMapper sensorMapper;

    public HashMap<String, String> getCurveType(String sensorType) {
        if (sensorType.equals("weather")) {
            return WEATHER_CURVE_TYPE;
        } else if (sensorType.equals("soil")) {
            return SOIL_CURVE_TYPE;
        } else {
            throw new RuntimeException("Error sensorType input! Please check what you entered!");
        }
    }


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

    public HashMap getSensorLatestData(String sensorType, String sensorId) throws Exception {
        if (sensorType.equals("weather")) {
            return sensorMapper.selectWeatherSensorLatestData(sensorId);
        } else if (sensorType.equals("soil")) {
            return sensorMapper.selectSoilSensorLatestData(sensorId);
        } else {
            throw new RuntimeException("Error sensorType input! Please check what you entered!");
        }
    }

    public List<HashMap> getSensorCurve(@Param("sensorType") String sensorType, @Param("sensorId") String sensorId, @Param("curveType") String curveType) {

        String curveName = new String();
        if (
                (sensorType.equals("weather") && WEATHER_CURVE_TYPE.containsKey(curveType)) ||
                        (sensorType.equals("soil") && SOIL_CURVE_TYPE.containsKey(curveType))
        ) {
            return  sensorMapper.selectSensorCurve(sensorType.equals("weather") ? "`st_pptn_r`" : "`st_soil_r`",
                    sensorId,
                    curveType,
                    sensorType.equals("weather") ? WEATHER_CURVE_TYPE.get(curveType) : SOIL_CURVE_TYPE.get(curveType));
        } else if (sensorType.equals("weather") || sensorType.equals("soil")) {
            throw new RuntimeException("Error curveType input! Please check what you entered!");
        } else {
            throw new RuntimeException("Error sensorType input! Please check what you entered!");
        }
    }
}
