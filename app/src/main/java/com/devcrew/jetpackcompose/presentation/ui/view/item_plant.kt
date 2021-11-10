package com.devcrew.jetpackcompose.presentation.ui.view

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.devcrew.jetpackcompose.R
import com.devcrew.jetpackcompose.domain.entity.Plant
import com.devcrew.jetpackcompose.presentation.ui.myplant.MyPlantViewModel

@Composable
fun PlantCard(plant: Plant, mViewModel: MyPlantViewModel) {
    Card(
        modifier = Modifier
            .padding(top = 12.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {

            },
        elevation = 4.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,

                ) {

                Text(
                    text = plant.name,
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_delete),
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        mViewModel.deletePlant(plant)
                    }
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = plant.description,
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPlantCard() {
    Surface(modifier = Modifier.fillMaxSize()) {
        val mViewModel: MyPlantViewModel = hiltViewModel()
        PlantCard(plant = Plant(name = "Apple", description = "Desc here"), mViewModel)
    }
}
