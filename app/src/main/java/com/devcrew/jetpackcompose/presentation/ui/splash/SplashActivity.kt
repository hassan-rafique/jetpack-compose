package com.devcrew.jetpackcompose.presentation.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import coil.annotation.ExperimentalCoilApi
import com.devcrew.jetpackcompose.R
import com.devcrew.jetpackcompose.presentation.ui.main.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@SuppressLint("CustomSplashScreen")
@ExperimentalCoilApi
class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreen()
        }
    }
}

@ExperimentalCoilApi
@Composable
fun SplashScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.color_primary)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(painter = painterResource(id = R.drawable.ic_logo), contentDescription = "")

        Spacer(modifier = Modifier.padding(top = 8.dp))

        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 22.sp,
            color = colorResource(id = R.color.white)
        )
    }

    GotoHome()
}

@SuppressLint("CoroutineCreationDuringComposition")
@ExperimentalCoilApi
@Composable
private fun GotoHome() {
    val context = LocalContext.current
    CoroutineScope(Dispatchers.Main).launch {
        delay(1000L)
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
        (context as Activity).finish()
    }
}

@ExperimentalCoilApi
@Preview(showBackground = true)
@Composable
fun PreviewSplashUi() {
    Surface(modifier = Modifier.fillMaxSize()) {
        SplashScreen()
    }
}