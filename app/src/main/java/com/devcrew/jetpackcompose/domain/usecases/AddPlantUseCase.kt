package com.devcrew.jetpackcompose.domain.usecases

import com.devcrew.jetpackcompose.domain.entity.Plant
import com.devcrew.jetpackcompose.domain.repo.PlantRepo
import javax.inject.Inject

class AddPlantUseCase @Inject constructor(
    private val plantRepo: PlantRepo
) {
    suspend fun addPlant(plant: Plant): Long = plantRepo.addPlant(plant)
}