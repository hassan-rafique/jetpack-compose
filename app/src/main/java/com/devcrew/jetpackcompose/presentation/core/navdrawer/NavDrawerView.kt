package com.devcrew.jetpackcompose.presentation.core.navdrawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devcrew.jetpackcompose.presentation.utils.toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun NavDrawerView(item: NavDrawerItem, scope: CoroutineScope, scaffoldState: ScaffoldState) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clickable {
                toast(context, item.title)
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            }
    ) {
        Image(
            painterResource(id = item.icon),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 12.dp)
        )

        Spacer(modifier = Modifier.padding(start = 8.dp))

        Text(
            text = item.title,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNavView() {
//    NavDrawerView(item = NavDrawerItem.AboutUs)
}