package com.example.net;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    private static RetrofitFactory instance = new RetrofitFactory();

    private RetrofitFactory() {
        initRetrofit();
    }

    public static RetrofitFactory getInstance() {
        return instance;
    }

    private Retrofit retrofit;

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://39.100.125.37:8088/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOkHttpClient())
                .build();
    }

    private OkHttpClient createOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(createRequestHeaderInterceptor())
                .addNetworkInterceptor(createLogInterceptor())
                .build();
    }

    private Interceptor createRequestHeaderInterceptor() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = chain.request();
                Request build = request.newBuilder()
                        .addHeader("Authorization", "")
                        .build();
                Response proceed = chain.proceed(build);
                return proceed;
            }
        };
        return interceptor;
    }

    private Interceptor createLogInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    public <T> T create(Class<T> service) {
        return retrofit.create(service);
    }
}
