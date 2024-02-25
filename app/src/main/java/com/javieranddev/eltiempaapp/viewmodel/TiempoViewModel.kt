package com.javieranddev.eltiempaapp.viewmodel

import android.database.sqlite.SQLiteException
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javieranddev.eltiempaapp.local.model.SearchText
import com.javieranddev.eltiempaapp.local.repository.MunicipalityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TiempoViewModel @Inject constructor(
    private val municipalityRepository: MunicipalityRepository,
    savedStateHandle: SavedStateHandle = SavedStateHandle()
): ViewModel(){

    private val _searchBarState = mutableStateOf(SearchBarUiState())
    val searchBarState: MutableState<SearchBarUiState> = _searchBarState

    private val homeQuery = checkNotNull(savedStateHandle.get<String>("query"))

    init{
        _searchBarState.value = _searchBarState.value.copy(query = homeQuery)
    }

    fun setQuery(query: String){
        _searchBarState.value = _searchBarState.value.copy(query = query)
    }

    fun setActive(active: Boolean){
        _searchBarState.value = _searchBarState.value.copy(active = active)
    }

    fun changeTextValue(query: String){
        _searchBarState.value = _searchBarState.value.copy(query = query.replace(Regex("[\\[\\]]"), ""))
    }

    fun getSearchText(){
        viewModelScope.launch{
            try{
                val searchTexts: List<SearchText> = municipalityRepository.getSearchText(_searchBarState.value.query).first()
                _searchBarState.value = _searchBarState.value.copy(searchTexts = searchTexts)
            } catch(e: SQLiteException){
                Log.e("ERROR", "Error getting SearchText - ${e.message}")
            } catch (e: NoSuchElementException){
                Log.e("ERROR", "NoSuchElementException - ${e.message}")
            }
        }
    }


}


data class SearchBarUiState(
    val active: Boolean = false,
    val query: String = "",
    val searchTexts: List<SearchText> = emptyList()
)