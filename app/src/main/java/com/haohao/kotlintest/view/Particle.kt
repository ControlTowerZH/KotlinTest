package com.haohao.kotlintest.view

/**
 * Description : 说明 Particle 粒子.每一个粒子的信息，是粒子的半径，粒子的速度
 *
 * @author Wanderer
 * @date 2020/10/25
 */
class Particle {
    var x:Float=0F//X坐标
    var y:Float=0F//Y坐标
    var radius:Float=0F//半径
    var speed:Float=0F//速度
    var alpha: Int=0//透明度
    var maxOffset:Float=500f//最大移动距离 此处设置的无效
    var offset:Float=0f//当前移动距离
    var angle:Double= 0.0//粒子角度
    //主函数
    constructor()

    //次函数
    constructor(x:Float,y:Float,radius:Float,speed:Float,alpha:Int,offset:Float,angle:Double,maxOffset:Float):this(){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.speed = speed;
        this.alpha = alpha;
        this.offset = offset;
        this.angle = angle;
        this.maxOffset = maxOffset;
    }
}