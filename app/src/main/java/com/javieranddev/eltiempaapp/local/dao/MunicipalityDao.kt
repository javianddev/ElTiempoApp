package com.javieranddev.eltiempaapp.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.javieranddev.eltiempaapp.local.model.Municipality
import com.javieranddev.eltiempaapp.local.model.SearchText
import kotlinx.coroutines.flow.Flow

@Dao
interface MunicipalityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(municipality: Municipality)

    @Update
    suspend fun update(municipality: Municipality)

    @Delete
    suspend fun delete(municipality: Municipality)

    @Query("SELECT * FROM MUNICIPALITY ORDER BY id ASC")
    fun getAllMunicipalities(): Flow<List<Municipality>>

    @Query("SELECT * FROM MUNICIPALITY WHERE id_mun = :idMun")
    fun getMunicipalityByIdMun(idMun: String): Flow<Municipality>

    @Query("SELECT * FROM MUNICIPALITY WHERE province_id = :provinceId")
    fun getMunicipalityByProvinceId(provinceId: String): Flow<List<Municipality>>

    @Query("SELECT * FROM MUNICIPALITY WHERE name = :name")
    fun getMunicipalityByName(name: String): Flow<Municipality>

    @Query("SELECT * FROM MUNICIPALITY WHERE name LIKE '%' || :name || '%' LIMIT 7")
    fun getMunicipalityLikeName(name: String): Flow<List<Municipality>>

    @Query("SELECT CA.name AS CAName, PROVINCE.name AS provinceName, MUNICIPALITY.name AS munName, MUNICIPALITY.province_id || MUNICIPALITY.id_mun AS munCod FROM MUNICIPALITY " +
            "JOIN PROVINCE ON (MUNICIPALITY.province_id = PROVINCE.id_province) " +
            "JOIN CA ON (PROVINCE.ca_id = CA.id_ca)" +
            "WHERE lower(MUNICIPALITY.name_no_diacritics) LIKE '%' || lower(:munName) || '%' LIMIT 7")
    fun getSearchText(munName:String): Flow<List<SearchText>>

}