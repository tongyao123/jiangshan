package com.example.jiangshan.mapper.master;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface ScreenMapper {

    HashMap selectScreenContent(@Param("contentType") String contentType);


    List<HashMap> selectScreenCoordinate();
}
