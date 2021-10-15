package com.example.weather_app.model.network

import com.example.weather_app.util.Constant.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {

    private val clientForInterceptor = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(clientForInterceptor)
        .build()

    val apiService = retrofit.create(WeatherService::class.java)
}