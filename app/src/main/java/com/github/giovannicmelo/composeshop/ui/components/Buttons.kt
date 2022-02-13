package com.github.giovannicmelo.composeshop.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.giovannicmelo.composeshop.R
import com.github.giovannicmelo.composeshop.ui.theme.*
import com.github.giovannicmelo.composeshop.ui.utils.advancedShadow

@Composable
fun PrimaryButton(
    label: String,
    matchParent: Boolean = true,
    isEnabled: Boolean = true,
    action: () -> Unit = {}
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Primary,
            contentColor = White,
            disabledBackgroundColor = Primary.copy(alpha = 0.4f),
            disabledContentColor = White,
        ),
        shape = CircleShape,
        modifier = (if (matchParent) Modifier.fillMaxWidth() else Modifier.wrapContentWidth())
            .height(48.dp)
            .advancedShadow(
                color = Primary,
                alpha = 0.3f,
                cornersRadius = 48.dp,
                shadowBlurRadius = 6.dp,
                offsetX = 0.dp,
                offsetY = 2.dp
            )
            .testTag("primaryButton"),
        enabled = isEnabled,
        onClick = action,
    ) {
        Text(label.uppercase())
    }
}

@Composable
fun OutlineButton(
    label: String,
    matchParent: Boolean = true,
    isEnabled: Boolean = true,
    action: () -> Unit = {}
) {
    OutlinedButton(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = White,
            contentColor = Black,
            disabledBackgroundColor = White.copy(alpha = 0.9f),
            disabledContentColor = Gray,
        ),
        shape = CircleShape,
        border = if (isEnabled) BorderStroke(1.5.dp, Black) else BorderStroke(1.5.dp, Gray),
        modifier = (if (matchParent) Modifier.fillMaxWidth() else Modifier.wrapContentWidth())
            .height(48.dp)
            .advancedShadow(
                color = Black,
                alpha = 0.3f,
                cornersRadius = 48.dp,
                shadowBlurRadius = 6.dp,
                offsetX = 0.dp,
                offsetY = 2.dp
            )
            .testTag("outlineButton"),
        enabled = isEnabled,
        onClick = action,
    ) {
        Text(label.uppercase())
    }
}

internal fun Modifier.socialMediaButtonModifier(): Modifier =
    size(93.dp, 65.dp)
        .advancedShadow(
            color = Gray,
            alpha = 0.1f,
            cornersRadius = 24.dp,
            shadowBlurRadius = 6.dp,
            offsetX = 0.dp,
            offsetY = 0.dp
        )

@ExperimentalMaterialApi
@Composable
fun GoogleSocialMediaButton(action: () -> Unit = {}) {
    Surface(
        color = White,
        shape = Shapes.large,
        elevation = 0.dp,
        modifier = Modifier
            .socialMediaButtonModifier()
            .testTag("googleSocialMediaButton"),
        onClick = { action() }
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo_google),
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 34.dp, vertical = 20.dp)
        )
    }
}

@ExperimentalMaterialApi
@Composable
fun FacebookSocialMediaButton(action: () -> Unit = {}) {
    Surface(
        color = White,
        shape = Shapes.large,
        elevation = 0.dp,
        modifier = Modifier
            .socialMediaButtonModifier()
            .testTag("facebookSocialMediaButton"),
        onClick = { action() }
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo_facebook),
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 34.dp, vertical = 20.dp)
        )
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun ButtonsPreview() {
    ComposeShopTheme() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            PrimaryButton(
                label = "Primary",
                matchParent = true,
                isEnabled = true
            ) {

            }
            Spacer(modifier = Modifier.height(4.dp))
            OutlineButton(
                label = "Outline",
                matchParent = true,
                isEnabled = true
            ) {

            }
            Spacer(modifier = Modifier.height(14.dp))
            Row() {
                GoogleSocialMediaButton()
                Spacer(modifier = Modifier.width(8.dp))
                FacebookSocialMediaButton()
            }
        }
    }
}