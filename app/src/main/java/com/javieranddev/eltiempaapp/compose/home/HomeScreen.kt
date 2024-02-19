package com.javieranddev.eltiempaapp.compose.home

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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.javieranddev.eltiempaapp.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navigateToTiempoScreen: () -> Unit){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ){
        HomeSearchBarButton(navigateToTiempoScreen)
    }
}

@Composable
fun HomeSearchBarButton(navigateToTiempoScreen:() -> Unit){
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
                .clickable { navigateToTiempoScreen() }
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
            IconButton(onClick = { /*TODO RECONOCIMIENTO DE VOZ. POR COMO ESTÁN PUESTOS LOS CLICKABLES SE PULSA DOS VECES NO SÉ LA RAZÓN*/}) {
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
    HomeSearchBarButton(){}
}
@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(){}
}