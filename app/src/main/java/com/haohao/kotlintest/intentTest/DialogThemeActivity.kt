package com.haohao.kotlintest.intentTest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.haohao.kotlintest.R
import timber.log.Timber

class DialogThemeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_theme)

        Timber.d(this.localClassName)
    }

    override fun onBackPressed() {
        var intent : Intent = Intent()
        intent.putExtra("key","返回SingleTask")
        setResult(Activity.RESULT_OK,intent)
        super.onBackPressed()
    }
}
