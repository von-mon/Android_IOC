package com.example.iocdemo.annotation

import android.view.View

/**
 *author: TZL
 *Date: 2021/7/17
 *Desc:点击事件注解
 */

//运行时起作用
@Retention(AnnotationRetention.RUNTIME)
//作用在方法上
@Target(AnnotationTarget.FUNCTION)
@EventBase(listener = "setOnClickListener", listenerType = View.OnClickListener::class, callbackMethod = "onClick")
annotation class OnClick(val value: IntArray)
