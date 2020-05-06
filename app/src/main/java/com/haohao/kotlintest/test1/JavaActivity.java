package com.haohao.kotlintest.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.haohao.kotlintest.R;

public class JavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        createRemovedBtn();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void createRemovedBtn() {
        final Button button = new Button(this);
        button.setText("移动按钮");
        final WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        final WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT
                , WindowManager.LayoutParams.WRAP_CONTENT, 0, 0, PixelFormat.TRANSLUCENT);
        layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
        layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION;
        layoutParams.gravity = Gravity.START | Gravity.TOP;
        layoutParams.x = 200;
        layoutParams.y = 200;
        assert windowManager != null;
        windowManager.addView(button, layoutParams);
        button.setOnTouchListener(new View.OnTouchListener() {
            int lastX;
            int lastY;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int rawX = (int) event.getRawX();
                int rawY = (int) event.getRawY();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        lastX = rawX;
                        lastY = rawY;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        layoutParams.x += rawX - lastX;
                        layoutParams.y += rawY - lastY;
                        windowManager.updateViewLayout(v, layoutParams);
                        lastX = rawX;
                        lastY = rawY;
                        break;
                }
                return true;
            }
        });
    }
}
