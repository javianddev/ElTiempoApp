package com.javieranddev.eltiempaapp.remote.service

import com.javieranddev.eltiempaapp.remote.model.ProvinceResponse
import com.javieranddev.eltiempaapp.utils.Constants
import retrofit2.http.GET

interface ApiTiempoService {

    @GET(Constants.GET_PROVINCES)
    suspend fun getProvinces(): ProvinceResponse


}