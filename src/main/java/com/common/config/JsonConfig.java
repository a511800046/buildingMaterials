package com.common.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/7/5.
 */

@Configuration
public class JsonConfig {
    protected JsonConfig() {
    }

    @Bean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
//                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty
        );
        ValueFilter valueFilter = new ValueFilter() {
            public Object process(Object o, String s, Object o1) {
                if (null == o1) {
                    o1 = "";
                }
                return o1;
            }
        };
        fastJsonConfig.setSerializeFilters(valueFilter);
        converter.setFastJsonConfig(fastJsonConfig);

        return converter;
    }
}
