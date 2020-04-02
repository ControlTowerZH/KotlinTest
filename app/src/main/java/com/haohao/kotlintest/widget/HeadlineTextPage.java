package com.haohao.kotlintest.widget;

import android.content.Context;
import android.text.Layout;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatEditText;


public class HeadlineTextPage extends AppCompatEditText {

    private OnSelectListener mListener;
    private boolean isCanSelect = false;
    private long initTime, endTime;
    float[] oldXY;

    public HeadlineTextPage(Context context) {
        super(context);
        initialize();
    }

    public HeadlineTextPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public HeadlineTextPage(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialize();
    }

    private void initialize() {
        setGravity(Gravity.TOP);
    }


    /**
     * 处理小米长按事件
     * @param menu
     */
    @Override
    protected void onCreateContextMenu(ContextMenu menu) {
        super.onCreateContextMenu(menu);
    }



    @Override
    public boolean getDefaultEditable() {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);

        int action = event.getAction();
        Layout layout = getLayout();
        int line = 0;
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                oldXY = new float[]{event.getX(), event.getY()};
                isCanSelect = true;
                initTime = System.currentTimeMillis();
                break;
            case MotionEvent.ACTION_MOVE:
                if (Math.abs(event.getX() - oldXY[0]) > 8 && Math.abs(event.getY() - oldXY[1]) > 8) {
                    isCanSelect = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                if (isCanSelect) {
                    endTime = System.currentTimeMillis();
                    if (endTime - initTime > 500) {
                    } else {
                        line = layout.getLineForVertical(getScrollY() + (int) event.getY());
                        int off = layout.getOffsetForHorizontal(line, (int) event.getX());
                        String selectText = getSelectText(off);
                        if (selectText.length() > 0) {
                            this.setCursorVisible(true);
                            if (mListener != null) {
                                mListener.onSelect(selectText);
                            }
                        } else {
                            this.setCursorVisible(false);
                        }
                    }
                }
                break;
        }
        return true;
    }

    private String getSelectText(int currOff) {
        int leftOff = currOff, rigthOff = currOff;
        int length = getText().toString().length();
        while (true) {
            if (leftOff <= 0) {
                break;
            }
            if (leftOff != 0) {
                leftOff = leftOff - 1;
                if (leftOff < 0) {
                    leftOff = 0;
                }
            }
            String selectText = getText().subSequence(leftOff, currOff).toString();
            if (!selectText.matches("^[a-zA-Z'-]*")) {
                leftOff += 1;
                break;
            }
        }
        while (true) {
            if (rigthOff >= length) {
                break;
            }
            rigthOff = rigthOff + 1;
            if (rigthOff > length) {
                rigthOff = length;
            }
            String selectText = getText().subSequence(currOff, rigthOff).toString();
            if (!selectText.matches("^[a-zA-Z'-]*")) {
                rigthOff -= 1;
                break;
            }
        }
        String endString = "";
        try {
            endString = getText().subSequence(leftOff, rigthOff).toString();
            if (endString.trim().length() > 0) {
                Selection.setSelection(getEditableText(), leftOff, rigthOff);
            }
        } catch (Exception e) {
        }

        return endString.trim();
    }

    public void setOnSelectListener(OnSelectListener listener) {
        this.mListener = listener;
    }

    public void clearSelect() {
        Selection.setSelection(getEditableText(), 0, 0);
    }

    public interface OnSelectListener {

        void onSelect(String text);
    }
}
