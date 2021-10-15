package com.example.my22.ui.home

import com.example.weather_app.model.respone.WeatherResponse
import com.example.weather_app.util.Status

interface IHomeViews {
    fun onShowCityWeather(case: Status<WeatherResponse?>)
}