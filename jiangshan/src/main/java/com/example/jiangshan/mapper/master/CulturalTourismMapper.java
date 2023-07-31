package com.example.jiangshan.mapper.master;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CulturalTourismMapper {
    @Select("select count(1) from t_product where type= #{productType}")
    Integer CulturalTourismCount(String productType);

    @Select("SELECT DATE_FORMAT(order_time,\"%Y-%m\") AS orderTime,ROUND(SUM(order_total),2) AS orderTotal FROM t_consumption GROUP BY DATE_FORMAT(order_time,\"%Y-%m\") order by DATE_FORMAT(order_time,\"%Y-%m\")")
    List<HashMap> getTurnoverList();

    @Select("select id,case type when 4 then \"文化底蕴\" end as type,area,name,address,if(details is null,'',details ) as  details,addArr,longitude,latitude,image,if(video is null,'',video ) as  video,if(vRaddress is null,'',vRaddress ) as vRaddress from t_product where type=4")
    List<HashMap>  culturalDetailList();

    @Select("select id,case type when 5 then \"康养基地\" when 6 then \"酒店/民宿\" when 7 then \"餐饮\" when 9 then \"旅游景点\" end as type,area,name,address,if(details is null,'',details ) as  details,addArr,longitude,latitude,image,if(video is null,'',video ) as  video,if(vRaddress is null,'',vRaddress ) as vRaddress from t_product where type in (5,6,7,9)")
    List<HashMap> tourismDetailList();
}
