package com.example.jiangshan.mapper.master;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface AttractInvestmentMapper {

    List<HashMap> selectAttractInvestmentStatistics(@Param("typeInFuture") String typeInFuture,@Param("town") String town, @Param("village") String village);

    List<HashMap> selectAttractInvestmentList(@Param("town") String town, @Param("village") String village);

    List<HashMap> selectAttractInvestmentDetailList(@Param("town") String town, @Param("village") String village);

    List<HashMap> villageAttractInvestmentCoordinate(@Param("village") String village);

    List<HashMap> selectVillageList();


}
