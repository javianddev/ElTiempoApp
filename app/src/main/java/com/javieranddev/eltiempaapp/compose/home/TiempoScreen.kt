package com.javieranddev.eltiempaapp.compose.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.javieranddev.eltiempaapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TiempoScreen(navController: NavController) {

    var name by remember { mutableStateOf("") }

    SearchBar(
        query = name,
        onQueryChange = { name = it },
        onSearch = {  }, /*TODO VA A FUNCIONAR IGUAL QUE LA PLAYSTORE.*/
        active = true,
        onActiveChange = {  },
        placeholder = { stringResource(id = R.string.search_city) },
        leadingIcon = {
            IconButton(onClick = { navController.navigateUp() }) { /*REVISAR*/
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.back),
                    tint = Color.Black
                )
            }
        },
        trailingIcon = {
            IconButton(onClick = { /*TODO RECONOCIMIENTO DE VOZ*/ }) {
                Icon(
                    imageVector = Icons.Filled.Mic,
                    contentDescription = stringResource(id = R.string.mic),
                    tint = Color.Black
                )
            }
        },
        colors = SearchBarDefaults.colors(containerColor = Color.White),
        modifier = Modifier
    ) {
        /*TODO AQUÍ YA MOSTRARÍA EL TIEMPO*/
    }
}
