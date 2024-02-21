package com.javieranddev.eltiempaapp.local.repository

import com.javieranddev.eltiempaapp.local.dao.CADao
import com.javieranddev.eltiempaapp.local.model.CA
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CARepository @Inject constructor(private val caDao: CADao ){

    suspend fun insertCA(ca: CA) = caDao.insert(ca)
    suspend fun updateCA(ca: CA) = caDao.update(ca)
    suspend fun deleteCA(ca: CA) = caDao.delete(ca)

    fun getAllCAs() = caDao.getAllCAs()
    fun getCaByCaId(idCa: String) = caDao.getCAByCaId(idCa)
    fun getCaByName(name:String) = caDao.getCAByName(name)
    fun getCaLikeName(name:String) = caDao.getCALikeName(name)
}