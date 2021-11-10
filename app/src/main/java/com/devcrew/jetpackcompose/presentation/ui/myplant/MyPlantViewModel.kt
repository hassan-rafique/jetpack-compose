package com.devcrew.jetpackcompose.presentation.ui.myplant

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.devcrew.jetpackcompose.domain.entity.Plant
import com.devcrew.jetpackcompose.domain.usecases.AddPlantUseCase
import com.devcrew.jetpackcompose.domain.usecases.DeletePlantUseCase
import com.devcrew.jetpackcompose.domain.usecases.GetMyPlantsUseCase
import com.devcrew.jetpackcompose.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPlantViewModel @Inject constructor(
    private val myPlantsUseCase: GetMyPlantsUseCase,
    private val addPlantUseCase: AddPlantUseCase,
    private val deletePlantUseCase: DeletePlantUseCase
) : BaseViewModel() {

    init {
        getPlantsList()
    }

    var plantList: List<Plant> by mutableStateOf(listOf())
    var responseMessage: String by mutableStateOf("")

    fun addPlant(plant: Plant) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = addPlantUseCase.addPlant(plant)
                if (response.toInt() != 0)
                    responseMessage = "Plant Added Successfully"
                else
                    responseMessage = "Error"
            } catch (e: Exception) {
                e.printStackTrace()
                e.message.toString()
            }
        }
    }

    fun deletePlant(plant: Plant) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = deletePlantUseCase.deletePlant(plant)
                if (response.toString() != "0")
                    responseMessage = "Deleted"
                else
                    responseMessage = "Error"
            } catch (e: Exception) {
                e.printStackTrace()
                responseMessage = e.message.toString()
            }
        }
    }

    private fun getPlantsList() {
        viewModelScope.launch {
            myPlantsUseCase.getMyPlants().flowOn(Dispatchers.IO).collect {
                plantList = it
            }
        }
    }
}