package com.example.jiangshan.mapper;

import com.example.jiangshan.entity.Agriculture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AgricultureMapper {

    @Select("select id,linkman from t_planting_industry")
    List<Agriculture> select();
}
