@file:Suppress("EXPERIMENTAL_IS_NOT_ENABLED")

package com.github.giovannicmelo.composeshop.ui.components

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.github.giovannicmelo.composeshop.ui.theme.Primary

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Loader(loading: Boolean = false) {
    val isLoading by remember { mutableStateOf(loading) }
    if (isLoading) {
        Dialog(
            properties = DialogProperties(usePlatformDefaultWidth = false),
            onDismissRequest = { }
        ) {
            CircularProgressIndicator(color = Primary)
        }
    }
}