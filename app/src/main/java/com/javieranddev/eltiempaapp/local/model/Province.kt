package com.javieranddev.eltiempaapp.local.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PROVINCE")
data class Province(

    @PrimaryKey
    val id: Int,

    @NonNull
    @ColumnInfo("id_province")
    val idProvince: String,

    @NonNull
    @ColumnInfo("name")
    val name: String,

    @NonNull
    @ColumnInfo("ca_id")
    val CAId: String
)
