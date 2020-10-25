package com.haohao.kotlintest.view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator
import java.lang.Math.*
import java.util.*
import kotlin.properties.Delegates
import kotlin.system.measureTimeMillis

/**
 * Description : 说明
 *
 * @author Wanderer
 * @date 2020/10/25
 */
class DimpleView (context: Context?, attrs: AttributeSet?) : View(context, attrs){
    //定义一个粒子的集合
    private var particleList = mutableListOf<Particle>()
    //定义画笔
    var paint = Paint()
    var centerX by Delegates.notNull<Float>()
    var centerY by Delegates.notNull<Float>()
    private val random = Random()
    var path = Path()

    private val pathMeasure = PathMeasure()//路径，用于测量扩散圆某一处的X,Y值
    private var pos = FloatArray(2) //扩散圆上某一点的x,y
    private val tan = FloatArray(2)//扩散圆上某一点切线

    private var animator = ValueAnimator.ofFloat(0f, 1f)
    init {
        animator.duration = 2000
        animator.repeatCount = -1
        animator.interpolator = LinearInterpolator()
        animator.addUpdateListener {
            updateParticle(it.animatedValue as Float)
            invalidate()//重绘界面
        }
    }

    //跟新粒子动画
    private fun updateParticle(value: Float) {
        particleList.forEach {particle->
            if(particle.offset >particle.maxOffset){
                particle.offset=0f
                particle.speed= (random.nextInt(10)+5).toFloat()
            }
            particle.alpha= ((1f - particle.offset / particle.maxOffset)  * 225f).toInt()
            particle.x = (centerX+ cos(particle.angle) * (280f + particle.offset)).toFloat()
            if (particle.y > centerY) {
                particle.y = (sin(particle.angle) * (280f + particle.offset) + centerY).toFloat()
            } else {
                particle.y = (centerY - sin(particle.angle) * (280f + particle.offset)).toFloat()
            }
            particle.offset += particle.speed.toInt()
//            if(particle.y - centerY >particle.maxOffset){
//                particle.y=centerY //重新设置Y值
//                particle.x = random.nextInt((centerX * 2).toInt()).toFloat() //随机设置X值
//                particle.speed= (random.nextInt(10)+5).toFloat() //随机设置速度
//                //设置粒子的透明度
//                particle.alpha= ((1f - (particle.y-centerY) / particle.maxOffset)  * 225f).toInt()
//            }
//            particle.y += particle.speed
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerX= (w/2).toFloat()
        centerY= (h/2).toFloat()
        path.addCircle(centerX, centerY, 280f, Path.Direction.CCW)//280f
        pathMeasure.setPath(path, false)
       val random= Random()
        var nextX=0f
        var nextY=0f
        var speed=0f //定义一个速度
        var angle=0.0
        var offSet=0
        var maxOffset=0
        for (i in 0..2000){
             //按比例测量路径上每一点的值
             pathMeasure.getPosTan(i / 2000f * pathMeasure.length, pos, tan)
            nextX = pos[0]+random.nextInt(6) - 3f //X值随机偏移
            nextY=  pos[1]+random.nextInt(6) - 3f//Y值随机偏移
//            nextX=random.nextInt((centerX*2).toInt())
//             //初始化Y值，这里是以起始点作为最低值，最大距离作为最大值
//             nextY= random.nextInt(400)+centerY
             //反余弦函数可以得到角度值，是弧度
             angle=acos(((pos[0] - centerX) / 280f).toDouble())
             //speed= random.nextInt(10)+5 //速度从5-15不等
            speed= random.nextInt(2) + 2f
            offSet = random.nextInt(200)
            maxOffset = random.nextInt(200)
            particleList.add(
                    //每一个粒子的信息
                    Particle(nextX, nextY, 2f, speed, 100,offSet.toFloat(),angle, maxOffset.toFloat())
            )
        }
        animator.start()//别忘了启动动画
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = Color.WHITE
        paint.isAntiAlias = true

        var time= measureTimeMillis {
            particleList.forEach {
                //设置画笔的透明度
                paint.alpha=it.alpha
                canvas!!.drawCircle(it.x,it.y,it.radius,paint)
            }
        }

        Log.i("dimple","绘制时间$time ms")
    }
}