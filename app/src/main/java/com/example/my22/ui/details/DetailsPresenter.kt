package com.example.my22.ui.details

import android.util.Log
import com.example.my22.model.Repository
import com.example.my22.ui.base.BasePresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class DetailsPresenter(val view: IDetailsViews):BasePresenter() {

    fun getCityName(cityName:String){
        customScope.launch {
            Repository
                .getWeatherResult(cityName)
                .flowOn(Dispatchers.IO)
                .catch { throwable->
                    Log.i("SHOW_CITY_PRESENTER","${throwable.message}")
                }.collect(view::onShowCityWeather)
        }
    }
}