package com.haohao.kotlintest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;


public class BatteryView extends View {
    public BatteryView(Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    public BatteryView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0, 0);
    }

    public BatteryView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }

    public BatteryView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    private Paint mPaint;
    private Paint topSlicePaint;
    private Shader mShader;
    private Shader topProgressShader;
    private Path mPath;
    private int progress;

    int length = 1000; //长
    int farLen = 800; //远边的长度
    int farnearDistance = 160; //近边和远边的距离
    int farOffsetX = (length - farLen)/2; //远边相对近边X方向的偏移量
    int height = 40; //高度/厚度
    int yOffSet = 10; //y偏移量

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setDither(true); //设置防抖动
        mPaint.setColor(Color.parseColor("#000000"));
        mPaint.setStyle(Paint.Style.FILL);//实心
        mShader = new LinearGradient(0, 0, 600, 600,
                new int[]{0xff778899, 0xffcdcdcd},
                null, Shader.TileMode.CLAMP);
        topProgressShader = new LinearGradient(0, 0, 600, 600,
                new int[] {0xff32CD32, 0xff2E8B57}, null, Shader.TileMode.CLAMP);
        mPath = new Path();

        topSlicePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        topSlicePaint.setDither(true); //设置防抖动
        topSlicePaint.setShader(mShader);
        //mPaint.setShader(mShader);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(getTopSlicePath(), topSlicePaint);


        mPaint.setShader(null);
        mPaint.setColor(0xff778899);
        canvas.drawPath(getFrontSlicePath(), mPaint);

        //progress

        Path frontSliceProgressPath = getgetFrontSliceProgressPath(progress);
        if (frontSliceProgressPath != null) {
            mPaint.setColor(0xff32CD32);
            canvas.drawPath(frontSliceProgressPath, mPaint);
        }

        Path topSliceProgressPath = getTopSliceProgressPath(progress);
        if (topSliceProgressPath != null) {
            mPaint.setShader(topProgressShader);
            canvas.drawPath(topSliceProgressPath, mPaint);
        }

    }

    private Path getTopSlicePath() {
        Path mPath = new Path();
        mPath.moveTo((length - farLen) / 2, yOffSet);
        mPath.lineTo(0, farnearDistance + yOffSet);
        mPath.lineTo(length, farnearDistance + yOffSet);
        mPath.lineTo(length - ((length - farLen) / 2), yOffSet);
        mPath.close();
        return mPath;
    }

    private Path getFrontSlicePath() {
        return getgetFrontSliceProgressPath(100);
    }

    private Path getgetFrontSliceProgressPath(int progress) {
        if (progress > 0) {
            int progressX = (int) ((progress * 1.0f / 100) * length);
            Path mPath = new Path();
            mPath.moveTo(0, farnearDistance + yOffSet);
            mPath.lineTo(0, farnearDistance + yOffSet + height);
            mPath.lineTo(progressX, farnearDistance + yOffSet + height);
            mPath.lineTo(progressX, farnearDistance + yOffSet);
            mPath.close();
            return mPath;
        }
        return null;
    }

    private Path getTopSliceProgressPath(int progress) {
        if (progress > 0) {
            int progressFarX = (int) ((progress * 1.0f / 100) * farLen);
            int progressNearX = (int) ((progress * 1.0f / 100) * length);
            Path mPath = new Path();
            mPath.moveTo((length - farLen) / 2, yOffSet);
            mPath.lineTo(0, farnearDistance + yOffSet);
            mPath.lineTo(progressNearX, farnearDistance + yOffSet);
            mPath.lineTo(progressFarX + farOffsetX, yOffSet);
            mPath.close();
            return mPath;
        }
        return null;
    }


    public void setProgress(int progress){
        this.progress = progress;
        invalidate();
    }
}
