package com.example.jiangshan.mapper.master;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface PlanningProductMapper {

    List<HashMap> getAttractInvestmentStatistics( @Param("typeInFuture") String typeInFuture, @Param("town") String town, @Param("village") String village);

    @Select("SELECT count(1) AS number,DATE_FORMAT(b.invest_time,\"%Y-%m\") AS yearOfMonth,DATE_FORMAT(b.invest_time,\"%m\") AS month,sum(b.invest_amount)  AS amount FROM  t_future_product a right join t_investment_history b on a.id=b.product_id where a.plant='1' or a.plant='3' group by DATE_FORMAT(b.invest_time,\"%Y-%m\"),DATE_FORMAT(b.invest_time,\"%m\") limit 10,6")
    List<HashMap> getAttractInvestmentList();
}
