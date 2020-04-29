package com.haohao.kotlintest.test1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.haohao.kotlintest.R
import kotlinx.android.synthetic.main.activity_anim.*

class AnimActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim)

        lottie_number.setOnClickListener {
            startActivity(Intent(AnimActivity@this, NumberActivity::class.java))
        }
    }

}
