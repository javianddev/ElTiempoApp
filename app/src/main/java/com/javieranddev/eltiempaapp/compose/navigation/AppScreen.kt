package com.javieranddev.eltiempaapp.compose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.WbCloudy
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.ui.graphics.vector.ImageVector
import com.javieranddev.eltiempaapp.R

sealed class AppScreen(
    val route: String,
    val icon: ImageVector,
    val text: Int
){
    data object HomeScreen: AppScreen("home", Icons.Filled.Home, R.string.home)

    data object StatsScreen: AppScreen("stats", Icons.Filled.BarChart, R.string.stats)

    data object AboutScreen: AppScreen("about", Icons.Filled.Info, R.string.about)

    data object TiempoScreen: AppScreen("tiempo", Icons.Filled.WbSunny, R.string.tiempo)

    data object DailyWeatherScreen: AppScreen("daily_weather", Icons.Filled.WbCloudy, R.string.tiempo)
}

object AppScreenItems{
    val routes = listOf(AppScreen.HomeScreen, AppScreen.StatsScreen, AppScreen.AboutScreen)
}

