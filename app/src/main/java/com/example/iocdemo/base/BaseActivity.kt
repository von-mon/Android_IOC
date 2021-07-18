package com.example.iocdemo.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.iocdemo.utils.InjectUtilJava

/**
 *author: TZL
 *Date: 2021/7/17
 *Desc: 基类
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        InjectUtilJava.injectEvent(this)
    }



}