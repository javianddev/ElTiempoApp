package com.javieranddev.eltiempaapp.compose.tiempo

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.javieranddev.eltiempaapp.R
import com.javieranddev.eltiempaapp.local.model.SearchText
import com.javieranddev.eltiempaapp.utils.SpeechToText
import com.javieranddev.eltiempaapp.viewmodel.TiempoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TiempoScreen(navController: NavController, viewModel: TiempoViewModel = hiltViewModel()) {

    val searchBarUiState by viewModel.searchBarState
    val context = LocalContext.current
    val speechToText = rememberLauncherForActivityResult(
        contract = SpeechToText(context),
        onResult = {
            viewModel.changeTextValue(it.toString())
        }
    )

    SearchBar(
        query = searchBarUiState.query,
        onQueryChange = { viewModel.setQuery(it) },
        onSearch = { viewModel.setActive(false) },
        active = searchBarUiState.active,
        onActiveChange = { viewModel.setActive(it) },
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
            IconButton(onClick = {
                speechToText.launch(Unit)
                viewModel.setActive(true)
            }) {
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

        if (searchBarUiState.active && searchBarUiState.query.length >= 3){
            viewModel.getSearchText()
            searchBarUiState.searchTexts.forEach {
                SearchBarText(it)
            }
        }
    }
}

@Composable
fun SearchBarText(searchText: SearchText) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /*TODO EJECUTAR UNA FUNCIÓN QUE CONSULTE EL TIEMPO...MANDAR EL SEARCHTEXT.MUNCOD. HAY QUE QUITAR LAS TILDES Y DEMÁS SIGNOS DEL ESTILO*/ }
    ) {
        Box(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
        ) {
            Image(
                painter = painterResource(id = R.drawable.la_rioja),
                contentDescription = null, //Decoración
                modifier = Modifier.size(dimensionResource(id = R.dimen.dimen_24))
            )
            /*TODO CAMBIAR EL ICON POR UNA BANDERA DINÁMICA DE LA COMUNIDAD AUTÓNOMA*/
            Text(
                text = "${searchText.munName}, ${searchText.provinceName}, ${searchText.CAName}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_extralarge))
            )
        }
    }
}
