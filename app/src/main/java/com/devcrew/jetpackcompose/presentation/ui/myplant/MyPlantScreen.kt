package com.devcrew.jetpackcompose.presentation.ui.myplant

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.getValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.devcrew.jetpackcompose.R
import com.devcrew.jetpackcompose.domain.entity.Plant
import com.devcrew.jetpackcompose.presentation.ui.view.PlantCard
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

var isScroll = false
var isEmpty = false

@SuppressLint("CoroutineCreationDuringComposition")
@ExperimentalComposeUiApi
@Composable
fun LocalScreen() {

    val mViewModel: MyPlantViewModel = hiltViewModel()
    val plantsList = mViewModel.plantList

    val context = LocalContext.current

    val showDialog = remember { mutableStateOf(false) }
    var name by rememberSaveable { mutableStateOf("") }
    var desc by rememberSaveable { mutableStateOf("") }
    var validate by rememberSaveable { mutableStateOf(false) }

    if (showDialog.value) {
        AddPlantDialog(
            showDialog = showDialog.value,
            onDismiss = { showDialog.value = false },
            name = name,
            onNameChange = { name = it },
            desc = desc,
            onDescChange = { desc = it },
            onValidate = { validate = true }
        )
    }

    if (validate) {
        mViewModel.addPlant(Plant(name = name, description = desc))
        name = ""
        desc = ""
        validate = false
        isScroll = true
        CoroutineScope(Dispatchers.Main).launch {
            delay(100)
            Toast.makeText(context, mViewModel.responseMessage, Toast.LENGTH_SHORT).show()
        }
    }

    Scaffold(floatingActionButton = {
        FloatingActionButton(
            onClick = {
                showDialog.value = true
            },
            contentColor = Color.White,
            backgroundColor = colorResource(id = R.color.color_primary)
        ) {
            Icon(Icons.Filled.Add, "")
        }
    }) {
        ItemList(plantsList = plantsList, mViewModel = mViewModel)
        if (isEmpty) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "No Plants Found",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ItemList(plantsList: List<Plant>, mViewModel: MyPlantViewModel) {

    isEmpty = plantsList.isEmpty()

    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(plantsList) { plant ->
            PlantCard(plant = plant, mViewModel = mViewModel)
        }
    }

    coroutineScope.launch {
        if (isScroll) {
            listState.animateScrollToItem(index = plantsList.size - 1)
            isScroll = false
        }
    }
}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun LocalScreenPreview() {
    LocalScreen()
}
