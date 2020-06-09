package com.haohao.kotlintest.intentTest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.haohao.kotlintest.R
import com.haohao.kotlintest.util.ToastUtils
import kotlinx.android.synthetic.main.activity_single_task.*
import timber.log.Timber

class SingleTaskActivity : AppCompatActivity() {
   private val requestCode: Int =200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_task)

        Timber.d(this.localClassName)

        btn_to_dialog.setOnClickListener {
            startActivityForResult(Intent(this,DialogThemeActivity::class.java),requestCode)}
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==this.requestCode&&resultCode== Activity.RESULT_OK){
            val back:String = data!!.getStringExtra("key")
            if (!TextUtils.isEmpty(back)){
                ToastUtils.showShort(this,back)
            }
        }
    }
}
