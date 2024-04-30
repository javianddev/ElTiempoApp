package com.javieranddev.eltiempaapp.compose.weather

import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.javieranddev.eltiempaapp.R
import com.javieranddev.eltiempaapp.remote.model.dailyweather.DailyWeather
import com.javieranddev.eltiempaapp.remote.model.dailyweather.Dia
import com.javieranddev.eltiempaapp.remote.model.dailyweather.HumedadRelativa
import com.javieranddev.eltiempaapp.remote.model.dailyweather.SensTermica
import com.javieranddev.eltiempaapp.remote.model.dailyweather.Temperatura
import com.javieranddev.eltiempaapp.utils.TiempoComposeUtils
import com.javieranddev.eltiempaapp.viewmodel.DailyWeatherUiState
import com.javieranddev.eltiempaapp.viewmodel.DailyWeatherViewModel
import java.text.SimpleDateFormat
import java.util.Locale

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

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
fun DailyWeatherCard(day: Dia) {

    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    val outputFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())

    val date = inputFormat.parse(day.fecha)
    val formattedDate = outputFormat.format(date)

   /* val painter = AnimatedImageVector.animatedVectorResource(id = TiempoComposeUtils.getWeatherImage(day.estadoCielo[0].descripcion))
    var atEnd by remember { mutableStateOf(false) } Con esto animaría el vector, pero no viene con animación*/

    Card(
        elevation = CardDefaults.cardElevation(dimensionResource(id = R.dimen.card_elevation)),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = dimensionResource(id = R.dimen.padding_small))
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
        ) {
            Text(text = formattedDate, style = MaterialTheme.typography.headlineMedium)
            Row(verticalAlignment = Alignment.CenterVertically){
                Column{
                    Image(
                       //painter = rememberAnimatedVectorPainter(animatedImageVector = painter, atEnd = atEnd), animación, vector no animado
                        painter = painterResource(id = TiempoComposeUtils.getWeatherImage(day.estadoCielo[0].descripcion)),
                        contentDescription = day.estadoCielo[0].descripcion,
                        modifier = Modifier.size(dimensionResource(id = R.dimen.dimen_72))
                    )
                }
                Column{
                    DataDetail("${stringResource(R.string.precipitation_prob)}", "${day.probPrecipitacion[0].value}%", R.drawable.raindrop)
                    DataDetail("${stringResource(R.string.wind)}", "${day.viento[0].velocidad} Km/h", R.drawable.windsock)
                }
                Column{
                    PairDataDetail("${stringResource(R.string.temperature)}", "${day.temperatura.maxima}ºC", "${day.temperatura.minima}ºC", R.drawable.thermometer)
                    PairDataDetail("${stringResource(R.string.humidity)}", "${day.humedadRelativa.maxima}%", "${day.humedadRelativa.minima}%", R.drawable.humidity)
                }
            }
        }
    }
}

@Composable
fun PairDataDetail(text: String, max: String, min: String, painterId: Int){

    Row(verticalAlignment = Alignment.CenterVertically){
        Image(
            painter = painterResource(id = painterId),
            contentDescription = null, //Decoración
            modifier = Modifier.size(dimensionResource(id = R.dimen.dimen_42))
        )
        Column{
            Text(
                text = text,
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = max,
                style = MaterialTheme.typography.labelSmall
            )
            Text(
                text = min,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }

}

@Composable
fun DataDetail(text: String, value: String,painterId: Int){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painterResource(id = painterId),
            contentDescription = null, //Decorativo
            modifier = Modifier.size(dimensionResource(id = R.dimen.dimen_42))
        )
        Column{
            Text(
                text = text,
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = value,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier){
    Box(
        modifier = modifier
            .wrapContentHeight(),
        contentAlignment = Alignment.Center
    ){
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.dimen_100))
                .padding(dimensionResource(id = R.dimen.padding_small))
        )
    }
}

@Composable
fun ErrorScreen(modifier: Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier) {
            Text(stringResource(id = R.string.not_available))
    }
}

@Composable
@Preview("card")
fun WeatherCardPreview(){
    val day: Dia = Dia(emptyList(), emptyList(), "20-04-2024", HumedadRelativa(emptyList(), 10, 10), emptyList(), emptyList(),
        SensTermica(emptyList(), 10, 10), Temperatura(emptyList(), 10, 10), 30, emptyList())
    DailyWeatherCard(day)
}

@Composable
@Preview("datadetail")
fun DataDetailPreview(){
    DataDetail("Prob. Precipitación:", "15%",R.drawable.rain)
}

@Composable
@Preview("datadetail")
fun PairDataDetailPreview(){
    PairDataDetail("Humedad Relativa", "20ºC", "10ºC", R.drawable.thermometer)
}