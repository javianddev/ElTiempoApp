package com.javieranddev.eltiempaapp.local.di

import android.content.Context
import com.javieranddev.eltiempaapp.local.AppDatabase
import com.javieranddev.eltiempaapp.local.dao.CADao
import com.javieranddev.eltiempaapp.local.dao.MunicipalityDao
import com.javieranddev.eltiempaapp.local.dao.ProvinceDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)
    }

    @Provides
    fun provideCADao(appDatabase: AppDatabase): CADao{
        return appDatabase.caDao()
    }

    @Provides
    fun provideProvinceDao(appDatabase: AppDatabase): ProvinceDao {
        return appDatabase.provinceDao()
    }

    @Provides
    fun provideMunicipalityDao(appDatabase: AppDatabase): MunicipalityDao {
        return appDatabase.municipalityDao()
    }

}