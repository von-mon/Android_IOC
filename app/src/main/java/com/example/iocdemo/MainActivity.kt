package com.example.iocdemo

import android.os.Bundle
import android.widget.Toast
import com.example.iocdemo.annotation.OnClick
import com.example.iocdemo.annotation.OnLongClick
import com.example.iocdemo.base.BaseActivity


/**
 *author: TZL
 *Date: 2021/7/17
 *Desc:
 */
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)
    }

    @OnClick([R.id.button])
    fun myButtonClick(view: Any) {
        Toast.makeText(this, "click Event", Toast.LENGTH_LONG).show()
    }

    @OnLongClick([R.id.button])
    fun myButtonLongClick(view: Any):Boolean{
        Toast.makeText(this, "long click Event", Toast.LENGTH_LONG).show()
        return true
    }
}