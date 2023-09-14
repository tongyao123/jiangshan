package com.example.jiangshan.open.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    private final static String dateFormatPattern = "yyyy-MM-dd HH:mm:ss";

    static {
        // 排除值为空属性
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 转换成对象时，没有属性的处理，忽略掉
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);

        // 进行缩进输出
        // configure(SerializationFeature.INDENT_OUTPUT, true);
        // 进行日期格式化
        if (dateFormatPattern !=null) {
            DateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);
            objectMapper.setDateFormat(dateFormat);
        }
        objectMapper.registerModule(new JavaTimeModule());

    }

    /**
     * 将 POJO 对象转为 JSON 字符串
     */
    public static <T> String toJson(T pojo) {
        String json;
        try {
            json = objectMapper.writeValueAsString(pojo);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("转换json格式异常");
        }
        return json;
    }
}
