package com.example.jiangshan.service.master.screen;


import com.example.jiangshan.mapper.master.ScreenMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.example.jiangshan.function.NumericalConversion.LongToInteger;


/**
 * @Description: ScreenService.java
 * @Param:
 * @Return:
 * @Author: Xiao Lee
 * @Date: 2023-09-06
 */
@Service
public class ScreenService implements ScreenMapper {
    private final ScreenMapper screenMapper;
    private static final String[] CONTEXT_TYPE_LIST = {"first", "second", "third", "fourth", "fifth", "sixth"};
    private static final List<String> COLOR_LIST = Arrays.asList(
            "#0099CC", "#FFFFEE", "#AA66CC", "#50F350", "#99CC00", "#669900",
            "#FFBB33", "#FF8800", "#FF4444", "#CC0000", "#BF00FF", "#DA9669",
            "#E3CEF6", "#73c0de", "#fc8452", "#9a60b4", "#ea7ccc"
    );

    public ScreenService(ScreenMapper screenMapper) {
        this.screenMapper = screenMapper;
    }

    /**
     * @Date: 2023-09-06
     * @Author: Xiao Lee
     * @Param: [contentType]
     * @Return: java.util.HashMap<java.lang.String, java.lang.Object>
     * @Description: 根据大屏的页面类型获取对应大屏文本主体内容
     */
    @Override
    public HashMap<String, Object> selectScreenContent(String contentType) {
        if (!Arrays.asList(CONTEXT_TYPE_LIST).contains(contentType)) {
            throw new RuntimeException("Error contentType input! Please check what you entered!");
        }
        contentType = contentType + "_content";
        return screenMapper.selectScreenContent(contentType);
    }


    /**
     * @Date: 2023-09-06
     * @Author: Xiao Lee
     * @Param: []
     * @Return: java.util.List<java.util.HashMap < java.lang.String, java.lang.Object>>
     * @Description: 根据选择的村镇等级展示对应的大屏所包含的所有点位
     */
    @Override
    public List<HashMap<String, Object>> selectScreenCoordinate(@Param("town") String town, @Param("village") String village) {
        List<HashMap<String, Object>> screenCoordinate = screenMapper.selectScreenCoordinate(town, village);
        for (HashMap<String, Object> screenCoordinateItem : screenCoordinate) {
            int index = LongToInteger(screenCoordinateItem.get("type"));
            screenCoordinateItem.put("color", COLOR_LIST.get(index));
        }
        return screenCoordinate;
    }

    /**
     * @Date: 2023/10/11
     * @Author: Xiao Lee
     * @Param: [distinct]
     * @Return: java.util.List<java.util.HashMap < java.lang.String, ?>>
     * @Description: 根据传入的区编码，返回对应区、县下所属的城镇
     */
    @Override
    public List<HashMap<String, ?>> selectTownList(@Param("distinct") String distinct) {
        if (distinct == null || distinct.length() == 0) {
            throw new RuntimeException("Empty distinct input! Please check what you entered!");
        }
        return screenMapper.selectTownList(distinct);
    }

    /**
     * @Date: 2023/10/11
     * @Author: Xiao Lee
     * @Param: [town]
     * @Return: java.util.List<java.util.HashMap < java.lang.String, ?>>
     * @Description: 根据传入的城镇编码，返回对应城镇下所属的村
     */
    @Override
    public List<HashMap<String, ?>> selectVillageList(@Param("town") String town) {
        if (town == null || town.length() == 0) {
            throw new RuntimeException("Empty town input! Please check what you entered!");
        }
        return screenMapper.selectVillageList(town);
    }
}
