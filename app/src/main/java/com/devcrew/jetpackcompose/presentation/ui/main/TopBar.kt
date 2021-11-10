package com.devcrew.jetpackcompose.presentation.ui.main

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.devcrew.jetpackcompose.R
import com.devcrew.jetpackcompose.presentation.core.navigation.NavigationItem
import com.devcrew.jetpackcompose.presentation.utils.currentRoute
import com.devcrew.jetpackcompose.presentation.utils.topBarTitle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopBar(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavHostController,
    gestureEnableState: (Boolean) -> Unit
) {
    val currentDestinationRoute = currentRoute(navController = navController)
    val isDetailScreen =
        currentDestinationRoute == NavigationItem.HomeDetailScreen.route + "/{plant}"

    TopAppBar(
        title = { Text(text = topBarTitle(currentDestinationRoute), fontSize = 18.sp) },
        backgroundColor = colorResource(id = R.color.color_primary),
        contentColor = Color.White,
        navigationIcon = {
            IconButton(onClick = {
                onIconButtonClick(isDetailScreen, navController, scope, scaffoldState)
            }) {
                SetIconButton(isDetailScreen, scope, scaffoldState, gestureEnableState)
            }
        }
    )
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
private fun SetIconButton(
    isDetailScreen: Boolean,
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    gestureEnableState: (Boolean) -> Unit
) {
    if (isDetailScreen) {
        gestureEnableState(false)
        Icon(Icons.Filled.ArrowBack, "")
        scope.launch {
            scaffoldState.drawerState.close()
        }
    } else {
        gestureEnableState(true)
        Icon(Icons.Filled.Menu, "")
    }
}

private fun onIconButtonClick(
    isDetailScreen: Boolean,
    navController: NavController,
    scope: CoroutineScope,
    scaffoldState: ScaffoldState
) {
    if (isDetailScreen)
        navController.popBackStack()
    else
        scope.launch {
            scaffoldState.drawerState.open()
        }
}
