package com.example.jiangshan.open.cache;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.example.jiangshan.open.client.response.AccountTokenResponse.Account;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsumeCache {

    /**
     * 云眸token缓存
     */
    private static final Cache<String, String> TOKEN_CACHE = CacheBuilder.newBuilder()
            .expireAfterWrite(7, TimeUnit.DAYS).build();
    /**
     * 取流Token缓存
     */
    private static final Cache<String, Account> ACCOUNT_CACHE = CacheBuilder.newBuilder()
            .expireAfterWrite(1, TimeUnit.DAYS).build();

    public static String get(String key) {
        return TOKEN_CACHE.getIfPresent(key);
    }

    public static void set(String key, String value) {
        TOKEN_CACHE.put(key, value);
        log.info("保存token到缓存成功");
    }

    public static Account getAccount(String key) {
        return ACCOUNT_CACHE.getIfPresent(key);
    }

    public static void setAccount(String key, Account value) {
        ACCOUNT_CACHE.put(key, value);
        log.info("保存取流Token到缓存成功");
    }

    private ConsumeCache() {
    }
}
