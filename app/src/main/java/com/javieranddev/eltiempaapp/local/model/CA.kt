package com.javieranddev.eltiempaapp.local.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CA")
data class CA(

    @PrimaryKey
    val id: Int,

    @NonNull
    @ColumnInfo("id_ca")
    val idCA: String,

    @NonNull
    @ColumnInfo("name")
    val name: String
)
