package com.devcrew.jetpackcompose.presentation.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.devcrew.jetpackcompose.domain.entity.Plant
import com.devcrew.jetpackcompose.domain.usecases.GetAllPlantsUseCase
import com.devcrew.jetpackcompose.presentation.base.BaseViewModel
import com.devcrew.jetpackcompose.presentation.utils.RequestState
import com.devcrew.jetpackcompose.presentation.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllPlantsUseCase: GetAllPlantsUseCase
) : BaseViewModel() {

    var plantsList: List<Plant> by mutableStateOf(listOf())

    private val _responseMessage = SingleLiveEvent<String>()
    val responseMessage: SingleLiveEvent<String> = _responseMessage

    init {
        getAllPlants()
    }

    private fun getAllPlants() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.postValue(RequestState.LOADING)
            try {
                val response = getAllPlantsUseCase.getAllPlants()
                if (response.isSuccessful) {
                    response.body()?.let {
                        plantsList = it
                        _responseMessage.postValue("Success")
                    }
                } else {
                    _responseMessage.postValue(response.errorBody()?.string() ?: "")
                }
                _state.postValue(RequestState.DONE)
            } catch (e: Exception) {
                e.printStackTrace()
                _responseMessage.postValue(e.message)
                _state.postValue(RequestState.ERROR)
            } catch (t: Throwable) {
                t.printStackTrace()
                _responseMessage.postValue(t.message)
                _state.postValue(RequestState.ERROR)
            }
        }
    }

}