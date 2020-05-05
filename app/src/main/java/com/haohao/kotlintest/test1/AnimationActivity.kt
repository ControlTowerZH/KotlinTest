package com.haohao.kotlintest.test1

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
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
