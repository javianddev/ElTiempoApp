package com.javieranddev.eltiempaapp.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.javieranddev.eltiempaapp.local.model.Province
import kotlinx.coroutines.flow.Flow

@Dao
interface ProvinceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(province: Province)

    @Update
    suspend fun update(province: Province)

    @Delete
    suspend fun delete(province: Province)

    @Query("SELECT * FROM PROVINCE ORDER BY id_province ASC")
    fun getAllProvinces(): Flow<List<Province>>

    @Query("SELECT * FROM PROVINCE WHERE id_province = :idProvince")
    fun getProvinceByIdProvince(idProvince: String): Flow<Province>

    @Query("SELECT * FROM PROVINCE WHERE name = :name")
    fun getProvinceByName(name: String): Flow<Province>

    @Query("SELECT * FROM PROVINCE WHERE name LIKE '%' || :name || '%'")
    fun getProvinceLikeName(name: String): Flow<Province>

}