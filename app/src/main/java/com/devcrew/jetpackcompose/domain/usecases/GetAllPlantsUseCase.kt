package com.devcrew.jetpackcompose.domain.usecases

import com.devcrew.jetpackcompose.domain.repo.PlantRepo
import javax.inject.Inject

class GetAllPlantsUseCase @Inject constructor(
    private val plantRepo: PlantRepo
) {
    suspend fun getAllPlants() = plantRepo.getAllPlants()
}