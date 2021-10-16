package com.example.my22.ui.details
import com.example.weather_app.model.respone.WeatherResponse

import com.example.weather_app.util.Status

interface IDetailsViews {
    fun onShowCityWeather(case: Status<WeatherResponse?>)
}