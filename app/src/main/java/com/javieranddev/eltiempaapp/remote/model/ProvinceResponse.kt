package com.javieranddev.eltiempaapp.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProvinceResponse(

    val breadcrumb: List<Breadcrumb>,

    val keywords: String,

    @SerialName(value = "metadescripcion")
    val metaDescription: String,

    val origen: Origen,

    @SerialName(value = "provincias")
    val provincias: List<Province>,

    val title: String
)