package com.haohao.kotlintest.data.model;

import javax.inject.Inject;

import timber.log.Timber;

public class DragTest {
    private static final String TAG = "DragTest";

    @Inject
    public DragTest(){
        Timber.d(TAG,"hello");
    }


    public void setString(String str){

    }
}
