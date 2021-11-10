package com.devcrew.jetpackcompose.presentation.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.devcrew.jetpackcompose.presentation.core.navdrawer.NavDrawerScreen
import com.devcrew.jetpackcompose.presentation.core.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalCoilApi
class MainActivity : ComponentActivity() {

    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //define activity's layout where we call composable function
        setContent {
            MainScreen()
        }
    }
}

@ExperimentalComposeUiApi
@ExperimentalCoilApi
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val scaffoldState =
        rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    var gestureEnableState by remember { mutableStateOf(true) }

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            NavDrawerScreen(scope = scope, scaffoldState = scaffoldState)
        },
        topBar = {
            TopBar(
                scope = scope,
                scaffoldState = scaffoldState,
                navController,
                gestureEnableState = { gestureEnableState = it }
            )
        },
        drawerGesturesEnabled = gestureEnableState,
        bottomBar = { SetupBottomNavigation(navController) }) {

        Box(modifier = Modifier.padding(it)) {
            Navigation(navController)
        }
    }
}

// preview your composable function within IDE
@ExperimentalComposeUiApi
@ExperimentalCoilApi
@Preview(showBackground = true)
@Composable
fun Preview() {
    Surface(modifier = Modifier.wrapContentHeight()) {
        MainScreen()
    }
}
