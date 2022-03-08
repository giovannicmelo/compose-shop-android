package com.github.giovannicmelo.composeshop.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.giovannicmelo.composeshop.ui.theme.*

@Composable
fun Headline1Text(text: String, color: Color = Black) {
    Text(
        text = text,
        color = color,
        style = MaterialTheme.typography.h1
    )
}

@Composable
fun Headline2Text(text: String, color: Color = Black) {
    Text(
        text = text,
        color = color,
        style = MaterialTheme.typography.h2
    )
}

@Composable
fun Headline3Text(text: String, color: Color = Black) {
    Text(
        text = text,
        color = color,
        style = MaterialTheme.typography.h3
    )
}

@Composable
fun BodyText(text: String, color: Color = Black) {
    Text(
        text = text,
        color = color,
        style = MaterialTheme.typography.body1,
        lineHeight = 20.sp
    )
}

@Composable
fun Subtitle1Text(text: String, color: Color = Black) {
    Text(
        text = text,
        color = color,
        style = MaterialTheme.typography.subtitle1
    )
}

@Composable
fun DescriptiveText(text: String, color: Color = Black) {
    Text(
        text = text,
        color = color,
        style = MaterialTheme.typography.button,
        lineHeight = 20.sp
    )
}

@Composable
fun TextFieldErrorText(text: String) {
    Text(
        text = text,
        color = Error,
        style = MaterialTheme.typography.subtitle1,
        modifier = Modifier.padding(start = 16.dp, top = 1.dp)
    )
}

@Composable
fun NavLabelText(text: String, isActive: Boolean = false) {
    Text(
        text = text,
        color = if (isActive) Primary else Gray,
        style = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 8.sp
        )
    )
}

@Preview(showBackground = true)
@Composable
fun TextsPreview() {
    ComposeShopTheme() {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Headline1Text("Headline1")
            Spacer(modifier = Modifier.height(8.dp))
            Headline2Text("Headline2")
            Spacer(modifier = Modifier.height(8.dp))
            Headline3Text("Headline3")
            Spacer(modifier = Modifier.height(8.dp))
            BodyText("Body Body Body Body Body Body Body Body Body Body Body Body Body Body Body Body Body")
            Spacer(modifier = Modifier.height(8.dp))
            Subtitle1Text("Subtitle1")
            Spacer(modifier = Modifier.height(8.dp))
            DescriptiveText("Descriptive Text")
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}