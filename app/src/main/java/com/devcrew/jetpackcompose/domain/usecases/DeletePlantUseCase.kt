package com.devcrew.jetpackcompose.domain.usecases

import com.devcrew.jetpackcompose.domain.entity.Plant
import com.devcrew.jetpackcompose.domain.repo.PlantRepo
import javax.inject.Inject

class DeletePlantUseCase @Inject constructor(
    private val plantRepo: PlantRepo
) {
    suspend fun deletePlant(plant: Plant) = plantRepo.deletePlant(plant)
}