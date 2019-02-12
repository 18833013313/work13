package bw.com.work13.okhttpWork;

import android.os.Handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import bw.com.work13.callback.OkhttpCallBack;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Okhttp {
    private static Okhttp instanct;
    private final OkHttpClient okHttpClient;
    Handler handler = new Handler();
    public Okhttp() {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .build();


    }

    public static Okhttp getInstanct() {
        if (instanct == null){
            synchronized (Okhttp.class){
                if (instanct == null){
                    instanct = new Okhttp();
                }
            }
        }
        return instanct;
    }
    public void doGet(String api, HashMap<String,String> params, final OkhttpCallBack okhttpCallBack){
        Request request = new Request.Builder()
                .url(api)
                .get()
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (okhttpCallBack!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            okhttpCallBack.onFile("请求失败");
                        }
                    });
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();

            }
        });
    }
}
