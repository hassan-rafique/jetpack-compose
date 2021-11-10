package com.devcrew.jetpackcompose.domain.usecases

import com.devcrew.jetpackcompose.domain.repo.PlantRepo
import javax.inject.Inject

class GetMyPlantsUseCase @Inject constructor(
    private val plantRepo: PlantRepo
) {
    fun getMyPlants() = plantRepo.getMyPlants()
}