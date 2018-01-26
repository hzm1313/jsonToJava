package com.cn.yc.aop;


import com.cn.yc.json.AbstractConvertJson;

import java.lang.reflect.InvocationHandler;

/**
 * Created by DT167 on 2018/1/26.
 */
public class ObjectDynamicProxy extends DynamicProxy{
    public static <T> T newProxyInstance(Object object){
//获得ClassLoader
        ClassLoader loader = object.getClass().getClassLoader();
//获得接口数组
        Class<?>[] classes = object.getClass().getInterfaces();
//获得handler
        InvocationHandler handler = new MyInvocationHandler(object);
        return newProxyInstance(loader, classes, handler);
    }
}
