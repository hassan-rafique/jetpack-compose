package com.devcrew.jetpackcompose.presentation.core.navdrawer

import com.devcrew.jetpackcompose.R

sealed class NavDrawerItem(
    var route: String,
    var icon: Int,
    var title: String
) {
    object AboutUs : NavDrawerItem("about_us", R.drawable.ic_about_us, "About Us")
    object PrivacyPolicy :
        NavDrawerItem("privacy_policy", R.drawable.ic_privacy_policy, "Privacy Policy")

    object RateUs : NavDrawerItem("rate_us", R.drawable.ic_rate_us, "Rate Us")
    object Share : NavDrawerItem("share", R.drawable.ic_share, "Share")
    object HowToUse : NavDrawerItem("how_to_use", R.drawable.ic_how_to_use, "How to use")
    object Feedback : NavDrawerItem("feedback", R.drawable.ic_feedback, "Feedback")
}
