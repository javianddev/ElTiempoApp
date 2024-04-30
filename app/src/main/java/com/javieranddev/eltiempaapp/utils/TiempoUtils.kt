package com.javieranddev.eltiempaapp.utils

import java.text.Normalizer

class TiempoUtils {

    //Elimina los acentos de las palabras menos la ñ
    fun unaccent(query: String): String {
        val temp = Normalizer.normalize(query, Normalizer.Form.NFD)
        return temp.replace("\\p{M}".toRegex(), "").replace("[ñÑ]".toRegex(), "")
    }



}