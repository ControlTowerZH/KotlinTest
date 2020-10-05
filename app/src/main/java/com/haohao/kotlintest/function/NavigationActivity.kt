package com.haohao.kotlintest.function

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.haohao.kotlintest.R
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        textView_btn.setOnClickListener {

        }
        textView_btn.performClick()
    }

}
