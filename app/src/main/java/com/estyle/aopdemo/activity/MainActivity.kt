package com.estyle.aopdemo.activity

import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.estyle.aopdemo.BuildConfig
import com.estyle.aopdemo.R
import com.estyle.base.RoutePath
import com.estyle.base.activity.BaseFragmentActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseFragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text_view.text = "debug: ${BuildConfig.DEBUG}"

        start_second_btn.setOnClickListener {
            ARouter.getInstance()
                .build(RoutePath.SECOND)
                .withString("name", "hehe")
                .navigation()
        }
        custom_btn.setOnClickListener(MyOnClickListener())

        // 带返回值的方法，不处理异常
        divide(8, 2)
        // 用于检测卡顿
        block(1500)
    }

    private fun divide(a: Int, b: Int) = a / b

    private fun block(duration: Long) {
        Thread.sleep(duration)
    }

    private class MyOnClickListener : View.OnClickListener {
        override fun onClick(v: View?) {
            ARouter.getInstance()
                .build(RoutePath.SECOND)
                .withString("name", "hehe")
                .navigation()
        }
    }
}
