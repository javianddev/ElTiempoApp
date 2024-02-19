package com.javieranddev.eltiempaapp.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Province(

    @SerialName(value = "CAPITAL_PROVINCIA")
    val proCapital: String,

    @SerialName(value = "CODAUTON")
    val codAuton: String,

    @SerialName(value = "CODPROV")
    val codProv: String,

    @SerialName(value = "COMUNIDAD_CIUDAD_AUTONOMA")
    val comCitAut: String,

    @SerialName(value = "NOMBRE_PROVINCIA")
    val proName: String
)