package com.devcrew.jetpackcompose.data.repo

import com.devcrew.jetpackcompose.data.local.room.PlantDao
import com.devcrew.jetpackcompose.data.remote.PlantApi
import com.devcrew.jetpackcompose.domain.entity.Plant
import com.devcrew.jetpackcompose.domain.repo.PlantRepo
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class PlantRepoImpl @Inject constructor(
    private val plantApi: PlantApi,
    private val plantDao: PlantDao
) : PlantRepo {

    override suspend fun getAllPlants() = plantApi.getAllPlants()

    override suspend fun addPlant(plant: Plant): Long = plantDao.addPlant(plant)

    override fun getMyPlants(): Flow<List<Plant>> = plantDao.getAllPlants()

    override suspend fun deletePlant(plant: Plant): Int = plantDao.deletePlant(plant)
}