package com.haohao.kotlintest.test1

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.PixelFormat
import android.os.Bundle
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.WindowManager
import android.view.animation.Animation
//import android.view.animation.AnimationUtils
import android.view.animation.TranslateAnimation
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
//import com.google.android.material.animation.AnimationUtils
import com.haohao.kotlintest.R
import kotlinx.android.synthetic.main.activity_animation.*

class AnimationActivity : AppCompatActivity() {

    private var topUp: TranslateAnimation? = null
    private var topDown: TranslateAnimation? = null
    private var bottomUp: TranslateAnimation? = null
    private var bottomDown: TranslateAnimation? = null
    private var leftShow: TranslateAnimation? = null
    private var leftGone: TranslateAnimation? = null
    private var rightGone: TranslateAnimation? = null
    private var rightShow: TranslateAnimation? = null
    private  var isShow: Boolean =true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        createRemovedBtn()
        topUp = getUpMove()
        topDown = getUpMoveBottom()
        bottomUp = getDownMove()
        bottomDown = getDownMoveBottom()
        leftShow = getLeftShow()
        leftGone = getLeftGone()
        rightGone =getRightGone()
        rightShow=getRightShow()

        initClick()
    }

    private fun initClick() {
        fl_home_bg.setOnClickListener {
            if (isShow){
                isShow=false
                fl_top.startAnimation(topUp)
                fl_bottom.startAnimation(bottomDown)
                fl_left.startAnimation(leftGone)
                fl_right.startAnimation(rightGone)
                fl_top.visibility = View.GONE
                fl_bottom.visibility =View.GONE
                fl_left.visibility =View.GONE
                fl_right.visibility=View.GONE
            }else{
                isShow=true
                fl_top.startAnimation(bottomUp)
                fl_bottom.startAnimation(topDown)
                fl_left.startAnimation(leftShow)
                fl_right.startAnimation(rightShow)
                fl_top.visibility=View.VISIBLE
                fl_bottom.visibility=View.VISIBLE
                fl_left.visibility=View.VISIBLE
                fl_right.visibility=View.VISIBLE
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun createRemovedBtn() {
        val button = Button(this)
        button.text = "移动按钮"
        val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val layoutParams = WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT
                , WindowManager.LayoutParams.WRAP_CONTENT, 0, 0, PixelFormat.TRANSLUCENT)
        layoutParams.flags = (WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                or WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                or WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                or WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION
        layoutParams.gravity = Gravity.START or Gravity.TOP
        layoutParams.x = 200
        layoutParams.y = 200
        windowManager.addView(button, layoutParams)
        button.setOnTouchListener(object : OnTouchListener {
            var lastX = 0
            var lastY = 0
            override fun onTouch(v: View, event: MotionEvent): Boolean {
                val rawX = event.rawX.toInt()
                val rawY = event.rawY.toInt()
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        lastX = rawX
                        lastY = rawY
                    }
                    MotionEvent.ACTION_MOVE -> {
                        layoutParams.x += rawX - lastX
                        layoutParams.y += rawY - lastY
                        windowManager.updateViewLayout(v, layoutParams)
                        lastX = rawX
                        lastY = rawY
                    }
                }
                return true
            }
        })
    }


    private fun getUpMove(): TranslateAnimation? { //y轴由0向-1 移动一个单位
        val translateAnimation = TranslateAnimation(Animation.RELATIVE_TO_SELF,
                0F, Animation.RELATIVE_TO_SELF, 0F, Animation.RELATIVE_TO_SELF,
                0F, Animation.RELATIVE_TO_SELF, -1.0f)
        translateAnimation.duration = 500
        translateAnimation.fillAfter = true
        return translateAnimation
    }

    private fun getDownMove(): TranslateAnimation? { //y轴由-1向0 移动一个单位
        val translateAnimation = TranslateAnimation(Animation.RELATIVE_TO_SELF,
                0F, Animation.RELATIVE_TO_SELF, 0F, Animation.RELATIVE_TO_SELF,
                -1.0f, Animation.RELATIVE_TO_SELF, 0F)
        translateAnimation.duration = 500
        translateAnimation.fillAfter = true
        return translateAnimation
    }

    private fun getUpMoveBottom(): TranslateAnimation? { //y轴由1向0 移动一个单位        -1 0 1
        val translateAnimation = TranslateAnimation(Animation.RELATIVE_TO_SELF,
                0F, Animation.RELATIVE_TO_SELF, 0F, Animation.RELATIVE_TO_SELF,
                1.0f, Animation.RELATIVE_TO_SELF, 0F)
        translateAnimation.duration = 500
        translateAnimation.fillAfter = true
        return translateAnimation
    }

    private fun getDownMoveBottom(): TranslateAnimation? { //y轴由0向1 移动一个单位
        val translateAnimation = TranslateAnimation(Animation.RELATIVE_TO_SELF,
                0F, Animation.RELATIVE_TO_SELF, 0F, Animation.RELATIVE_TO_SELF,
                0f, Animation.RELATIVE_TO_SELF, 1.0f)
        translateAnimation.duration = 500
        translateAnimation.fillAfter = true
        return translateAnimation
    }

    private fun getLeftShow(): TranslateAnimation? { //x轴由-1向0 移动一个单位
        val translateAnimation = TranslateAnimation(Animation.RELATIVE_TO_SELF,
                -1F, Animation.RELATIVE_TO_SELF, 0F, Animation.RELATIVE_TO_SELF,
                0f, Animation.RELATIVE_TO_SELF, 0f)
        translateAnimation.duration = 500
        translateAnimation.fillAfter = true
        return translateAnimation
    }

    private fun getLeftGone(): TranslateAnimation? { //x轴由0向-1 移动一个单位
        val translateAnimation = TranslateAnimation(Animation.RELATIVE_TO_SELF,
                0F, Animation.RELATIVE_TO_SELF, -1F, Animation.RELATIVE_TO_SELF,
                0f, Animation.RELATIVE_TO_SELF, 0f)
        translateAnimation.duration = 500
        translateAnimation.fillAfter = true
        return translateAnimation
    }

    private fun getRightShow(): TranslateAnimation? { //x轴由1向0 移动一个单位
        val translateAnimation = TranslateAnimation(Animation.RELATIVE_TO_SELF,
                1F, Animation.RELATIVE_TO_SELF, 0F, Animation.RELATIVE_TO_SELF,
                0f, Animation.RELATIVE_TO_SELF, 0f)
        translateAnimation.duration = 500
        translateAnimation.fillAfter = true
        return translateAnimation
    }

    private fun getRightGone(): TranslateAnimation? { //x轴由0向1 移动一个单位
        val translateAnimation = TranslateAnimation(Animation.RELATIVE_TO_SELF,
                0F, Animation.RELATIVE_TO_SELF, 1F, Animation.RELATIVE_TO_SELF,
                0f, Animation.RELATIVE_TO_SELF, 0f)
        translateAnimation.duration = 500
        translateAnimation.fillAfter = true
        return translateAnimation
    }
}
