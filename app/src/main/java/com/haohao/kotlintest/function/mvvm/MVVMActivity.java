package com.haohao.kotlintest.function.mvvm;

import android.os.Bundle;
import android.os.Message;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.haohao.kotlintest.R;
import com.haohao.kotlintest.databinding.ActivityMVVMBinding;

import timber.log.Timber;

public class MVVMActivity extends AppCompatActivity {

    private ActivityMVVMBinding binding;
    private MVVMViewModel mvvmViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_m_v_v_m);

        //Activity 中持有ViewModel 的引用；ViewModel 中不持有Activity 的引用
        mvvmViewModel = new MVVMViewModel(getApplication(),binding);
        binding.setViewModel(mvvmViewModel);
        //获取数据呢？
        //Mvvm 将Activity 解放出来，不用再根据数据修改视图

        MutableLiveData<String> nameEvent = mvvmViewModel.getNameEvent();
        nameEvent.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Timber.d("liveData监听"+s);
            }
        });

        Message message = new Message();
        message = Message.obtain();
    }
}
