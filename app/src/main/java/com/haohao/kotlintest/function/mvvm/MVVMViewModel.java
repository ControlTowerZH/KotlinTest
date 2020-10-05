package com.haohao.kotlintest.function.mvvm;

import android.app.Application;
import android.content.Context;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.MutableLiveData;

import com.haohao.kotlintest.R;
import com.haohao.kotlintest.databinding.ActivityMVVMBinding;

/**
 * Description :第一个ViewModel
 *
 * @author Wanderer
 * @date 2020/9/19
 */
public class MVVMViewModel extends BaseObservable {

    private ActivityMVVMBinding binding;
    private MVVMModel mvvmModel;
    private String input;
    private String result;
    public String result1 = "朝辞白帝彩云间";

    private Context mContext;

    private MutableLiveData<String> mNameEvent = new MutableLiveData<>();

    public MutableLiveData<String> getNameEvent() {
        return mNameEvent;
    }

    //视图 上需要显示的数据，视图直接通过这个方法获取，一定要有注解
    @Bindable
    public String getResult() {
        //mNameEvent.postValue(); 主线程
        //mNameEvent.setValue(); 所在线程
        return result;
    }

    //写入数据的地方,修改视图的时候需要
    private void setResult(String result) {
        this.result = result;
        binding.tvDefault.setBackgroundColor(mContext.getResources().getColor(R.color.colorPrimary));
        binding.tvDefault.setTextColor(mContext.getResources().getColor(R.color.white));
        notifyPropertyChanged(BR.result);
    }
    //应该会需要一些特定的数据
    MVVMViewModel(Application application, ActivityMVVMBinding binding) {
        this.binding = binding;
        mContext = application;
        mvvmModel = new MVVMModel();
    }

    //点击事件方法
    public void getData(View view) {
        input = binding.etAccount.getText().toString();//可以通过双向绑定获取，而不用 getText
        binding.tvDefault.setText(result1);
        mvvmModel.getAccountData(input, new MCallBack() {
            @Override
            public void onSuccess(Account account) {
                String info = account.name + "|" + account.level;
                setResult(info);
            }

            @Override
            public void onFailed() {
                setResult("消息获取失败");
            }
        });
    }
}
