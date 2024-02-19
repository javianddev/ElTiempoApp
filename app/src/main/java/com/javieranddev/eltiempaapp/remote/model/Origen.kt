package com.javieranddev.eltiempaapp.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Origen(

    val copyright: String,

    @SerialName(value = "descripcion")
    val description: String,

    val language: String,

    @SerialName(value = "nota_legal")
    val legalNote: String,

    val productor: String,

    val web: String
)