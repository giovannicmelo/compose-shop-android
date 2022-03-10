package com.github.giovannicmelo.composeshop.utils

import androidx.annotation.DrawableRes
import com.github.giovannicmelo.composeshop.R

enum class NavigationRoute(val label: String) {
    HOME("Home"),
    SHOP("Shop"),
    BAG("Bag"),
    FAVORITES("Favorites"),
    PROFILE("Profile");
}

sealed class NavigationItem(
    @DrawableRes var iconResSelected: Int,
    @DrawableRes var iconRes: Int,
    var route: NavigationRoute
) {
    object Home : NavigationItem(
        R.drawable.ic_home,
        R.drawable.ic_home_inactive,
        NavigationRoute.HOME
    )

    object Shop : NavigationItem(
        R.drawable.ic_cart,
        R.drawable.ic_cart_inactive,
        NavigationRoute.SHOP
    )

    object Bag : NavigationItem(
        R.drawable.ic_shop,
        R.drawable.ic_shop_inactive,
        NavigationRoute.BAG
    )

    object Favorites : NavigationItem(
        R.drawable.ic_favorite,
        R.drawable.ic_favorite_inative,
        NavigationRoute.FAVORITES
    )

    object Profile : NavigationItem(
        R.drawable.ic_profile,
        R.drawable.ic_profile_inative,
        NavigationRoute.PROFILE
    )
}