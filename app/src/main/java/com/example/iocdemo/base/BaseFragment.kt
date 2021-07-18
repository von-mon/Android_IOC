package com.example.iocdemo.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.iocdemo.utils.InjectUtilJava

/**
 *author: TZL
 *Date: 2021/7/18
 *Desc:
 */
open class BaseFragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        InjectUtilJava.injectEvent(activity)
    }
}