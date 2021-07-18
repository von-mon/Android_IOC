package com.example.iocdemo.utils;

import android.view.View;

import com.example.iocdemo.ListenInvocationHandler;
import com.example.iocdemo.annotation.EventBase;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * author: TZL
 * Date: 2021/7/17
 * Desc:
 */
public class InjectUtilJava {

    public static void injectEvent(Object object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //拿到当前类
        Class<?> clazz = object.getClass();
        //获取所有的方法
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            //通过方法拿到注解集合
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                Class<?> annotationType = annotation.annotationType();
                EventBase eventBase = annotationType.getAnnotation(EventBase.class);

                if (eventBase == null) {
                    continue;
                }
                //拿到需要用的监听方法
                String listenerSetter = eventBase.listener();
                //监听类型
                Class<?> listenerType = eventBase.listenerType();
                //获取id集合
                Method valueMethod = annotationType.getDeclaredMethod("value");
                int[] viewId = (int[]) valueMethod.invoke(annotation);

                for (int id : viewId) {
                    Method findViewById = clazz.getMethod("findViewById", int.class);
                    View view = (View) findViewById.invoke(object, id);

                    if (view == null) {
                        continue;
                    }
                    Object proxy = Proxy.newProxyInstance(object.getClass().getClassLoader(),
                            new Class[]{listenerType}, new ListenInvocationHandler(object,
                                    method));
                    Method setListener = view.getClass().getMethod(listenerSetter, listenerType);
                    //设置监听事件
                    setListener.invoke(view, proxy);
                }
            }
        }
    }
}
