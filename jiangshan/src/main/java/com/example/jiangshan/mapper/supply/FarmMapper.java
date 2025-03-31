
package com.example.jiangshan.mapper.supply;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface FarmMapper {
    List<HashMap> selectFarmBasisList(@Param("town") String town, @Param("village") String village);

    List<String> selectFarmPicture(@Param("farm_code")String farm_code);

    List<List> selectFarmCoordinate(@Param("code") String code, @Param("partition_code") String partition_code);
    HashMap selectFarmStatistics(@Param("farm_type") String farm_type,@Param("town") String town, @Param("village") String village);

}
