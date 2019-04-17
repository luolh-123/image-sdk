package com.hanclouds.image.util;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @author luolh
 * @version 1.0
 * @date 2019/2/27 18:09
 */
public class JSONUtils {
    public static <T> T toObject(String json, Class<T> tClass){
        return JSON.parseObject(json, tClass);
    }

    public static <T> List<T> toObjects(String json, Class<T> tClass){
        return JSON.parseArray(json, tClass);
    }

    public static String toString(Object object){
        return JSON.toJSONString(object);
    }
}
