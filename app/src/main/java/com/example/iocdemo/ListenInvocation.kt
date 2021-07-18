package com.example.iocdemo

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

/**
 *author: TZL
 *Date: 2021/7/17
 *Desc: 处理代理
 */
class ListenInvocationHandler(private val any: Any, private val myMethod: Method) :
    InvocationHandler {
    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
        return myMethod.invoke(any, args)
    }
}