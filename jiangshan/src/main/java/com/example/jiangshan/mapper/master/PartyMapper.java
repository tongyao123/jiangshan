package com.example.jiangshan.mapper.master;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface PartyMapper {
    /**
     * @Date: 2023/10/14
     * @Author: Xiao Lee
     * @Param: []
     * @Return: java.lang.Integer
     * @Description: 党员总数
     */
    Integer getPartyMembersNumber(@Param("town") String town, @Param("village") String village);

    /**
     * @Date: 2023/10/14
     * @Author: Xiao Lee
     * @Param: [town, village]
     * @Return: java.lang.Integer
     * @Description: 预备党员数据统计
     */
    Integer getDevelopingPartyMembersNumber(@Param("town") String town, @Param("village") String village);

    /**
     * @Date: 2023/10/14
     * @Author: Xiao Lee
     * @Param: [type]
     * @Return: java.lang.Integer
     * @Description: 不同类型荣誉数量统计
     */

    Integer getTypeOfGloryNumber(String type,@Param("town") String town, @Param("village") String village);

    /**
     * @Date: 2023/10/14
     * @Author: Xiao Lee
     * @Param: [town, village]
     * @Return: java.util.List<java.util.HashMap>
     * @Description: 党员点位数据
     */

    List<HashMap> partyCoordinate(@Param("town") String town, @Param("village") String village);

    /**
    * @Date: 2023/10/14
    * @Author: Xiao Lee
    * @Param: []
    * @Return: java.util.List<java.util.HashMap>
    * @Description: PartyMapper.java
    */
    List<HashMap> polictList(@Param("town") String town);
}
