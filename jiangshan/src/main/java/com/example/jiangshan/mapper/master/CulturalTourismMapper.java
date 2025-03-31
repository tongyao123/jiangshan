package com.example.jiangshan.mapper.master;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CulturalTourismMapper {

    Integer CulturalTourismCount(@Param("productType") String productType,@Param("town")String town, @Param("village") String village);

    List<HashMap> getTurnoverList(@Param("town")String town, @Param("village") String village);

    List<HashMap> culturalDetailList(@Param("town")String town, @Param("village") String village);

    List<HashMap> tourismDetailList(@Param("town")String town, @Param("village") String village);
}
