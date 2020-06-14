package com.haohao.kotlintest.widget;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haohao.kotlintest.R;
import com.haohao.kotlintest.util.ToastUtils;

/**
 * Description : 这是一个自定义的 标题栏控件 自定义控件，容器
 *
 * @author Hao Zhao
 * @date 2020/6/14
 */
public class BaseTitleBar extends RelativeLayout {

    private int mBackground;
    private String mTitle;
    private int mTitleColor;
    private float mTitleSize;
    private boolean isShowMore;

    private TextView title;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        title.setText(mTitle);;
    }

    public BaseTitleBar(Context context) {
        this(context, null);
    }

    public BaseTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs,0);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.BaseTitleBar);
        mBackground = typedArray.getResourceId(R.styleable.BaseTitleBar_bt_background,R.color.colorPrimary);
        mTitle = typedArray.getString(R.styleable.BaseTitleBar_bt_title);
        mTitleColor = typedArray.getColor(R.styleable.BaseTitleBar_bt_title_color, Color.WHITE);
        mTitleSize = typedArray.getDimension(R.styleable.BaseTitleBar_bt_title_size,18);
        isShowMore = typedArray.getBoolean(R.styleable.BaseTitleBar_bt_show_more,false);
        typedArray.recycle();
    }

    public BaseTitleBar(Context context,AttributeSet attrs,int defStyleAttr){
        super(context,attrs,defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.BaseTitleBar);
        mBackground = typedArray.getResourceId(R.styleable.BaseTitleBar_bt_background,R.color.colorPrimary);
        mTitle = typedArray.getString(R.styleable.BaseTitleBar_bt_title);
        mTitleColor = typedArray.getColor(R.styleable.BaseTitleBar_bt_title_color, Color.WHITE);
        mTitleSize = typedArray.getDimension(R.styleable.BaseTitleBar_bt_title_size,18);
        isShowMore = typedArray.getBoolean(R.styleable.BaseTitleBar_bt_show_more,false);
        typedArray.recycle();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        inflate(getContext(),R.layout.base_title_bar,this);
        initCLick();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void initCLick() {
        ImageView back = findViewById(R.id.iv_back);
        title = findViewById(R.id.tv_title);
        ImageView more = findViewById(R.id.iv_more);
        RelativeLayout rl = findViewById(R.id.rl_contain);

        rl.setBackgroundResource(mBackground);
        if (TextUtils.isEmpty(mTitle)){
            mTitle = ((Activity)getContext()).getLocalClassName();
        }
        title.setText(mTitle);
        title.setTextColor(mTitleColor);
        title.setTextSize(mTitleSize);
        more.setVisibility(isShowMore?VISIBLE:GONE);


        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });

        title.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.INSTANCE.showShort(getContext(),title.getText().toString());
            }
        });

        more.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //HeadlineWaittingDialog.showDialog(getContext());
                showDialog("老刁別点");
            }
        });
    }

    private void showDialog(String message){
        new AlertDialog.Builder(getContext())
                .setTitle("Error")
                .setMessage(message)
                .setNegativeButton("取消",null)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }
}
