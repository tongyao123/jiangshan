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


    /*根据类型获得传感器列表333*/
    /*根据类型获得传感器列表222*/
    /*根据类型获得传感器列表111*/
    List<String> selectSensorIdList(@Param("sensorType") String sensorType) throws Exception;

    /*气象传感器最新数据*/
    HashMap selectWeatherSensorLatestData(@Param("weatherSensorId") String sensorId) throws Exception;

    /*土壤传感器最新数据*/
    HashMap selectSoilSensorLatestData(@Param("soilSensorId") String sensorId);

    List<HashMap> selectSensorCurve(@Param("sensorTable") String sensorTable,@Param("sensorId") String sensorID,@Param("curveType") String curveType,@Param("curveName") String curveType1);


}
