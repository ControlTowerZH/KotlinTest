package com.haohao.kotlintest.java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.haohao.kotlintest.R;
import com.haohao.kotlintest.databinding.ActivityBindingBinding;
import com.haohao.kotlintest.util.liveDataBus.LiveDataBus;

public class BindingActivity extends AppCompatActivity {

    private ActivityBindingBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewBinding = ActivityBindingBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        viewBinding.textView.setText("这是viewBinding");
        viewBinding.tvTextDiao.setText("朝辞白帝彩云间");

        viewBinding.btnLiveDataSend.setOnClickListener(v -> {
            String text = viewBinding.etInput.getHint().toString();
            if (!viewBinding.etInput.getText().toString().isEmpty())text = viewBinding.etInput.getText().toString();
            LiveDataBus.get().with("key_test").postValue(text);
        });

        LiveDataBus.get().with("key_test").observe(this, new Observer<Object>() {
            @Override
            public void onChanged(Object s) {
                viewBinding.btnLiveDataReceive.setText("LiveData:"+(String)s);
            }
        });
    }
}
