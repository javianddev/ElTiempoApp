package com.javieranddev.eltiempaapp.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TiempoViewModel @Inject constructor(): ViewModel(){

    private val _searchBarState = mutableStateOf(SearchBarUiState())
    val searchBarState: MutableState<SearchBarUiState> = _searchBarState

    fun setQuery(query: String){
        _searchBarState.value = _searchBarState.value.copy(query = query.lowercase())
    }

    fun setActive(active: Boolean){
        _searchBarState.value = _searchBarState.value.copy(active = active)
    }
}


data class SearchBarUiState(
    val active: Boolean = false,
    val query: String = "",
)