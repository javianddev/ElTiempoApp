package com.javieranddev.eltiempaapp.compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.javieranddev.eltiempaapp.compose.about.AboutScreen
import com.javieranddev.eltiempaapp.compose.home.HomeScreen
import com.javieranddev.eltiempaapp.compose.stats.StatsScreen

@Composable
fun TiempoAppNavHost(navController: NavHostController, modifier: Modifier = Modifier){

    NavHost(
        navController = navController,
        startDestination = AppScreen.HomeScreen.route,
        route = Graph.Home.route,
        modifier = modifier
    ){

        composable(route = AppScreen.HomeScreen.route){
            HomeScreen()
        }

        statsNavGraph(navController = navController)

        aboutNavGraph(navController = navController)

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