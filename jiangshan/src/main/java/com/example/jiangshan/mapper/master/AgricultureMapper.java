package com.example.jiangshan.mapper.master;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AgricultureMapper {

    HashMap plantation(@Param("town") String town, @Param("village") String village);

    HashMap farm(@Param("town") String town, @Param("village") String village);

    HashMap tea(@Param("town") String town, @Param("village") String village);

    List<HashMap> agricultureDetailList(@Param("town") String town, @Param("village") String village) throws Exception;

}
