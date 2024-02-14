package com.javieranddev.eltiempaapp.compose.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.javieranddev.eltiempaapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopTiempoAppBar(scrollBehavior: TopAppBarScrollBehavior, navController: NavHostController, onMenuOpen:() -> Unit){
    CenterAlignedTopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.app_bar),
                contentDescription = stringResource(id = R.string.app_icon),
                modifier = Modifier.size(dimensionResource(id = R.dimen.dimen_100))
            )
        },
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
        navigationIcon = {
            IconButton(
                onClick = { onMenuOpen() }
            ){
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = stringResource(id = R.string.menu_icon),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TopTiempoAppBarPreview(){
    TopTiempoAppBar(scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(), navController = rememberNavController()) {}
}