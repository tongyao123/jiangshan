package com.example.jiangshan.mapper.master;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface AgricultureMapper {
    @Select("SELECT count(1) as amount,sum(a.area) as area ,sum(b.worker_num) as worker_num FROM t_product a inner join t_planting_industry b on a.obj_id=b.id")
    List<HashMap> plantation();

    @Select("SELECT count(1) as amount,sum(a.area) as area ,sum(b.worker_num) as worker_num FROM t_product a inner join t_cultivation b on a.obj_id=b.id")
    List<HashMap> farm();

    @Select("select count(1) as amount,sum(area) as area ,sum(ylut*area) as yield from t_tea")
    List<HashMap> tea();

    @Select("select id,case type when 8 then \"斜背茶\" when 11 then \"养殖场\" when 12 then \"果园/茶园\" when 13 then \"种植场\" end as type,name,address,if(details is null,'',details ) as  details,addArr,longitude,latitude,image,if(video is null,'',video ) as  video,if(vRaddress is null,'',vRaddress ) as vRaddress from t_product where type in (8,11,12,13)")
    List<HashMap> agricultureDetailList();

}
