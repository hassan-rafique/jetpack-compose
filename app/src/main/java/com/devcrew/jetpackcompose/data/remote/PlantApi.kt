package com.devcrew.jetpackcompose.data.remote

import com.devcrew.jetpackcompose.domain.entity.Plant
import retrofit2.Response
import retrofit2.http.GET

interface PlantApi {

    @GET("plants.json")
    suspend fun getAllPlants(): Response<List<Plant>>
}