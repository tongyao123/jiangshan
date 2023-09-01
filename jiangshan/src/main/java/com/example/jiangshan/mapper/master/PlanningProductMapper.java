package com.example.jiangshan.mapper.master;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface PlanningProductMapper {

    List<HashMap> getAttractInvestmentStatistics(@Param("typeInFuture") String typeInFuture, @Param("town") String town, @Param("village") String village);


    List<HashMap> getAttractInvestmentList(@Param("town") String town, @Param("village") String village);
}
