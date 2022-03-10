package com.github.giovannicmelo.composeshop.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.github.giovannicmelo.composeshop.ui.theme.*
import com.github.giovannicmelo.composeshop.utils.NavigationItem
import com.github.giovannicmelo.composeshop.utils.NavigationRoute

private val items = listOf(
    NavigationItem.Home,
    NavigationItem.Shop,
    NavigationItem.Bag,
    NavigationItem.Favorites,
    NavigationItem.Profile,
)

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
    BottomNavigation(
        modifier = Modifier.clip(RoundedCornerShape(12.dp, 12.dp, 0.dp, 0.dp)),
        backgroundColor = White,
        elevation = 12.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            val isSelected = currentRoute == item.route.name.lowercase()
            BottomNavigationItem(
                modifier = Modifier.padding(top = 32.dp),
                icon = {
                    Icon(
                        painter = painterResource(id = if (isSelected) item.iconResSelected else item.iconRes),
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
                selected = isSelected,
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
    ComposeShopTheme() {
        Column(Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(8.dp))
            NavigationBar(navController)
        }
    }

}