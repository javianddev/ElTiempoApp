package com.javieranddev.eltiempaapp.local.repository

import com.javieranddev.eltiempaapp.local.dao.MunicipalityDao
import com.javieranddev.eltiempaapp.local.model.Municipality
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MunicipalityRepository @Inject constructor(private val municipalityDao: MunicipalityDao){

    suspend fun insert(municipality: Municipality) = municipalityDao.insert(municipality)
    suspend fun update(municipality: Municipality) = municipalityDao.update(municipality)
    suspend fun delete(municipality: Municipality) = municipalityDao.delete(municipality)


    fun getAllMunicipalities() = municipalityDao.getAllMunicipalities()
    fun getMunicipalityByIdMun(idMun: String) = municipalityDao.getMunicipalityByIdMun(idMun)
    fun getMunicipalityByProvinceId(provinceId: String) = municipalityDao.getMunicipalityByProvinceId(provinceId)
    fun getMunicipalityByName(name: String) = municipalityDao.getMunicipalityByName(name)
    fun getMunicipalityLikeName(name: String) = municipalityDao.getMunicipalityLikeName(name)
    fun getSearchText(munName: String) = municipalityDao.getSearchText(munName)
}