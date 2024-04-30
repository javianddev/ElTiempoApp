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

    //Iría mejor por ID, pero la tabla de ayuda de AEMET solo viene con las descripciones y no con IDs, por lo que se simplifica para mí, pero debería de ir por ID.
    fun getWeatherImage(value: String): Int{
        return when(value){
            "Despejado" -> R.drawable.clear_day
            "Despejado noche" -> R.drawable.clear_night
            "Poco nuboso" -> R.drawable.partly_cloudy_day
            "Poco nuboso noche" -> R.drawable.partly_cloudy_night
            "Intervalos nubosos" -> R.drawable.partly_cloudy_day
            "Intervalos nubosos noche" -> R.drawable.partly_cloudy_night
            "Nuboso" -> R.drawable.overcast_day
            "Nuboso noche" -> R.drawable.overcast_night
            "Muy nuboso" -> R.drawable.overcast
            "Cubierto" -> R.drawable.overcast
            "Nubes altas" -> R.drawable.clear_day
            "Nubes altas noche" -> R.drawable.clear_night
            "Intervalos lluviosos con lluvia escasa" -> R.drawable.partly_cloudy_day_drizzle
            "Intervalos lluviosos con lluvia escasa noche" -> R.drawable.partly_cloudy_night_drizzle
            "Nuboso con lluvia escasa" -> R.drawable.partly_cloudy_day_drizzle
            "Nuboso con lluvia escasa noche" -> R.drawable.partly_cloudy_night_drizzle
            "Muy nuboso con lluvia escasa" -> R.drawable.rain
            "Cubierto con lluvia escasa" -> R.drawable.rain
            "Intervalos nubosos con lluvia" -> R.drawable.partly_cloudy_day_rain
            "Intervalos nubosos con lluvia noche" -> R.drawable.partly_cloudy_night_rain
            "Nuboso con lluvia" -> R.drawable.partly_cloudy_day_rain
            "Nuboso con lluvia noche" -> R.drawable.partly_cloudy_night_rain
            "Muy nuboso con lluvia" -> R.drawable.rain
            "Cubierto con lluvia" -> R.drawable.rain
            "Intervalos nubosos con nieve escasa" -> R.drawable.partly_cloudy_day_snow
            "Intervalos nubosos con nieve escasa noche" -> R.drawable.partly_cloudy_night_snow
            "Nuboso con nieve escasa" -> R.drawable.partly_cloudy_day_snow
            "Nuboso con nieve escasa noche" -> R.drawable.partly_cloudy_night_snow
            "Muy nuboso con nieve escasa" -> R.drawable.snow
            "Muy nuboso con nieve escasa noche" -> R.drawable.snow
            "Cubierto con nieve escasa" -> R.drawable.snow
            "Intervalos nubosos con nieve" -> R.drawable.partly_cloudy_day_snow
            "Intervalos nubosos con nieve noche" -> R.drawable.partly_cloudy_night_snow
            "Nuboso con nieve" -> R.drawable.partly_cloudy_day_snow
            "Nuboso con nieve noche" -> R.drawable.partly_cloudy_night_snow
            "Muy nuboso con nieve" -> R.drawable.snow
            "Cubierto con nieve" -> R.drawable.snow
            "Intervalos nubosos con tormenta" -> R.drawable.thunderstorms_day_rain
            "Intervalos nubosos con tormenta noche" -> R.drawable.thunderstorms_night_rain
            "Nuboso con tormenta" -> R.drawable.thunderstorms_day_rain
            "Nuboso con tormenta noche" -> R.drawable.thunderstorms_night_rain
            "Muy nuboso con tormenta" -> R.drawable.thunderstorms_rain
            "Muy nuboso con tormenta" -> R.drawable.thunderstorms_rain
            "Cubierto con tormenta" -> R.drawable.thunderstorms_rain
            "Intervalos nubosos con tormenta y lluvia escasa" -> R.drawable.thunderstorms_day_rain
            "Intervalos nubosos con tormenta y lluvia escasa noche" -> R.drawable.thunderstorms_night_rain
            "Nuboso con tormenta y lluvia escasa" -> R.drawable.thunderstorms_day_rain
            "Nuboso con tormenta y lluvia escasa noche" -> R.drawable.thunderstorms_night_rain
            "Muy nuboso con tormenta y lluvia escasa" -> R.drawable.thunderstorms_rain
            "Cubierto con tormenta y lluvia escasa" -> R.drawable.thunderstorms_rain
            "Niebla" -> R.drawable.mist
            "Bruma" -> R.drawable.mist
            "Calima" -> R.drawable.dust
            else -> {
                R.drawable.partly_cloudy_day
            }
        }
    }
}