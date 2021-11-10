package com.devcrew.jetpackcompose.presentation.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.devcrew.jetpackcompose.domain.entity.Plant
import com.devcrew.jetpackcompose.presentation.ui.home.HomeDetailScreen
import com.devcrew.jetpackcompose.presentation.ui.home.HomeScreen
import com.devcrew.jetpackcompose.presentation.ui.myplant.LocalScreen
import com.google.gson.Gson

@ExperimentalComposeUiApi
@ExperimentalCoilApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {

        composable(NavigationItem.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(NavigationItem.Local.route) {
            LocalScreen()
        }

        composable(NavigationItem.HomeDetailScreen.route + "/{plant}",
            arguments = listOf(
                navArgument("plant") {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) { entry ->
            entry.arguments?.getString("plant")?.let { json ->
                val plant = Gson().fromJson(json, Plant::class.java)
                HomeDetailScreen(plant = plant)
            }
        }
    }
}