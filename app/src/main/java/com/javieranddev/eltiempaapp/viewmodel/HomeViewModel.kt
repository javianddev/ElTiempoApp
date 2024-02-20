package com.javieranddev.eltiempaapp.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {

    private val _homeUiState = mutableStateOf(HomeUiState())
    val homeUiState: MutableState<HomeUiState> = _homeUiState

    fun changeTextValue(text:String){
        _homeUiState.value = _homeUiState.value.copy(text = text.replace(Regex("[\\[\\]]"), ""))
    }

}

data class HomeUiState(
    val text: String? = null
)
