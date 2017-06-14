package com.netease.tyh.neteaseNosToolDemo.util;

import com.alibaba.fastjson.JSON;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * java bean 和 map 互相转化的工具类
 * 使用org.apache.commons.beanutils进行转换
 * Created by bjtangyunhao on 2017/4/11.
 */
public class EntityUtil {
    /**
     * map to object
     * @param map
     * @param beanClass
     * @return
     * @throws Exception
     */
    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null)
            return null;

        Object obj = beanClass.newInstance();

        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            Method setter = property.getWriteMethod();
            if (setter != null) {
                setter.invoke(obj, map.get(property.getName()));
            }
        }

        return obj;
    }

    /**
     * object to map
     * @param obj
     * @return
     * @throws Exception
     */
    public static Map<String, Object> objectToMap(Object obj) throws Exception {
        if(obj == null)
            return null;

        Map<String, Object> map = new HashMap<String, Object>();

        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (key.compareToIgnoreCase("class") == 0) {
                continue;
            }
            Method getter = property.getReadMethod();
            Object value = getter!=null ? getter.invoke(obj) : null;
            map.put(key, value);
        }

        return map;
    }

    public static Map<String, Object> objectToMapWithoutNullValue(Object obj) throws Exception{
        Map<String, Object> map = objectToMap(obj);
        Iterator<Map.Entry<String, Object>> iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, Object> entry = iter.next();
            if(entry.getValue() == null){
                iter.remove();
            }
        }
        return map;
    }


    /**
     * json to map
     * @param json
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> jsonToMap(String json){
        return JSON.parseObject(json, Map.class);
    }
}

