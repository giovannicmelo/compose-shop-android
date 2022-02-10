package com.github.giovannicmelo.composeshop.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.giovannicmelo.composeshop.R
import com.github.giovannicmelo.composeshop.ui.theme.Black
import com.github.giovannicmelo.composeshop.ui.theme.ComposeShopTheme

@Composable
fun TopAppBarSimple(title: String = "") {
    val appBarHorizontalPadding = 4.dp

    TopAppBar(
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            Modifier
                .height(44.dp)
                .fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = title,
                color = Black,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun TopAppBarWithBackButton(title: String = "", navAction: () -> Unit = {}) {
    val appBarHorizontalPadding = 4.dp
    val titleIconModifier = Modifier
        .fillMaxHeight()
        .width(72.dp - appBarHorizontalPadding)

    TopAppBar(
        backgroundColor = Color.Transparent,
        elevation = 0.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(Modifier.height(44.dp)) {

            // Nav icon
            Row(
                titleIconModifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = navAction) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_icon_nav_back),
                        contentDescription = null
                    )
                }
            }

            // Title
            Row(
                Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    color = Black,
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppBarsPreview() {
    ComposeShopTheme {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            TopAppBarSimple("App Bar Simple")
            Spacer(modifier = Modifier.height(4.dp))
            TopAppBarWithBackButton("App Bar With Back Button")
        }
    }
}