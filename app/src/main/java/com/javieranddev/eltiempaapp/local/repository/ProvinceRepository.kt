package com.javieranddev.eltiempaapp.local.repository

import com.javieranddev.eltiempaapp.local.dao.ProvinceDao
import com.javieranddev.eltiempaapp.local.model.Province
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProvinceRepository @Inject constructor(private val provinceDao: ProvinceDao){

    suspend fun insert(province: Province) = provinceDao.insert(province)
    suspend fun update(province: Province) = provinceDao.update(province)
    suspend fun delete(province: Province) = provinceDao.delete(province)

    fun getAllProvinces() = provinceDao.getAllProvinces()
    fun getProvinceByIdProvince(idProvince: String)  = provinceDao.getProvinceByIdProvince(idProvince)
    fun getProvinceByName(name: String) = provinceDao.getProvinceByName(name)
    fun getProvinceLikeName(name: String) = provinceDao.getProvinceLikeName(name)

}