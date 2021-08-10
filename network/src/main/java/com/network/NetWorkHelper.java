package com.network;

import android.util.Log;

import java.net.HttpURLConnection;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetWorkHelper {
    private static final String TAG="NetWorkHelper";
    private static final String base_header="https://ttt.ebanktest.com.cn:19703";

    private static NetWorkHelper retrofitUtils;
    private static Retrofit retrofit;
    private static INetWork netWork;

    public NetWorkHelper() {

    }

    public static void init(INetWork work){
        netWork = work;
    }

    public static NetWorkHelper getInstance(){

        if(retrofitUtils == null){
            synchronized (NetWorkHelper.class){
                if(retrofitUtils == null){
                    retrofitUtils = new NetWorkHelper();
                }
            }
        }
        return retrofitUtils;
    }

    public static synchronized Retrofit getRetrofit(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d(TAG,"\uD83D\uDC1E--------"+message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        MyInterceptor myInterceptor=new MyInterceptor(netWork);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if(netWork.isDebug()){
            builder.addInterceptor(httpLoggingInterceptor);
        }
        builder.addInterceptor(myInterceptor);
        builder.connectTimeout(5000, TimeUnit.SECONDS);
        OkHttpClient client=builder.build();

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_header)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

        }
        return retrofit;

    }

    public <T> T getApiService(Class<T> cl){
        Retrofit retrofit = getRetrofit();
        return retrofit.create(cl);
    }

}
