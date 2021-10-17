package com.example.my22.ui.moreinfo

import android.util.Log
import com.example.my22.model.Repository
import com.example.my22.ui.base.BasePresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class MoreInfoPresenter(val view:IMoreInfoViews) : BasePresenter() {

    fun getInfoAboutCity(moreInfo:String){
        customScope.launch {
            Repository
                .getWeatherResult(moreInfo)
                .flowOn(Dispatchers.IO)
                .catch { throwable->
                    Log.i("MOR_CITY_PRESENTER","${throwable.message}")
                }.collect(view::onShowMoreInfo)
        }
    }
}