package com.yumtaufikhidayat.gitser.network

import com.yumtaufikhidayat.gitser.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiConfig {

    private const val timeOutTime = 30L

    private val interceptor = if (BuildConfig.DEBUG) {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    } else {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
    }

    private val builder = OkHttpClient.Builder()
        .connectTimeout(timeOutTime, TimeUnit.SECONDS)
        .writeTimeout(timeOutTime, TimeUnit.SECONDS)
        .readTimeout(timeOutTime, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .addInterceptor { chain ->
            val request = chain.request()
                .newBuilder()
                .addHeader(
                    "GITHUB_PAT",
                    BuildConfig.GITHUB_TOKEN_PAT
                )
                .build()
            return@addInterceptor chain.proceed(request)
        }

    private val client = builder.build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(UrlEndpoint.BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiInstance: ApiService = retrofit.create(ApiService::class.java)
}