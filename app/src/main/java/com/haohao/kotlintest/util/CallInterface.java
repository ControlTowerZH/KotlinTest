package com.haohao.kotlintest.util;

import android.content.Context;

/**
 * Description :
 *
 * @author Wanderer
 * @date 2020/9/16
 */
public class CallInterface implements InterfaceA{

    private Context mContext;

    //一个类实现的接口，就持有这个接口对象了
    //把 这个对象给别人操作就可以远程操控接口了



    @Override
    public void setSome(String some) {
        ToastUtils.INSTANCE.showShort(mContext,some);
    }
}
