package com.example.jiangshan.util;

import java.util.Collection;

import com.example.jiangshan.client.response.BasicResponse;
import com.example.jiangshan.exception.BusinessException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.example.jiangshan.constant.ExceptionEnum;
import com.example.jiangshan.exception.ExceptionInfo;


/**
 * 断言工具类
 * @author guanhaoyuan
 */
public final class Assert {

        private Assert() {
        }

        /**
         *
         * 若表达式不为true,则抛出异常
         * @param express
         * @param exceptionInfo
         */
        public static void isTrue(boolean express, ExceptionInfo exceptionInfo) {
            if (!express) {
                throw new BusinessException(exceptionInfo);
            }
        }

        /**
         *
         * 若表达式不为true,则抛出异常
         * @param express
         * @param basicResponse
         * @param exceptionEnum
         */
        public static void isTrue(boolean express, BasicResponse basicResponse, ExceptionEnum exceptionEnum) {
            if (!express) {
                if(basicResponse == null){
                  throw new BusinessException(exceptionEnum);
                }
                throw new BusinessException(Integer.parseInt(basicResponse.getCode()), basicResponse.getMessage());
            }
        }

        /**
         *
         * 若表达式为true,则抛出异常
         * @param express
         * @param exceptionInfo
         */
        public static void isFalse(boolean express, ExceptionInfo exceptionInfo) {
            if (express) {
                throw new BusinessException(exceptionInfo);
            }
        }

        /**
         *
         * 若对象为null,则抛出异常
         * @param obj
         * @param exceptionInfo
         */
        public static void notNull(Object obj, ExceptionInfo exceptionInfo) {
            if (obj == null) {
                throw new BusinessException(exceptionInfo);
            }
        }

        /**
         *
         * 若对象不为null,则抛出异常
         * @param obj
         * @param exceptionInfo
         */
        public static void isNull(Object obj, ExceptionInfo exceptionInfo) {
            if (obj != null) {
                throw new BusinessException(exceptionInfo);
            }
        }

        /**
         *
         * 若字符串为空则抛出异常
         * @param str
         * @param exceptionInfo
         */
        public static void isBlank(String str, ExceptionInfo exceptionInfo) {
            if (StringUtils.isNotBlank(str)) {
                throw new BusinessException(exceptionInfo);
            }
        }

        /**
         *
         * 若字符串为空则抛出异常
         * @param str
         * @param exceptionInfo
         */
        public static void notBlank(String str, ExceptionInfo exceptionInfo) {
            if (StringUtils.isBlank(str)) {
                throw new BusinessException(exceptionInfo);
            }
        }

        /**
         *
         * 若集合不为空,则抛出异常
         * @param coll
         * @param exceptionInfo
         */
        public static void isEmpty(@SuppressWarnings("rawtypes") Collection coll, ExceptionInfo exceptionInfo) {
            if (CollectionUtils.isNotEmpty(coll)) {
                throw new BusinessException(exceptionInfo);
            }
        }

        /**
         *
         * 若集合为空,则抛出异常
         * @param coll
         * @param exceptionInfo
         */
        public static void notEmpty(@SuppressWarnings("rawtypes") Collection coll, ExceptionInfo exceptionInfo) {
            if (CollectionUtils.isEmpty(coll)) {
                throw new BusinessException(exceptionInfo);
            }
        }
    }
