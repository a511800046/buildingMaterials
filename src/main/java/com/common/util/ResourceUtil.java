package com.common.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @program: saleSystem
 * @description: properties读取类
 * @author: chengy
 * @create: 2018-07-09 17:22
 **/
public class ResourceUtil extends PropertyPlaceholderConfigurer {
    private static Map<String, String> ctxPropertiesMap;

    /**
     * 获取properties中的内容
     *
     * @param key
     * @return
     */
    public static String getValue(String key) {
        return ctxPropertiesMap.get(key);
    }

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        ctxPropertiesMap = new HashMap<>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            ctxPropertiesMap.put(keyStr, value);
        }
    }
}
