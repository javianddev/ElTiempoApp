package com.javieranddev.eltiempaapp.remote.model.dailyweather

data class HumedadRelativa(
    val dato: List<Dato>,
    val maxima: Int,
    val minima: Int
)