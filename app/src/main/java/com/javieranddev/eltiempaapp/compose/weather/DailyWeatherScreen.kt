package com.javieranddev.eltiempaapp.compose.weather

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.javieranddev.eltiempaapp.R
import com.javieranddev.eltiempaapp.remote.model.dailyweather.DailyWeather
import com.javieranddev.eltiempaapp.remote.model.dailyweather.Dia
import com.javieranddev.eltiempaapp.viewmodel.DailyWeatherUiState
import com.javieranddev.eltiempaapp.viewmodel.DailyWeatherViewModel

@Composable
fun DailyWeatherScreen(viewModel: DailyWeatherViewModel = hiltViewModel(), navController: NavController, modifier: Modifier = Modifier){

    when (val dailyWeatherUiState = viewModel.dailyWeatherUiState){
        is DailyWeatherUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is DailyWeatherUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
        is DailyWeatherUiState.Success -> DailyWeatherColumn(modifier = modifier.fillMaxWidth(), dailyWeather = dailyWeatherUiState.dailyWeather)
    }
}

@Composable
fun DailyWeatherColumn(dailyWeather: DailyWeather, modifier: Modifier){

     LazyColumn(
         horizontalAlignment = Alignment.CenterHorizontally,
         modifier = modifier
     ){
       items(dailyWeather[0].prediccion.dia, contentType = {it} ){
            DailyWeatherCard(it)
       }
     }

}

@Composable
fun DailyWeatherCard(day: Dia) {

    Card(
        elevation = CardDefaults.cardElevation(dimensionResource(id = R.dimen.card_elevation)),
        modifier = Modifier.fillMaxWidth()
    ){
        Column {
            Text(day.fecha)
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        contentAlignment = Alignment.Center
    ){
        CircularProgressIndicator(
            color = MaterialTheme.colors.primary,
            modifier = Modifier
                .size(width = 42.dp, height = 42.dp)
                .padding(dimensionResource(id = R.dimen.padding_small))
        )
    }
}

@Composable
fun ErrorScreen(modifier: Modifier){

}