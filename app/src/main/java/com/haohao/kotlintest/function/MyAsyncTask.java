package com.haohao.kotlintest.function;

import android.os.AsyncTask;

/**
 * Description :
 *
 * @author Hao Zhao
 * @date 2020/6/26
 */
public class MyAsyncTask extends AsyncTask<Void,Integer,Boolean> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //在执行开始时调用
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        //进行耗时操作的
        publishProgress(1000);//通知进行UI操作
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        //进行UI操作
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        //执行结束时，调用 可进行UI操作
    }
}
