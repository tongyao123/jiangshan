package com.example.jiangshan.mapper.master;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TalentsMapper {

    @Select("select count(1) as amount from t_talents a left join t_people b on a.id=b.obj_id")
    Integer getTalentsStatistics();

    @Select("select count(1) as amount from t_talents a left join t_people b on a.id=b.obj_id where now_work_address!=''")
    Integer getEmploymentTalentsStatistics();
    /*学历统计*/
    @Select("SELECT CASE most_education\tWHEN '1' THEN\t'高中'\tWHEN '2' THEN\t'大专'\tWHEN '3' THEN\t'本科'\tWHEN '4' THEN\t'研究生' WHEN '5' THEN '博士' ELSE '其他' END as most_education_,count(1) AS amount FROM t_talents  LEFT JOIN t_people  on t_talents.id=t_people.obj_id GROUP BY most_education")
    List<HashMap> getTalentsEducationStatistics();

    @Select("SELECT b.name,b.now_add,b.longitude,b.latitude,b.sex,a.is_party,b.native_place,b.most_school,a.now_work_address,b.img FROM t_talents a LEFT JOIN t_people b  ON a.id=b.obj_id WHERE b.longitude is not null and b.latitude is not null and b.now_add!=''")
    List<HashMap> talentsCoordinate();

    @Select("select * from t_policy where type=1")
    List<HashMap> talentPolicyList();
}
