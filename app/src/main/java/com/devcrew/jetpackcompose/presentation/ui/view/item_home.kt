package com.devcrew.jetpackcompose.presentation.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.devcrew.jetpackcompose.R
import com.devcrew.jetpackcompose.domain.entity.Plant
import com.devcrew.jetpackcompose.presentation.core.navigation.NavigationItem
import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@ExperimentalCoilApi
@Composable
fun PlantItem(plant: Plant, navController: NavController) {
    Column(
        modifier = Modifier
            .padding(top = 12.dp, start = 12.dp, end = 12.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(10.dp))
            .clickable {
                onClick(plant, navController)
            }
            .background(colorResource(id = R.color.color_md_grey_300)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = rememberImagePainter(plant.image), contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(16.dp)), contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = plant.name,
            color = colorResource(id = R.color.black),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp, bottom = 12.dp)
        )
    }
}

private fun onClick(plant: Plant, navController: NavController) {
    try {
        val encodedImageUrl =
            URLEncoder.encode(plant.image, StandardCharsets.UTF_8.toString())
        val plant2 =
            Plant(name = plant.name, image = encodedImageUrl)
        val plantJson = Gson().toJson(plant2)
        navController.navigate(NavigationItem.HomeDetailScreen.route + "/$plantJson")
    } catch (e: Exception) {

    }
}

@ExperimentalCoilApi
@Preview(showBackground = true)
@Composable
fun ListPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        val navController: NavController = rememberNavController()
        PlantItem(plant = Plant(name = "Apple", image = ""), navController = navController)
    }
}