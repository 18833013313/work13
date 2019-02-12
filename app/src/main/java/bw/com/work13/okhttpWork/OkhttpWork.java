package bw.com.work13.okhttpWork;

import android.os.Handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.xml.transform.Result;

import bw.com.work13.callback.OkhttpCallBack;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkhttpWork {
    private static OkhttpWork intercten;
    Handler handler = new Handler();
    private final OkHttpClient okHttpClient;

    public OkhttpWork() {
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .build();

    }

    public static OkhttpWork getIntercten() {
        if (intercten == null){
            synchronized (OkhttpWork.class){
                if (intercten == null){
                    intercten = new OkhttpWork();
                }
            }
        }
        return intercten;
    }
    public void doGet(String api, HashMap<String,String> params, final OkhttpCallBack callBack){
        StringBuilder s = new StringBuilder();
        for (Map.Entry<String, String> p : params.entrySet()) {
            s.append(p.getKey()).append("=").append(p.getValue());
        }
        Request request = new Request.Builder()
                .url(api+s)
                .get()
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (callBack!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onFile("请求错误");
                        }
                    });
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                    if (callBack!=null){
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                callBack.onSuccess(string);

                            }
                        });
                    }

            }
        });
    }

    public void onBind() {
        if (okHttpClient!=null){
            okHttpClient.dispatcher().cancelAll();
        }
    }

}
