package com.example.jiangshan.mapper.master;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface PlanningProductMapper {
    @Select("select case when type_in_future=\"1\" then \"计划项目\" when type_in_future=\"2\" then \"拟签约项目\" when type_in_future=\"3\" then \"已签约项目\" else \"未明确状态项目\" end as typeInFuture,count(1) as num,DATE_FORMAT(now(),\"%Y\") as investTime,sum(b.invest_amount) as investAmount from t_future_product a right join t_investment_history b on a.id=b.product_id  where (a.plant='1' or a.plant='3') and DATE_FORMAT(b.invest_time,\"%Y\")=DATE_FORMAT(now(),\"%Y\") and type_in_future=#{typeInFuture} GROUP BY type_in_future\n")
    List<HashMap> getAttractInvestmentStatistics(String typeInFuture);

    @Select("SELECT count(1) AS number,DATE_FORMAT(b.invest_time,\"%Y-%m\") AS yearOfMonth,DATE_FORMAT(b.invest_time,\"%m\") AS month,sum(b.invest_amount)  AS amount FROM  t_future_product a right join t_investment_history b on a.id=b.product_id where a.plant='1' or a.plant='3' group by DATE_FORMAT(b.invest_time,\"%Y-%m\"),DATE_FORMAT(b.invest_time,\"%m\") limit 10,6")
    List<HashMap> getAttractInvestmentList();
}
