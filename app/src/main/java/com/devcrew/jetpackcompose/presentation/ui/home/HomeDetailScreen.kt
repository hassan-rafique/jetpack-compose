package com.devcrew.jetpackcompose.presentation.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.devcrew.jetpackcompose.R
import com.devcrew.jetpackcompose.domain.entity.Plant

@ExperimentalCoilApi
@Composable
fun HomeDetailScreen(plant: Plant) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
                    .clip(RoundedCornerShape(bottomEndPercent = 12)),
                painter = rememberImagePainter(plant.image),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.padding(top = 8.dp))

            Text(
                text = plant.name, fontWeight = FontWeight.Bold, fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.padding(top = 8.dp))

            Text(
                text = stringResource(id = R.string.str_fruite_Desc), fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 16.dp, end = 16.dp),
                textAlign = TextAlign.Justify
            )
        }
    }
}

@ExperimentalCoilApi
@Preview(showBackground = true)
@Composable
fun PreviewHomeDetailScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        HomeDetailScreen(plant = Plant())
    }
}
