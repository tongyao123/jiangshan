package com.example.jiangshan.mapper.master;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

/**
 * @Date: 2023-09-12
 * @Author: Xiao Lee
 * @Param:
 * @Return:
 * @Description: 人才映射器
 */
@Mapper
public interface TalentsMapper {
    /**
     * @Date: 2023-09-12
     * @Author: Xiao Lee
     * @Param: []
     * @Return: java.lang.Integer
     * @Description: 人才总数统计
     */

    Integer getTalentsStatistics(@Param("town") String town,@Param("village") String village);

    /**
     * @Date: 2023-09-12
     * @Author: Xiao Lee
     * @Param: []
     * @Return: java.lang.Integer
     * @Description: 就业人才数据统计
     */

    Integer getEmploymentTalentsStatistics(@Param("town") String town,@Param("village") String village);

    /**
     * @Date: 2023-09-12
     * @Author: Xiao Lee
     * @Param: []
     * @Return: java.util.List<java.util.HashMap>
     * @Description: 人才学历统计
     */

    List<HashMap> getTalentsEducationStatistics(@Param("town") String town,@Param("village") String village);

    /**
     * @Date: 2023/10/14
     * @Author: Xiao Lee
     * @Param: [town]
     * @Return: java.util.List<java.util.HashMap>
     * @Description: 人员点位信息
     */
    List<HashMap> talentsCoordinate(@Param("town") String town,@Param("village") String village);

    /**
     * @Date: 2023/10/14
     * @Author: Xiao Lee
     * @Param: [town]
     * @Return: java.util.List<java.util.HashMap>
     * @Description: 人员政策信息
     */
    List<HashMap> talentPolicyList(@Param("town") String town);
}
