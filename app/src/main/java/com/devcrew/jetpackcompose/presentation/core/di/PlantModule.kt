package com.devcrew.jetpackcompose.presentation.core.di

import android.content.Context
import com.devcrew.jetpackcompose.data.local.room.AppDatabase
import com.devcrew.jetpackcompose.data.local.room.PlantDao
import com.devcrew.jetpackcompose.data.remote.PlantApi
import com.devcrew.jetpackcompose.data.repo.PlantRepoImpl
import com.devcrew.jetpackcompose.data.utils.BASE_URL
import com.devcrew.jetpackcompose.domain.repo.PlantRepo
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PlantModule {

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun providePlantApi(gson: Gson): PlantApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(PlantApi::class.java)

    @Provides
    @Singleton
    fun providePlantRepo(plantApi: PlantApi, plantDao: PlantDao): PlantRepo {
        return PlantRepoImpl(plantApi, plantDao)
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = AppDatabase.getDataBase(context)

    @Singleton
    @Provides
    fun providePlantDao(db: AppDatabase) = db.plantDao()
}