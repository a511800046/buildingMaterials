package com.common.util;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: web_interface
 * @description: 字符串工具类
 * @author: chengy
 * @create: 2018-07-09 17:22
 **/
public class StringUtil {
    /**
     * 判断是否是空字符串，“”也算是空字符串，null也算是空字符串
     *
     * @param str
     * @return boolean
     */
    public static boolean isNullString(String str) {
        if (str == null || str.trim().equals("") || str.trim().equalsIgnoreCase("NULL")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 生成32位唯一编码
     *
     * @return String
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 指定字符在字符串中出现的个数
     *
     * @param str
     * @param find
     * @return
     */
    public static int findANumber(String str, String find) {
        Pattern pattern = Pattern.compile(find);
        Matcher matcher = pattern.matcher(str);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}