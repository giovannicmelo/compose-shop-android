package com.github.giovannicmelo.composeshop.ui.components

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
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
    disabledIndicatorColor = Color.Transparent,
    errorLabelColor = Error,
    errorCursorColor = Error
)

@Composable
internal fun TrailingIconValidator(isSuccess: Boolean?) {
    when (isSuccess) {
        true -> {
            Image(
                painter = painterResource(id = R.drawable.ic_success),
                contentDescription = null
            )
        }
        false -> {
            Image(
                painter = painterResource(id = R.drawable.ic_error),
                contentDescription = null
            )
        }
        null -> {}
    }
}

@Composable
fun EmailTextField(
    text: String = "",
    isValid: Boolean? = null,
    errorMessage: String = "",
    onChanged: (String) -> Unit = {},
) {
    val isError = isValid != null && isValid == false
    Column {
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
            isError = isError,
            onValueChange = onChanged,
            trailingIcon = { TrailingIconValidator(isValid) }
        )
        if (isError) {
            TextFieldErrorText(text = errorMessage)
        }
    }
}

@Composable
fun PasswordTextField(
    text: String = "",
    isValid: Boolean? = null,
    errorMessage: String = "",
    onChanged: (String) -> Unit = {},
) {
    val isError = isValid != null && isValid == false
    Column() {
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
            isError = isError,
            onValueChange = onChanged,
            trailingIcon = { TrailingIconValidator(isValid) }
        )
        if (isError) {
            TextFieldErrorText(text = errorMessage)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldsPreview() {
    ComposeShopTheme {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            EmailTextField("my.user@email.com", isValid = true, errorMessage = "Not a valid e-mail.")
            Spacer(modifier = Modifier.height(8.dp))
            PasswordTextField("123456")
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}