package com.example.jiangshan.open.util;

import java.util.UUID;

public class UuidUtil {
    private UuidUtil() {
    }

    public static String create() {
            return UUID.randomUUID().toString().replace("-", "");
        }
}
