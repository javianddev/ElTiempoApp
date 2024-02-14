package com.javieranddev.eltiempaapp.compose.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Copyright
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.javieranddev.eltiempaapp.compose.navigation.AppScreen
import com.javieranddev.eltiempaapp.compose.navigation.AppScreenItems
import com.javieranddev.eltiempaapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawerMenu(scope:CoroutineScope, scaffoldState: ScaffoldState, navController: NavHostController){

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(R.drawable.app_bar),
            contentDescription = stringResource(R.string.official_logo),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = dimensionResource(id = R.dimen.padding_small))
        )

        AppScreenItems.routes.forEach {
            DrawerMenuItem(it, scope, scaffoldState) {
                navController.navigate(it.route) {
                    launchSingleTop = true //no crea múltiples instancias de la misma pantalla
                    restoreState = true //recompone la pantalla por si ha habido algún cambio
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        TiempoAppInfo()
    }
}

@Composable
fun DrawerMenuItem(screen: AppScreen, scope: CoroutineScope, scaffoldState: ScaffoldState, onItemClick: () -> Unit) {

    Box(
        modifier = Modifier.clickable {
            onItemClick()
            scope.launch {
                scaffoldState.drawerState.close()
            }
        }
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_large))
        ) {
            Icon(
                imageVector = screen.icon,
                contentDescription = stringResource(id = screen.text),
                tint = MaterialTheme.colorScheme.tertiary
            )
            Text(
                text = stringResource(id = screen.text),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_small))
            )
        }
    }

}

@Composable
fun TiempoAppInfo(){

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_small))
            .fillMaxWidth()
    ){
        Icon(
            imageVector = Icons.Filled.Copyright,
            contentDescription = stringResource(id = R.string.copyright),
            tint = MaterialTheme.colorScheme.tertiary
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = R.dimen.padding_small))
        ){
            Text(
                text = stringResource(id = R.string.devName),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.tertiary
            )
            Text(
                text = stringResource(id = R.string.devNick),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.tertiary
            )
        }

    }

}

@Preview
@Composable
fun DrawerMenuPreview(){
    DrawerMenu(scope = rememberCoroutineScope(), scaffoldState = rememberScaffoldState(), navController = rememberNavController())
}

@Preview
@Composable
fun DrawerMenuItemPreview(){
    DrawerMenuItem(screen = AppScreen.HomeScreen, scope = rememberCoroutineScope(), scaffoldState = rememberScaffoldState()) {}
}