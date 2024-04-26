package com.javieranddev.eltiempaapp.compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.javieranddev.eltiempaapp.compose.about.AboutScreen
import com.javieranddev.eltiempaapp.compose.home.HomeScreen
import com.javieranddev.eltiempaapp.compose.tiempo.TiempoScreen
import com.javieranddev.eltiempaapp.compose.stats.StatsScreen
import com.javieranddev.eltiempaapp.compose.weather.DailyWeatherScreen
import com.javieranddev.eltiempaapp.utils.Constants

@Composable
fun TiempoAppNavHost(navController: NavHostController, modifier: Modifier = Modifier){

    NavHost(
        navController = navController,
        startDestination = Graph.Home.route,
        modifier = modifier
    ){

        /*composable(route = AppScreen.HomeScreen.route) {
            HomeScreen(navigateToTiempoScreen = {
                navController.navigate(AppScreen.TiempoScreen.route + "?query=$it")
                navController.setGraph(tiempoNavGraph(navController))
            })
        }*/

        homeNavGraph(navController = navController) /*TODO EL DRAWER DE INICIO NO LOGRO SOLUCIONARLO*/

        statsNavGraph(navController = navController)

        aboutNavGraph(navController = navController)

    }

}

fun NavGraphBuilder.homeNavGraph(navController: NavController){

    navigation(
        startDestination = AppScreen.HomeScreen.route,
        route = Graph.Home.route
    ) {
        composable(route = AppScreen.HomeScreen.route) {
            HomeScreen(navigateToTiempoScreen = {
                navController.navigate(AppScreen.TiempoScreen.route + "?query=$it")
            })
        }
        tiempoNavGraph(navController = navController)
    }
}

fun NavGraphBuilder.tiempoNavGraph(navController: NavController){
    navigation(
        startDestination = AppScreen.TiempoScreen.route + "?query={query}",
        route = Graph.Tiempo.route
    ){

        composable(
            route = AppScreen.TiempoScreen.route + "?query={query}",
            arguments = listOf(navArgument("query") {defaultValue = Constants.EMPTY_QUERY})
        ){
            TiempoScreen(navController = navController)
        }

        composable(
            route = AppScreen.DailyWeatherScreen.route + "/{munCod}/{munName}",
            arguments = listOf(
                navArgument("munCod") {type = NavType.IntType},
                navArgument("munName") {type = NavType.StringType}
            )
        ){
            DailyWeatherScreen(navController = navController)
        }

    }
}

fun NavGraphBuilder.statsNavGraph(navController: NavController){
    navigation(
        startDestination = AppScreen.StatsScreen.route,
        route = Graph.Stats.route
    ){
        composable(route = AppScreen.StatsScreen.route){
            StatsScreen()
        }
    }
}

fun NavGraphBuilder.aboutNavGraph(navController: NavController){
    navigation(
        startDestination = AppScreen.AboutScreen.route,
        route = Graph.About.route
    ) {
        composable(route = AppScreen.AboutScreen.route){
            AboutScreen()
        }
    }

}