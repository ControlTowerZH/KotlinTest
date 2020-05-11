package com.haohao.kotlintest.java;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.haohao.kotlintest.R;
import com.haohao.kotlintest.databinding.ActivityBindingBinding;

public class BindingActivity extends AppCompatActivity {

    private ActivityBindingBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewBinding = ActivityBindingBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        viewBinding.textView.setText("这是viewBinding");
        viewBinding.tvTextDiao.setText("重新命名了控件");
    }
}
