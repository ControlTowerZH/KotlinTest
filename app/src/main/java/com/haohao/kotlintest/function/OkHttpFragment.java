package com.haohao.kotlintest.function;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.haohao.kotlintest.R;
import com.haohao.kotlintest.widget.BaseTitleBar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

import androidx.fragment.app.Fragment;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *  手写网络请求 用okHttp
 */
public class OkHttpFragment extends Fragment {

    private BaseTitleBar baseTitleBar;
    private TextView tvRequest;
    private TextView tvContext;

    public static OkHttpFragment newInstance() {
        return new OkHttpFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ok_http, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        baseTitleBar = view.findViewById(R.id.base_title);
        tvRequest = view.findViewById(R.id.tv_send_request);
        tvContext = view.findViewById(R.id.tv_context);
        baseTitleBar.setTitle("OkHttpFragment");
        tvRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequestWithOkHttp();
                //sendRequestWithHttpURLConnection();
            }
        });
    }

    private void sendRequestWithOkHttp(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client =new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://www.baidu.com")
                            .build();
                    Response response =client.newCall(request).execute();
                    assert response.body() != null;
                    String responseData = response.body().string();
                    showResponse(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void sendRequestWithHttpURLConnection(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL("https://www.baidu.com");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();
                    //输入输出流操作
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line =reader.readLine())!=null){
                        response.append(line);
                    }
                    showResponse(response.toString());
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if (reader!=null){
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection !=null){
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    private void showResponse(String responseData) {
        Objects.requireNonNull(getActivity()).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvContext.setText(responseData);
            }
        });
    }
}
