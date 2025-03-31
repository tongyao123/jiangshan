package com.example.jiangshan.mapper.master;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @Description: 大屏的主体内容映射器    Large screen body content mapper
 * @Author: Xiao Lee
 * @Date: 2023-09-06
 */
@Repository
@Mapper
public interface ScreenMapper {
    /**
     * @Description: 根据大屏的页面类型获取对应大屏文本主体内容
     * @Param: [contentType]
     * @Return: java.util.HashMap<java.lang.String, java.lang.Object>
     * @Author: Xiao Lee
     * @Date: 2023-09-06
     */
    HashMap<String, Object> selectScreenContent(@Param("contentType") String contentType);


    /**
     * @Description: 获取系统内的所有资产的详细数据及坐标点数据
     * @Param: []
     * @Return: java.util.List<java.util.HashMap < java.lang.String, java.lang.Object>>
     * @Author: Xiao Lee
     * @Date: 2023-09-06
     */
    List<HashMap<String, Object>> selectScreenCoordinate(@Param("town") String town, @Param("village") String village);

    /**
     * @Date: 2023/10/11
     * @Author: Xiao Lee
     * @Param: []
     * @Return: java.util.List<java.util.HashMap < java.lang.String, ?>>
     * @Description: 根据传入的区编码，返回对应区、县下所属的城镇
     */
    List<HashMap<String, ?>> selectTownList(@Param("distinct") String distinct);
    /**
    * @Date: 2023/10/11
    * @Author: Xiao Lee
    * @Param: []
    * @Return: java.util.List<java.util.HashMap<java.lang.String,?>>
    * @Description: 根据传入的城镇编码，返回对应城镇下所属的村
    */
    List<HashMap<String, ?>> selectVillageList(@Param("town") String town);
    /**
    * @Date: 2024/3/25
    * @Author: Xiao Lee
    * @Param: [town]
    * @Return: java.util.List<java.util.HashMap<java.lang.String,?>>
    * @Description: ScreenMapper.java
    */
    String selectVillageProduct(@Param("village") String village);
    /**
    * @Date: 2024/3/25
    * @Author: Xiao Lee
    * @Param: [Town]
    * @Return: java.lang.String
    * @Description: ScreenMapper.java
    */
    String selectTownProduct(@Param("town") String town);
}
