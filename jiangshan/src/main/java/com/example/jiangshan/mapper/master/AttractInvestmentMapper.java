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

    List<HashMap> attractInvestmentStatistics(@Param("typeInFuture") String typeInFuture,@Param("town") String town, @Param("village") String village);

    List<HashMap> attractInvestmentList(@Param("town") String town, @Param("village") String village);

    List<HashMap> attractInvestmentDetailList(@Param("town") String town, @Param("village") String village);

    List<HashMap> villageAttractInvestmentCoordinate(@Param("village") String village);

    List<HashMap> villageList();


}
