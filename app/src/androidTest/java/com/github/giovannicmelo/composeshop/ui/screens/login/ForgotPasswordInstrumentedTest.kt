package com.github.giovannicmelo.composeshop.ui.screens.login

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.giovannicmelo.composeshop.R
import com.github.giovannicmelo.composeshop.ui.screens.forgotpassword.ForgotPasswordActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@ExperimentalMaterialApi
@RunWith(AndroidJUnit4::class)
class ForgotPasswordInstrumentedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule(ForgotPasswordActivity::class.java)

    @Test
    fun assertThatForgotPasswordScreenComponentsIsDisplayed() {
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(R.string.title_activity_forgot_password),
            useUnmergedTree = true
        ).assertIsDisplayed()
        composeTestRule.onNode(hasTestTag("emailTextField"), useUnmergedTree = true)
            .assertIsDisplayed()
        composeTestRule.onNode(hasTestTag("primaryButton"), useUnmergedTree = true)
            .assertIsDisplayed()
    }

    @Test
    fun assertThatSendButtonIsEnabled() {
        composeTestRule.onNode(hasTestTag("emailTextField"), useUnmergedTree = true)
            .performTextInput("user@email.com")
        composeTestRule.onNode(hasTestTag("primaryButton"), useUnmergedTree = true)
            .assertIsEnabled()
    }

    @Test
    fun assertThatEmailTextFieldHasNoError() {
        composeTestRule.onNode(hasTestTag("emailTextField"), useUnmergedTree = true)
            .performTextInput("user@email.com")
        composeTestRule.onNode(hasText(composeTestRule.activity.getString(R.string.invalid_email)))
            .assertDoesNotExist()
    }

    @Test
    fun assertThatEmailTextFieldHasError() {
        composeTestRule.onNode(hasTestTag("emailTextField"), useUnmergedTree = true)
            .performTextInput("user")
        composeTestRule.onNode(hasText(composeTestRule.activity.getString(R.string.invalid_email)))
            .assertIsDisplayed()
    }
}