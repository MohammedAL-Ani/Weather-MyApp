package com.example.weather_app.model.network

import com.example.weather_app.model.respone.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryName

interface WeatherService {

    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("q")cityName:String,
        @Query("appid") cityApi:String,
    ):Response<WeatherResponse>

}