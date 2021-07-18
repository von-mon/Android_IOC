package com.example.iocdemo.annotation

import android.view.View.OnLongClickListener

/**
 *author: TZL
 *Date: 2021/7/17
 *Desc:长按事件注解
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
@EventBase(listener = "setOnLongClickListener", listenerType = OnLongClickListener::class, callbackMethod = "onLongClick")
annotation class OnLongClick(val value: IntArray)
