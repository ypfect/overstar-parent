package com.overstar.elasticsearch.utils;

import com.overstar.elasticsearch.dto.ProductBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 反射获取值
 * @Author stanley.yu
 * @Date 2019/4/24 23:33
 */
public class BeanUtils {

    public static final Logger LOG = LoggerFactory.getLogger(BeanUtils.class);

    public static Map<String,Object>  bean2Map(Object o){
        HashMap<String, Object> map = new HashMap<>();
        Field[] declaredFields = o.getClass().getDeclaredFields();
        Arrays.stream(declaredFields).forEach(p->{
            String field = p.getName();
            String methodName = "get" + field.substring(0, 1).toUpperCase() + field.substring(1);
            try {
                Method method = o.getClass().getMethod(methodName);
                map.put(field,method.invoke(o));
            } catch (NoSuchMethodException e) {
                LOG.info("cant find such method maybe field ie boolean type ... try ...");
                String booleanField = "is" + field.substring(0, 1).toUpperCase() + field.substring(1);
                try {
                    Method method = o.getClass().getMethod(booleanField);
                    map.put(booleanField,method.invoke(o));
                } catch (Exception e1) {
                    LOG.error("bean converter failure...");
                    e1.printStackTrace();
                }
            } catch (Exception e){
                LOG.info("bean 2 map exchange failure ...");
            }
        });

        return map;
    }


    public static Map<String, Object> toMap(Object data) {
        Map<String, Object> map = new HashMap<>(16);
        System.out.println(data.getClass().getDeclaredFields().length);
        for (Field field : data.getClass().getDeclaredFields()) {
            String name = field.getName();
            Method method = null;
            try {
                method = data.getClass().getMethod("get" + name.substring(0, 1).toUpperCase() + name.substring(1));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            Object invoke = null;
            try {
                invoke = method.invoke(data);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            map.put(name, invoke);
        }
        return map;
    }

    public static void main(String[] args) {
        ProductBase productBase = new ProductBase();
        productBase.setCityIds("asd");
        productBase.setCommentNum(2);
        productBase.setProductNameZh("我爱大中国");
        productBase.setPlayDays(3);
        productBase.setProductNameEn("nianshaoyouweibuzhibeidongdesmszbei");

        Map<String, Object> stringObjectMap = bean2Map(productBase);
        System.out.println(stringObjectMap);
    }

}

