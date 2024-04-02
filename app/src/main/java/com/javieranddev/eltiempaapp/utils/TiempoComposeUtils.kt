package com.javieranddev.eltiempaapp.utils

import com.javieranddev.eltiempaapp.R

object TiempoComposeUtils {

    fun getFlag(caName: String): Int {
        return when(caName){
            "Andalucía" -> R.drawable.andalucia
            "Aragón" -> R.drawable.aragon
            "Principado de Asturias" -> R.drawable.asturias
            "Islas Baleares" -> R.drawable.islas_baleares
            "Canarias" -> R.drawable.canarias
            "Cantabria" -> R.drawable.cantabria
            "Castilla y León" -> R.drawable.castilla_y_leon
            "Castilla La Mancha" -> R.drawable.castilla_la_mancha
            "Cataluña" -> R.drawable.catalunha
            "Comunidad Valenciana" -> R.drawable.valencia
            "Extremadura" -> R.drawable.extremadura
            "Galicia" -> R.drawable.galicia
            "Comunidad de Madrid" -> R.drawable.madrid
            "Región de Murcia" -> R.drawable.murcia
            "Comunidad Foral de Navarra" -> R.drawable.navarra
            "País Vasco" -> R.drawable.pais_vasco
            "La Rioja" -> R.drawable.la_rioja
            "Ceuta" -> R.drawable.ceuta
            "Melilla" -> R.drawable.melilla
            else -> {
                R.drawable.andalucia}
        }
    }

}