package com.haohao.kotlintest.test1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.haohao.kotlintest.R

/**
 * 移动按钮的 容器 ，拖动按钮是个自定义控件
 */
class MoveActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move)
    }
}
