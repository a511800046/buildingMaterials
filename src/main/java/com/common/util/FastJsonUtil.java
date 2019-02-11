package com.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: dispatchingSystem
 * @description: fastjson工具类
 * @author: chengy
 * @create: 2018-11-17 20:27
 **/
public class FastJsonUtil {
    private static final SerializerFeature[] features = {
            SerializerFeature.WriteMapNullValue,
            SerializerFeature.WriteNullListAsEmpty,
            SerializerFeature.WriteNullStringAsEmpty,
            SerializerFeature.WriteBigDecimalAsPlain

    };
    private static final SerializeFilter[] filters = {
            //new FastJsonConfig().getValueFilter()

    };

    /**
     * json字符串转map集合
     *
     * @param jsonStr
     * @return
     */
    public static Map json2Map(String jsonStr) {
        return JSON.parseObject(jsonStr, new HashMap<>().getClass());
    }

    /**
     * map转json字符串
     *
     * @param map
     * @return
     */
    public static String map2Json(Map<String, String> map) {
        return JSON.toJSONString(map, filters, features);
    }

    /**
     * json字符串转换成对象
     *
     * @param jsonString
     * @param cls
     * @return
     */
    public static <T> T json2Bean(String jsonString, Class<T> cls) {
        return JSON.parseObject(jsonString, cls);
    }

    /**
     * 对象转换成json字符串
     *
     * @param obj
     * @return
     */
    public static String bean2Json(Object obj) {
        return JSON.toJSONString(obj, filters, features);
    }

    /**
     * json字符串转换成List集合
     * (需要实体类)
     *
     * @param jsonString
     * @return
     */
    public static <T> List<T> json2List(String jsonString, Class cls) {
        return JSON.parseArray(jsonString, cls);
    }

    /**
     * json字符串转换成ArrayList集合
     * (需要实体类)
     *
     * @param jsonString
     * @return
     */
    public static <T> ArrayList<T> json2ArrayList(String jsonString, Class cls) {
        return (ArrayList<T>) JSON.parseArray(jsonString, cls);
    }

    /**
     * List集合转换成json字符串
     *
     * @param obj
     * @return
     */
    public static String list2Json(Object obj) {
        return JSONArray.toJSONString(obj, filters, features);
    }

    /**
     * json转List
     * (不需要实体类)
     *
     * @param jsonStr
     * @return
     */
    public static JSONArray json2List(String jsonStr) {
        return JSON.parseArray(jsonStr);
    }

}
