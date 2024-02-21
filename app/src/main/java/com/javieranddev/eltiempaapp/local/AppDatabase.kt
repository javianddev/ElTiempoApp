package com.javieranddev.eltiempaapp.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.javieranddev.eltiempaapp.local.dao.CADao
import com.javieranddev.eltiempaapp.local.dao.MunicipalityDao
import com.javieranddev.eltiempaapp.local.dao.ProvinceDao
import com.javieranddev.eltiempaapp.local.model.CA
import com.javieranddev.eltiempaapp.local.model.Municipality
import com.javieranddev.eltiempaapp.local.model.Province

@Database(entities = [CA::class, Province::class, Municipality::class], version = 2, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun caDao(): CADao
    abstract fun provinceDao(): ProvinceDao
    abstract fun municipalityDao(): MunicipalityDao
    companion object {

        @Volatile
        var Instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "eltiempo"
                )
                    .createFromAsset("database/eltiempo.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also{Instance = it}
            }
        }
    }

}