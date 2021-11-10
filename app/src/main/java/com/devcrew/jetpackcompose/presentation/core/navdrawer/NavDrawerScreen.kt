package com.devcrew.jetpackcompose.presentation.core.navdrawer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devcrew.jetpackcompose.R
import kotlinx.coroutines.CoroutineScope

@Composable
fun NavDrawerScreen(scope: CoroutineScope, scaffoldState: ScaffoldState) {

    val items = listOf(
        NavDrawerItem.AboutUs,
        NavDrawerItem.PrivacyPolicy,
        NavDrawerItem.RateUs,
        NavDrawerItem.Share,
        NavDrawerItem.HowToUse,
        NavDrawerItem.Feedback
    )

    Column {
        NavHeaderItem()
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp),
        ) {
            items(items) { item ->
                NavDrawerView(item = item, scope, scaffoldState)
                Divider(
                    color = colorResource(id = R.color.color_md_grey_300),
                    modifier = Modifier.padding(start = 20.dp, end = 4.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewNavDrawer() {
    Surface(modifier = Modifier.fillMaxSize()) {
        val scope = rememberCoroutineScope()
        val scaffoldState = rememberScaffoldState()
        NavDrawerScreen(scope = scope, scaffoldState = scaffoldState)
    }
}

