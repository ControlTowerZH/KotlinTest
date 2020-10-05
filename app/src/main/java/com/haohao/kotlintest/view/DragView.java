package com.haohao.kotlintest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

import timber.log.Timber;

/**
 * Description : 一个滑动测试 的view
 *
 * @author Wanderer
 * @date 2020/9/27
 */
public class DragView extends View {
    private int mLastX;
    private int mLastY;
    //声明Scroller变量
    private Scroller mScroller;

    private int  mOffsetY0;

    private float viewX,viewY;
    public DragView(Context context) {
        super(context);
    }

    public DragView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScroller = new Scroller(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        viewX = this.getX();
        viewY = this.getY();
        Timber.d("控件的位置"+viewX+" "+viewY);
        if (mScroller.computeScrollOffset()){
            //动画未完成，禁止二次滑动
            return true;
        }
        //获取到手指处的横坐标和纵坐标
//        int x = (int) event.getX();  //getX 是点击事件距离现在 视图的位置（视图还在上一个位置） 自动切换位置了
//        int y = (int) event.getY();


        int lastX = 0, lastY = 0;

        int x = (int) event.getRawX();  // getRawX 是一直相对于屏幕的  视图位置每次之后都会改变
        int y = (int) event.getRawY();
        //Android坐标系嘛，用的是绝对距离



        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Timber.d("点击事件按下");
                mLastX = x;
                mLastY = y;
                Timber.d("点击事件x："+x+" mLastY"+mLastY);
                mOffsetY0 =y;

                //this.performClick();
                break;
            case MotionEvent.ACTION_MOVE:
                Timber.d("点击事件移动");
                Timber.d("=x："+y+" mLastY"+mLastY);
                Timber.d("getTop："+getTop());
                int offsetX = x - mLastX;
                int offsetY = y - mLastY;

                //实现View跟随手指移动的效果
//                ((View)getParent()).scrollBy(0, -offsetY);
//                //重新设置初始坐标
//                mLastX = x;
//                mLastY = y;
//                layout(getLeft() , getTop() + offsetY,
//                        getRight(), getBottom() + offsetY);
                //offsetTopAndBottom(offsetY);
                Timber.d("点击事件移动"+mOffsetY0 +" MLast"+mLastY+" 移动偏移"+offsetY  +" 移动Y"+y);
                ((View) getParent()).scrollBy(0,- offsetY);
                //((View) getParent()).scrollTo(-mLastX,-y);
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_UP:
                int offsetY0 = y-mOffsetY0 ;// 内边距
//                Timber.d("点击事件抬起"+offsetY0+" mLast:"+mOffsetY0+" mOffsetY:"+y);
//               // int offsetY0 = y - mLastY;
////                //当手指抬起时执行滑动过程
                View view = (View) getParent();
                mScroller.startScroll(0, view.getScrollY(),
                        0, offsetY0, 100);
//                //调用重绘来间接调用computeScroll()方法
                invalidate();
                 //((View) getParent()).scrollBy(0,offsetY0);


                //((View) getParent()).scrollTo(0, mLastY);
               // mLastX = x;
               // mLastY = y;

               // this.getX();
                break;
        }
        return true;
    }
    @Override
    public void computeScroll() {
        super.computeScroll();
//        //判断滑动过程是否完成
        if (mScroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            //通过重绘来不断调用computeScroll()方法
            invalidate();
        }
    }
}
