package com.javieranddev.eltiempaapp.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.javieranddev.eltiempaapp.R
import com.javieranddev.eltiempaapp.compose.menu.DrawerMenu
import com.javieranddev.eltiempaapp.compose.menu.TopTiempoAppBar
import com.javieranddev.eltiempaapp.compose.navigation.TiempoAppNavHost
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TiempoApp(navController: NavHostController = rememberNavController()){

    val modifier = Modifier
        .fillMaxWidth()
        .padding(
            horizontal = dimensionResource(id = R.dimen.padding_medium)
        )
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopTiempoAppBar(
                scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
                navController = navController,
                onMenuOpen = {
                    //Abrimos el Drawer
                    scope.launch { //Hay que hacerlo dentro de una corrutina
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerContent = {
            DrawerMenu(scope, scaffoldState, navController)
        }
    ) { innerPadding ->
        TiempoAppNavHost(navController, modifier = modifier.padding(innerPadding))
    }
}


@Preview
@Composable
fun TiempoAppPreview(){
    TiempoApp()
}
