package com.javieranddev.eltiempaapp.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javieranddev.eltiempaapp.remote.model.dailyweather.DailyWeather
import com.javieranddev.eltiempaapp.remote.repository.TiempoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class DailyWeatherViewModel @Inject constructor(
    private val tiempoRepository: TiempoRepository,
    savedStateHandle: SavedStateHandle = SavedStateHandle()
): ViewModel() {

    var dailyWeatherUiState: DailyWeatherUiState by mutableStateOf(DailyWeatherUiState.Loading)
        private set


    private val munCod = checkNotNull(savedStateHandle.get<Int>("munCod"))
    private val munName = checkNotNull(savedStateHandle.get<String>("munName"))

    init {
        getDailyWeather()
    }

    private fun getDailyWeather(){
        viewModelScope.launch{
            dailyWeatherUiState = DailyWeatherUiState.Loading
            Log.e("informacion", "munCod: $munCod - munName: $munName")
            dailyWeatherUiState = try{
                DailyWeatherUiState.Success(tiempoRepository.getDailyDataMunCod(munCod))
            } catch(e: IOException){
                Log.e("informacion", "${e.message}")
                DailyWeatherUiState.Error
            } catch(e:HttpException){
                Log.e("informacion", "${e.message}")
                DailyWeatherUiState.Error
            } catch(e: Exception){
                Log.e("informacion", "${e.message}")
                DailyWeatherUiState.Error
            }
        }
    }
}

sealed interface DailyWeatherUiState {
    data class Success(val dailyWeather: DailyWeather): DailyWeatherUiState
    data object Error: DailyWeatherUiState
    data object Loading: DailyWeatherUiState
}