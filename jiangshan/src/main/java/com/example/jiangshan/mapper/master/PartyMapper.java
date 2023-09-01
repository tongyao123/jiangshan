package com.example.jiangshan.mapper.master;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface PartyMapper {
    @Select("SELECT count(1) FROM t_part_people a LEFT JOIN t_people b  ON a.id=b.obj_id")
    Integer getPartyMembersNumber();

    @Select("SELECT count(1) FROM t_part_people a LEFT JOIN t_people b  ON a.id=b.obj_id WHERE a.party_post='预备党员'")
    Integer getDevelopingPartyMembersNumber();

    @Select("SELECT count(1) FROM t_glory where type=#{type}")
    Integer getTypeOfGloryNumber(String type);

    @Select("SELECT  b.name,b.longitude,b.latitude,b.now_add,a.in_department,b.sex,DATE_FORMAT(a.party_membership_time,'%Y年%m月%d日') as party_membership_time,b.date_of_birth,b.native_place,b.most_education,b.img FROM t_part_people a LEFT JOIN t_people b  ON a.id=b.obj_id WHERE b.longitude is not null and b.latitude is not null and b.now_add!=''")
    List<HashMap> partyCoordinate();

    @Select("select * from t_polict")
    List<HashMap> polictList();
}
