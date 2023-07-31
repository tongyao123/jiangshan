package com.example.jiangshan.mapper.second;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface SensorMapper {

    /*根据类型获得传感器列表*/
    List<String> selectSensorIdList(@Param("sensorType") String sensorType);


    /*传感器最新数据*/
    HashMap selectSensorData(@Param("weatherSensorId") String sensorType,@Param("sensorId") String sensorId);


}
