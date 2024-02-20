package com.javieranddev.eltiempaapp.compose.tiempo


import androidx.activity.compose.rememberLauncherForActivityResult
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.javieranddev.eltiempaapp.R
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
            IconButton(onClick = { speechToText.launch(Unit) }) {
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
