package com.haohao.kotlintest.function;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.haohao.kotlintest.R;
import com.haohao.kotlintest.test1.AnimationActivity;

import static android.os.Process.THREAD_PRIORITY_AUDIO;
import static android.os.Process.THREAD_PRIORITY_BACKGROUND;
import static android.os.Process.THREAD_PRIORITY_DEFAULT;
import static android.os.Process.THREAD_PRIORITY_FOREGROUND;
import static android.os.Process.THREAD_PRIORITY_LESS_FAVORABLE;
import static android.os.Process.THREAD_PRIORITY_LOWEST;
import static android.os.Process.THREAD_PRIORITY_MORE_FAVORABLE;
import static android.os.Process.THREAD_PRIORITY_URGENT_AUDIO;
import static android.os.Process.THREAD_PRIORITY_URGENT_DISPLAY;

/**
 * 测试应用通知通知
 */
public class NotifyActivity extends AppCompatActivity {

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
        mContext=this;

        Button button = findViewById(R.id.btn_notify);
        button.setOnClickListener(v -> setNotification());
    }

    private void setNotification(){
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (manager==null){
            return;
        }

        PendingIntent intent = PendingIntent.getActivity(mContext,0,new Intent(mContext, AnimationActivity.class),0);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String channelId = "channelId";
            String channelName = "默认通知";
            manager.createNotificationChannel(new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH));
        }

        Notification notification = new NotificationCompat.Builder(mContext,"channelId")
                .setContentTitle("Notify Title")
                .setContentText("我有好多好多话要说，我有好多问题想问")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.headline_type_bbc)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_icon))
                //.setStyle(new NotificationCompat.BigTextStyle().bigText("我有好多好多话要说，我有好多问题想问。" +
                //        "我有好多好多话要说，我有好多问题想问。我有好多好多话要说，我有好多问题想问。" +
                //        "我有好多好多话要说，我有好多问题想问。我有好多好多话要说，我有好多问题想问。"))
                //.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.ic_timg)))
                .setLights(Color.GREEN,1000,1000)
                .setVibrate(new long[]{0,1000,1000,1000})
                .setPriority(NotificationCompat.PRIORITY_MAX)//最高等级通知
                .setAutoCancel(true)
                .setContentIntent(intent)
                .build();
        manager.notify(1,notification);
    }

    class MyThread extends Thread{

        @Override
        public void run() {
            super.run();
            android.os.Process.setThreadPriority (THREAD_PRIORITY_DEFAULT);

        }
    }

    MyThread myThread = new MyThread();

    private void setThread(){
        myThread.setPriority(THREAD_PRIORITY_DEFAULT);
        myThread.setPriority(THREAD_PRIORITY_AUDIO);
        myThread.setPriority(THREAD_PRIORITY_BACKGROUND);
        myThread.setPriority(THREAD_PRIORITY_FOREGROUND);
        myThread.setPriority(THREAD_PRIORITY_LESS_FAVORABLE);
        myThread.setPriority(THREAD_PRIORITY_LOWEST);
        myThread.setPriority(THREAD_PRIORITY_MORE_FAVORABLE);
        myThread.setPriority(THREAD_PRIORITY_URGENT_AUDIO);
        myThread.setPriority(THREAD_PRIORITY_URGENT_DISPLAY);
    }
}
