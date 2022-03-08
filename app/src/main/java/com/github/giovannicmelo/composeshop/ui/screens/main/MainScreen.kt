package com.github.giovannicmelo.composeshop.ui.screens.main

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.github.giovannicmelo.composeshop.ui.components.NavigationBar
import com.github.giovannicmelo.composeshop.ui.components.NavigationGraph
import com.github.giovannicmelo.composeshop.ui.theme.ComposeShopTheme

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    ComposeShopTheme {
        Scaffold(
            bottomBar = { NavigationBar(navController = navController) }
        ) {
            NavigationGraph(navController = navController)
        }
    }
}

@Composable
@Preview()
fun MainScreenPreview() {
    MainScreen()
}