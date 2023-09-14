package com.example.jiangshan.open.constant;

/**
 * 通道类型枚举
 * @author zhanyl
 * @date 2018-11-28 10:12
 */
public enum ChannelTypeEnum {
    /**
     * 监控点通道(视频通道)
     */
    CAMERA("10300", "监控点资源"),
    /**
     * 报警输入(IO通道)
     */
    IO("10302", "报警输入"),
    /**
     * 报警网关
     */
    GATEWAY("10303", "报警网关");

    private String id;
    private String name;

    ChannelTypeEnum(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ChannelTypeEnum getEnumByCode(String id) {
        for (ChannelTypeEnum value : ChannelTypeEnum.values()) {
            if (value.getId().equals(id)) {
                return value;
            }
        }
        return null;
    }

    public static String getChannelTypeById(String id) {
        ChannelTypeEnum value = getEnumByCode(id);
        if (value != null) {
            return value.getName();
        } else {
            return "未知类型";
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
