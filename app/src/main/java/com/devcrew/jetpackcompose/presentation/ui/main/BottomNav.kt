package com.devcrew.jetpackcompose.presentation.ui.main

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.devcrew.jetpackcompose.R
import com.devcrew.jetpackcompose.presentation.core.navigation.NavigationItem

@Composable
fun SetupBottomNavigation(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Local
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.white),
        contentColor = Color.Gray,
        elevation = 8.dp
    ) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(label = { Text(text = item.title) },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = ""
                    )
                },
                selectedContentColor = colorResource(id = R.color.color_primary),
                unselectedContentColor = Color.Gray,
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reSelecting the same item
                        launchSingleTop = true
                        // Restore state when reSelecting a previously selected item
                        restoreState = true
                    }
                })
        }
    }
}

@Preview
@Composable
fun PreviewBottomNav() {
    val navController = rememberNavController()
    SetupBottomNavigation(navController = navController)
}