package com.javieranddev.eltiempaapp.remote.model.dailyweather

data class SensTermica(
    val dato: List<Dato>,
    val maxima: Int,
    val minima: Int
)