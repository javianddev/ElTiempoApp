package com.javieranddev.eltiempaapp.compose.navigation

sealed class Graph(
    val route: String
){
    data object Home: Graph("home_graph")
    data object Stats: Graph("stats_graph")
    data object About: Graph("about_graph")
}
