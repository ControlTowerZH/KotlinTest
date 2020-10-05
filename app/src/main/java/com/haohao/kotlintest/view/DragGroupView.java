package com.haohao.kotlintest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Description :
 *
 * @author Wanderer
 * @date 2020/9/27
 */
public class DragGroupView extends ViewGroup {
    private int mLastX;
    private int mLastY;

    public DragGroupView(Context context) {
        super(context);
    }

    public DragGroupView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragGroupView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        int lastX = 0, lastY = 0;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - mLastX;
                int offsetY = y - mLastY;
//                layout(getLeft() , getTop() + offsetY,
//                        getRight(), getBottom() + offsetY);
                //((View)getParent()).scrollBy(0,-offsetY);
                ((View)getChildAt(0)).scrollBy(0,offsetY);

                mLastX = x;
                mLastX = y;
                break;
        }
        return true;
    }
}
