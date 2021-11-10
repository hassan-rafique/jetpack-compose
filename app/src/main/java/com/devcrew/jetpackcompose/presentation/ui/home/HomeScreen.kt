package com.devcrew.jetpackcompose.presentation.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.devcrew.jetpackcompose.presentation.ui.view.PlantItem
import com.devcrew.jetpackcompose.presentation.utils.toast

@ExperimentalCoilApi
@Composable
fun HomeScreen(navController: NavController) {
    val mViewModel: HomeViewModel = hiltViewModel()
    val plantsList = mViewModel.plantsList
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(plantsList) { plant ->
            PlantItem(plant = plant, navController)
        }
    }
}

@ExperimentalCoilApi
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}