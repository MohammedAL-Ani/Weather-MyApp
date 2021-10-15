package com.example.weather_app.model.network

import com.example.weather_app.model.respone.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryName

interface WeatherService {

    @GET("data/2.5/weather?q={city_name}&appid={api_key}")
    suspend fun getWeather(
        @Query("city_name")cityName:String,
        @Query("api_key") cityApi:String,
    ):Response<WeatherResponse>

}