package com.javieranddev.eltiempaapp.remote.service

import com.javieranddev.eltiempaapp.remote.model.ApiResponse
import com.javieranddev.eltiempaapp.remote.model.dailyweather.DailyWeather
import com.javieranddev.eltiempaapp.utils.Constants
import okhttp3.CacheControl
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiTiempoService {

     //DailyWeather
     @GET("prediccion/especifica/municipio/diaria/{municipio}")
     suspend fun getDailyDataMunCod(@Path("municipio") munCod: Int, @Header("cache-control") cacheControl: String, @Query("api_key") apiKey: String): ApiResponse
     //Debido a que la URL es dinámica, usamos la anotación @Url. TODAS las llamadas de AEMET necesitan una segunda llamada para que nos devuelvan los datos.
     @GET
     suspend fun getDailyWeatherData(@Url url:String): DailyWeather



}