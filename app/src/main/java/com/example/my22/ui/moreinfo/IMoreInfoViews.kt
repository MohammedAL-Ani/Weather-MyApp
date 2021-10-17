package com.example.my22.ui.moreinfo

import com.example.weather_app.model.respone.WeatherResponse
import com.example.weather_app.util.Status

interface IMoreInfoViews {
    fun onShowMoreInfo(case: Status<WeatherResponse?>)
}