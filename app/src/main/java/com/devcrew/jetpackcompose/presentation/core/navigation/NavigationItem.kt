package com.devcrew.jetpackcompose.presentation.core.navigation

import com.devcrew.jetpackcompose.R

sealed class NavigationItem(
    var route: String = "",
    var title: String = "",
    var icon: Int = 0
) {
    object Home : NavigationItem("Home", "Home", R.drawable.ic_home)
    object Local : NavigationItem("Local", "Local", R.drawable.ic_local)
    object HomeDetailScreen : NavigationItem("Plant Detail", "Home Detail", 0)
}
