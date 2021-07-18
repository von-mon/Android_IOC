package com.example.iocdemo.annotation

import kotlin.reflect.KClass

/**
 *author: TZL
 *Date: 2021/7/17
 *Desc: 所有注解处理基本注解
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.ANNOTATION_CLASS)
annotation class EventBase(val listener:String, val listenerType: KClass<*>, val callbackMethod:String)
