package com.javieranddev.eltiempaapp.remote.repository

import android.util.Log
import com.javieranddev.eltiempaapp.remote.model.dailyweather.DailyWeather
import javax.inject.Inject
import javax.inject.Singleton
import com.javieranddev.eltiempaapp.remote.service.ApiTiempoService
import com.javieranddev.eltiempaapp.utils.Constants

@Singleton
class TiempoRepository @Inject constructor(private val apiTiempoService: ApiTiempoService){

    suspend fun getDailyDataMunCod(munCod: Int): DailyWeather {

        val apiResponse = apiTiempoService.getDailyDataMunCod(munCod, Constants.NO_CACHE, Constants.API_KEY)
        Log.i("repositorio", "$apiResponse")
        return apiTiempoService.getDailyWeatherData(apiResponse.datos)
    }


}