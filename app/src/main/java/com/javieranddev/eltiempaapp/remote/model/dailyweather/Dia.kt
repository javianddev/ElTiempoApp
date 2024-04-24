package com.javieranddev.eltiempaapp.remote.model.dailyweather

data class Dia(
    val cotaNieveProv: List<CotaNieveProv>,
    val estadoCielo: List<EstadoCielo>,
    val fecha: String,
    val humedadRelativa: HumedadRelativa,
    val probPrecipitacion: List<ProbPrecipitacion>,
    val rachaMax: List<RachaMax>,
    val sensTermica: SensTermica,
    val temperatura: Temperatura,
    val uvMax: Int,
    val viento: List<Viento>
)