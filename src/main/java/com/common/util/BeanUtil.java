package com.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: example-spring-boot-security
 * @description: 转换工具类
 * @author: chengy
 * @create: 2018-11-14 09:18
 **/
public class BeanUtil {
    private static Logger logger = LoggerFactory.getLogger(BeanUtil.class);

    /**
     * 将Map对象通过反射机制转换成Bean对象,忽略mapkey的大小写
     *
     * @param mapResult 存放数据的map对象
     * @param clazz     待转换的class
     * @return 转换后的Bean对象
     * @throws Exception 异常
     */
    public static <T> T mapToBean(Map mapResult, Class<?> clazz) {
        T obj = null;
        try {
            if (mapResult != null && !mapResult.isEmpty()) {
                obj = (T) clazz.newInstance();
                Map<String, Object> destPropertyMap = new HashMap<>();
                for (Field curField : clazz.getDeclaredFields()) {
                    Iterator entries = mapResult.entrySet().iterator();
                    while (entries.hasNext()) {
                        Map.Entry<String, Object> entry = (Map.Entry) entries.next();
                        //忽略map中的下划线和大小写
                        if (entry.getKey().replaceAll("_", "").equalsIgnoreCase(curField.getName())) {
                            destPropertyMap.put(curField.getName(), entry.getValue());
                        }
                    }

                }

                for (Map.Entry<String, Object> entry : destPropertyMap.entrySet()) {
                    String propertyName = entry.getKey();       //属性名
                    Object value = entry.getValue();
                    String setMethodName = "set"
                            + propertyName.substring(0, 1).toUpperCase()
                            + propertyName.substring(1);
                    Field field = getClassField(clazz, propertyName);
                    if (field == null)
                        continue;
                    Class<?> fieldTypeClass = field.getType();
                    value = convertValType(value, fieldTypeClass);
                    try {
                        clazz.getMethod(setMethodName, field.getType()).invoke(obj, value);
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            logger.info(e.getStackTrace().toString());
        }
        return obj;
    }

    /**
     * 将Object类型的值，转换成bean对象属性里对应的类型值
     *
     * @param value          Object对象值
     * @param fieldTypeClass 属性的类型
     * @return 转换后的值
     */
    private static Object convertValType(Object value, Class<?> fieldTypeClass) {
        Object retVal = null;
        if (Long.class.getName().equals(fieldTypeClass.getName())
                || long.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Long.parseLong(value.toString());
        } else if (Integer.class.getName().equals(fieldTypeClass.getName())
                || int.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Integer.parseInt(value.toString());
        } else if (Float.class.getName().equals(fieldTypeClass.getName())
                || float.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Float.parseFloat(value.toString());
        } else if (Double.class.getName().equals(fieldTypeClass.getName())
                || double.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Double.parseDouble(value.toString());
        } else {
            retVal = value;
        }
        return retVal;
    }

    /**
     * 获取指定字段名称查找在class中的对应的Field对象(包括查找父类)
     *
     * @param clazz     指定的class
     * @param fieldName 字段名称
     * @return Field对象
     */
    private static Field getClassField(Class<?> clazz, String fieldName) {
        if (Object.class.getName().equals(clazz.getName())) {
            return null;
        }
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }

        Class<?> superClass = clazz.getSuperclass();
        if (superClass != null) {// 简单的递归一下
            return getClassField(superClass, fieldName);
        }
        return null;
    }


    public static void main(String[] args) throws Exception {
        String pwt = BCrypt.hashpw("", BCrypt.gensalt());
        System.out.println(pwt.toString());
    }
}
