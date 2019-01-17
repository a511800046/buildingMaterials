package com.common.config;

import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.ValueFilter;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

/**
 * @program: saleSystem
 * @description: 配置json序列化
 * @author: chengy
 * @create: 2018-11-19 10:18
 **/
@Configuration
public class FastJsonConfig implements SerializeFilter {
    ValueFilter valueFilter = new ValueFilter() {
        @Override
        public Object process(Object object, String name, Object value) {


            if (value != null && value instanceof BigDecimal) {
                String formatvalue = String.format("%.2f", ((BigDecimal) value).doubleValue());
                return formatvalue;
            } else {
                return value;
            }
        }

    };

    public ValueFilter getValueFilter() {
        return valueFilter;
    }

    public void setValueFilter(ValueFilter valueFilter) {
        this.valueFilter = valueFilter;
    }
}

