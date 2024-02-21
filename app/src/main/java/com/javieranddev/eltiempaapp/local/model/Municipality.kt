package com.javieranddev.eltiempaapp.local.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MUNICIPALITY")
data class Municipality(

    @PrimaryKey
    val id: Int,

    @NonNull
    @ColumnInfo("province_id")
    val provinceId: String,

    @NonNull
    @ColumnInfo("id_mun")
    val idMun: String,

    @NonNull
    @ColumnInfo("dc")
    val dc: Int,

    @NonNull
    @ColumnInfo("name")
    val name: String
)
