package com.example.net

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitFactory  {
    private lateinit var retrofit: Retrofit

    init {
        initRetrofit()
    }

    private fun initRetrofit() {
        retrofit = Retrofit.Builder()
            .baseUrl("http://api.zydeveloper.com:8086/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(createOkHttpClient())
            .build()
    }

    private fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
            .addInterceptor(createRequestHeaderInterceptor())
            .addNetworkInterceptor(createLogInterceptor())
            .build()
    }

    private fun createRequestHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()
            val build = request.newBuilder()
                .addHeader("Authorization", "")
                .build()
            chain.proceed(build)
        }
    }

    private fun createLogInterceptor(): Interceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    fun <T> create(service: Class<T>?): T {
        return retrofit!!.create(service)
    }


}