package com.common.util;

import java.nio.charset.Charset;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: saleSystem
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
        return str == null || str.trim().equals("") || str.trim().equalsIgnoreCase("NULL");
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

    /**
     * 计算报文长度，不足四位右补空格
     *
     * @param text    报文信息
     * @param needlen 报文长度规定的字符数
     * @return
     */
    public static String getLen(String text, int needlen) {
        if (text != null) {
            int len;
            len = text.getBytes(Charset.forName("GBK")).length;
            String lenStr = String.valueOf(len);
            StringBuffer sb = new StringBuffer(lenStr);
            while (sb.length() < needlen) {
                sb.append(" ");
            }
            return sb.toString();
        }
        return null;
    }

    /**
     * 利用正则表达式判断字符串是否是数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }

    /**
     * 将null字符串替换成""
     *
     * @param str
     * @return
     */
    public static String replacNull(String str) {
        if (null == str) {
            return "";
        } else {
            return str;
        }
    }

    /**
     * 获取内容中-汉字个数
     *
     * @param content - 内容
     * @return int
     */
    public static int getChineseSize(String content) {
        int count = 0;//汉字数量
        for (int i = 0; i < content.length(); i++) {
            if (isChinese(content.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    /**
     * 判断是否是汉字,是汉字返回true
     *
     * @param cha
     * @return
     */
    public static boolean isChinese(char cha) {
        byte[] bytes = Character.toString(cha).getBytes(Charset.forName("GBK"));//gbk编码一个汉字占两位
        return bytes.length == 2;
    }

    /**
     * 去空格
     *
     * @param str
     * @return
     */
    public static String reFormateString(String str) {
        if (isNullString(str)) {
            return "";
        } else {
            return str.trim();
        }
    }

    /**
     * 将数字格式的左面的零去掉
     *
     * @param str
     * @return
     */
    public static String reFormateNumber(String str) {
        Pattern p = Pattern.compile("[^0]{1}");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return str.trim().substring(m.start());
        } else {
            return "0";
        }
    }

    /**
     * 将字符串用空格补足indx位
     *
     * @param str
     * @param indx
     * @return
     */
    public static String formateString(String str, int indx) {
        StringBuilder sb = new StringBuilder(str);
        int len = indx - sb.length() - getChineseSize(sb.toString());
        if (len > 0) {
            for (int i = 0; i < len; i++) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * 将字符串用0补足indx位
     *
     * @param str
     * @param indx
     * @return
     */
    public static String formateNumber(String str, int indx) {
        StringBuilder sb = new StringBuilder(str);
        int len = indx - sb.length() - getChineseSize(sb.toString());
        if (len > 0) {
            for (int i = 0; i < len; i++) {
                sb.insert(0, "0");
            }
        }
        return sb.toString();
    }

    /**
     * 一个汉字占两位，按照位数进行字符串的截取
     *
     * @param str
     * @param beginIndx
     * @param digit
     * @return
     */
    public static String splitBankMsg(String str, int beginIndx, int digit) {
        StringBuffer sb = new StringBuffer(str);
        byte[] bytes = str.getBytes(Charset.forName("GBK"));
        if (bytes.length < beginIndx) {
            return "";
        }
        return new String(bytes, beginIndx - 1, digit + beginIndx > bytes.length ? bytes.length - beginIndx + 1 : digit, Charset.forName("GBK"));
    }

}