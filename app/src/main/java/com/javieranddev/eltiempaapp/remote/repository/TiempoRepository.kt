package com.javieranddev.eltiempaapp.remote.repository

import javax.inject.Inject
import javax.inject.Singleton
import com.javieranddev.eltiempaapp.remote.service.ApiTiempoService

@Singleton
class TiempoRepository @Inject constructor(private val apiTiempoService: ApiTiempoService){

    suspend fun getProvinces() = apiTiempoService.getProvinces();
}