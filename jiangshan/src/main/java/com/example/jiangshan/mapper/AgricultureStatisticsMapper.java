package com.example.jiangshan.mapper;

import com.example.jiangshan.entity.Agriculture;
import com.example.jiangshan.entity.AgricultureStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AgricultureStatisticsMapper {
    AgricultureStatistics agricultureStatistics = new AgricultureStatistics();


    @Select("SELECT count(1) as amount,sum(a.area) as area ,sum(b.worker_num) as worker_num FROM t_product a inner join t_planting_industry b on a.obj_id=b.id")
    List<HashMap> plantation();


    @Select("SELECT count(1) as amount,sum(a.area) as area ,sum(b.worker_num) as worker_num FROM t_product a inner join t_cultivation b on a.obj_id=b.id")
    List<HashMap> farm();


    @Select("select count(1) as amount,sum(area) as area ,sum(ylut*area) as yield from t_tea")
    List<HashMap> tea();


}
