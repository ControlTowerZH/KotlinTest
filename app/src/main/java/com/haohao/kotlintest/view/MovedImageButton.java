package com.haohao.kotlintest.view;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.animation.OvershootInterpolator;

import com.haohao.kotlintest.util.SizeUtils;

import androidx.appcompat.widget.AppCompatImageButton;

/**
 * 自定义拖拽按钮
 */
public class MovedImageButton extends AppCompatImageButton {

    private int lastX;
    private int lastY;
    private float screenWidth;

    public MovedImageButton(Context context) {
        super(context);
    }

    public MovedImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MovedImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
    }

    /**
     * 重写触摸事件方法
     * @param event 触摸事件
     * @return boolean
     */
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //触摸事件每次返回的横纵坐标
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //按下时的横纵坐标
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                //移动的距离
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                //第一种方法 移动位置
                layout(getLeft() + offsetX,
                        getTop() + offsetY,
                        getRight() + offsetX,
                        getBottom() + offsetY);
                //第二种方法
                //offsetLeftAndRight(offsetX);
                //offsetTopAndBottom(offsetY);
                break;
            case MotionEvent.ACTION_UP:
                adsorbAnim(event.getRawX(), event.getRawY());
                break;
        }
        return super.onTouchEvent(event);
    }

    private void adsorbAnim(float rawX, float rawY) {
        //靠顶吸附
        if (rawY <= SizeUtils.INSTANCE.dp2px(getContext(), 200)) {//注意rawY包含了标题栏的高
            animate().setDuration(400)
                    .setInterpolator(new OvershootInterpolator())
                    .yBy(-getY() )//- getHeight() / 2.0f
                    .start();
        } else if (rawX >= screenWidth / 2) {//靠右吸附
            animate().setDuration(400)
                    .setInterpolator(new OvershootInterpolator())
                    .xBy(screenWidth - getX() - getWidth() / 1.0f)
                    .start();
        } else {//靠左吸附
            ObjectAnimator animator = ObjectAnimator.ofFloat(this, "x", getX(), -getWidth()/3.0f);//
            animator.setInterpolator(new OvershootInterpolator());
            animator.setDuration(400);
            animator.start();
        }
    }
}
