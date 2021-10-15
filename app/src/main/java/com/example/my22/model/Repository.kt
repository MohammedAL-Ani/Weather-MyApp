package com.example.my22.model

import com.example.weather_app.model.network.API
import com.example.weather_app.model.respone.WeatherResponse
import com.example.weather_app.util.Constant.KEY_API
import com.example.weather_app.util.Status
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

object Repository {

    fun getWeatherResult(cityName: String)
            : Flow<Status<WeatherResponse?>> =
        wrapWithFlow { API.apiService.getWeather(cityName, KEY_API) }


    private fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<Status<T?>>
            = flow {
        emit(Status.Loading)
        emit(checkIsSuccessful(function()))
    }

    private fun <T> checkIsSuccessful(response: Response<T>): Status<T?>
            = try {
        if (response.isSuccessful)  Status.Success(response.body())
        else Status.Error(response.message())
    } catch (e: Exception) {
        Status.Error(e.message.toString())
    }


}