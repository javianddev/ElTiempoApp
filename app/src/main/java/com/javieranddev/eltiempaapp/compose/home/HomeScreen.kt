package com.javieranddev.eltiempaapp.compose.home

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.javieranddev.eltiempaapp.R
import com.javieranddev.eltiempaapp.utils.SpeechToText
import com.javieranddev.eltiempaapp.viewmodel.HomeViewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navigateToTiempoScreen: (String?) -> Unit, viewModel: HomeViewModel = hiltViewModel()){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ){
        HomeSearchBarButton(navigateToTiempoScreen = navigateToTiempoScreen)
    }
}

@Composable
fun HomeSearchBarButton(navigateToTiempoScreen: (String?) -> Unit){

    val context = LocalContext.current
    val speechToText = rememberLauncherForActivityResult(
        contract = SpeechToText(context),
        onResult = {
            navigateToTiempoScreen(it.toString().replace(Regex("[\\[\\]]"), ""))
        }
    )

    Box(
        modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .clip(CircleShape)
                .background(Color.LightGray)
                .clickable { navigateToTiempoScreen("") }
        ){
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = stringResource(id = R.string.search),
                tint = Color.Black,
                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_small))
            )
            Text(
                text = stringResource(id = R.string.search_city),
                style = MaterialTheme.typography.bodyLarge
            )
            IconButton(onClick = {
                speechToText.launch(Unit)
            }) {
                Icon(
                    imageVector = Icons.Filled.Mic,
                    contentDescription = stringResource(id = R.string.mic),
                    tint = Color.Black
                )
            }
        }
    }
}


@Preview
@Composable
fun HomeSearchBarPreview(){
    HomeSearchBarButton(navigateToTiempoScreen = {})
}
@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(navigateToTiempoScreen = {})
}
