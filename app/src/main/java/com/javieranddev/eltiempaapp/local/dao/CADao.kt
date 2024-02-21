package com.javieranddev.eltiempaapp.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.javieranddev.eltiempaapp.local.model.CA
import kotlinx.coroutines.flow.Flow

@Dao
interface CADao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ca: CA)

    @Update
    suspend fun update(ca:CA)

    @Delete
    suspend fun delete(ca:CA)

    @Query("SELECT * FROM CA ORDER BY id_ca ASC")
    fun getAllCAs(): Flow<List<CA>>

    @Query("SELECT * FROM CA WHERE id_ca = :idCA")
    fun getCAByCaId(idCA: String): Flow<CA>

    @Query("SELECT * FROM CA WHERE name = :name")
    fun getCAByName(name: String): Flow<CA>

    @Query("SELECT * FROM CA WHERE name LIKE '%' || :name ||'%'")
    fun getCALikeName(name: String): Flow<List<CA>>

}