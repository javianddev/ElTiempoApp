package com.javieranddev.eltiempaapp.remote.model.dailyweather

data class DailyWeatherItem(
    val elaborado: String,
    val id: Int,
    val nombre: String,
    val origen: Origen,
    val prediccion: Prediccion,
    val provincia: String,
    val version: Double
)