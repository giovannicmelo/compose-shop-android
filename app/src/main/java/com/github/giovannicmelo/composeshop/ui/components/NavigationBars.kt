package com.github.giovannicmelo.composeshop.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.github.giovannicmelo.composeshop.ui.theme.Gray
import com.github.giovannicmelo.composeshop.ui.theme.Primary
import com.github.giovannicmelo.composeshop.ui.theme.White
import com.github.giovannicmelo.composeshop.ui.theme.metropolisFontFamily
import com.github.giovannicmelo.composeshop.utils.NavigationItem
import com.github.giovannicmelo.composeshop.utils.NavigationRoute

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationRoute.HOME.name.lowercase()
    ) {
        composable(NavigationItem.Home.route.name.lowercase()) {

        }
        composable(NavigationItem.Shop.route.name.lowercase()) {

        }
        composable(NavigationItem.Bag.route.name.lowercase()) {

        }
        composable(NavigationItem.Favorites.route.name.lowercase()) {

        }
        composable(NavigationItem.Profile.route.name.lowercase()) {

        }
    }
}

@Composable
fun NavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Shop,
        NavigationItem.Bag,
        NavigationItem.Favorites,
        NavigationItem.Profile,
    )
    BottomNavigation(
        backgroundColor = White,
        contentColor = Gray,
        elevation = 0.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconRes),
                        contentDescription = item.route.label
                    )
                },
                label = {
                    Text(
                        text = item.route.label,
                        style = TextStyle(
                            fontFamily = metropolisFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 10.sp
                        )
                    )
                },
                selectedContentColor = Primary,
                unselectedContentColor = Gray,
                alwaysShowLabel = true,
                selected = currentRoute == item.route.name.lowercase(),
                onClick = {
                    navController.navigate(item.route.name.lowercase()) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    }
}

@Preview
@Composable
fun NavigationBarsPreview() {
    val navController = rememberNavController()
    NavigationBar(navController)
}