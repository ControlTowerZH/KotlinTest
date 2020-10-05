package com.haohao.kotlintest.function.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import timber.log.Timber;

/**
 * Description :ProcessService
 *
 * @author Wanderer
 * @date 2020/10/1
 */
public class ProcessService extends Service {

    private static final String TAG = "ProcessService";

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.i("onCreate: %s", TAG);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Timber.i("onStartCommand: %s", TAG);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Timber.i("onDestroy:%s", TAG);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        //Toast.makeText(this, "哈哈", Toast.LENGTH_SHORT).show();
        return null;
    }
}
