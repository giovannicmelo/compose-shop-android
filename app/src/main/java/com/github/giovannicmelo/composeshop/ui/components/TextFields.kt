package com.github.giovannicmelo.composeshop.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.giovannicmelo.composeshop.R
import com.github.giovannicmelo.composeshop.ui.theme.*
import com.github.giovannicmelo.composeshop.ui.utils.advancedShadow

@Composable
internal fun MaterialTheme.textStyle(): TextStyle = typography.button.copy(
    color = Black2
)

internal fun Modifier.textFieldModifier(): Modifier = fillMaxWidth()
    .advancedShadow(
        color = Gray,
        alpha = 0.2f,
        cornersRadius = 4.dp,
        shadowBlurRadius = 6.dp,
        offsetX = 0.dp,
        offsetY = 0.dp
    )

@Composable
internal fun TextFieldDefaults.textFieldColorsStyled(): TextFieldColors = textFieldColors(
    backgroundColor = White,
    textColor = Black2,
    disabledTextColor = Color.Transparent,
    focusedIndicatorColor = Color.Transparent,
    unfocusedIndicatorColor = Color.Transparent,
    disabledIndicatorColor = Color.Transparent
)

@Composable
fun EmailTextField(
    text: String = "",
    onChanged: (String) -> Unit = {}
) {
    TextField(
        label = {
            Subtitle1Text(
                text = stringResource(id = R.string.email_hint),
                color = Gray
            )
        },
        textStyle = MaterialTheme.textStyle(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        shape = Shapes.small,
        modifier = Modifier.textFieldModifier(),
        colors = TextFieldDefaults.textFieldColorsStyled(),
        value = text,
        onValueChange = onChanged,
    )
}

@Composable
fun PasswordTextField(
    text: String = "",
    onChanged: (String) -> Unit = {},
) {
    TextField(
        label = {
            Subtitle1Text(
                text = stringResource(id = R.string.password_hint),
                color = Gray
            )
        },
        textStyle = MaterialTheme.textStyle(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        shape = Shapes.small,
        modifier = Modifier.textFieldModifier(),
        colors = TextFieldDefaults.textFieldColorsStyled(),
        visualTransformation = PasswordVisualTransformation(),
        value = text,
        onValueChange = onChanged
    )
}

@Preview(showBackground = true)
@Composable
fun TextFieldsPreview() {
    ComposeShopTheme {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            EmailTextField("my.user@email.com")
            Spacer(modifier = Modifier.height(4.dp))
            PasswordTextField("123456")
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}