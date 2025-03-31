package com.example.jiangshan.mapper.master;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AgricultureMapper {

    HashMap<String,Object> plantation(@Param("town") String town, @Param("village") String village);

    HashMap<String,Object> farm(@Param("town") String town, @Param("village") String village);

    HashMap<String,Object> tea(@Param("town") String town, @Param("village") String village);
    HashMap<String,Object> factory(@Param("town") String town, @Param("village") String village);

    List<HashMap> selectAgricultureDetailList(@Param("town") String town, @Param("village") String village) throws Exception;

}
