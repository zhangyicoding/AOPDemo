package com.estyle.secondlibrary

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.estyle.base.RoutePath
import com.estyle.base.activity.BaseFragmentActivity
import kotlinx.android.synthetic.main.activity_second.*

@Route(path = RoutePath.SECOND)
class SecondActivity : BaseFragmentActivity() {

    @JvmField
    @Autowired(name = "name")
    var name: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        ARouter.getInstance().inject(this)
        start_second_btn.text = name
    }
}
