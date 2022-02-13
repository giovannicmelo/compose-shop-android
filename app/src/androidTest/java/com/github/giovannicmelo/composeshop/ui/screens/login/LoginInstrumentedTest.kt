package com.github.giovannicmelo.composeshop.ui.screens.login

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.giovannicmelo.composeshop.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalMaterialApi
@RunWith(AndroidJUnit4::class)
class LoginInstrumentedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule(LoginActivity::class.java)

    @Test
    fun assertThatLoginScreenComponentsIsDisplayed() {
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(R.string.title_activity_login)
        ).assertIsDisplayed()

        composeTestRule.onNode(hasTestTag("emailTextField"), useUnmergedTree = true)
            .assertIsDisplayed()
        composeTestRule.onNode(hasTestTag("passwordTextField"), useUnmergedTree = true)
            .assertIsDisplayed()
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(R.string.forgot_password),
            useUnmergedTree = true
        )
            .assertIsDisplayed()
        composeTestRule.onNode(hasTestTag("primaryButton"), useUnmergedTree = true)
            .assertIsDisplayed()
        composeTestRule.onNode(hasTestTag("googleSocialMediaButton"), useUnmergedTree = true)
        composeTestRule.onNode(hasTestTag("facebookSocialMediaButton"), useUnmergedTree = true)
    }

    @Test
    fun assertThatLoginButtonIsEnabled() {
        composeTestRule.onNode(hasTestTag("emailTextField"), useUnmergedTree = true)
            .performTextInput("user@email.com")
        composeTestRule.onNode(hasTestTag("passwordTextField"), useUnmergedTree = true)
            .performTextInput("1234")
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
    fun assertThatPasswordTextFieldHasNoError() {
        composeTestRule.onNode(hasTestTag("passwordTextField"), useUnmergedTree = true)
            .performTextInput("1234")
        composeTestRule.onNode(hasText(composeTestRule.activity.getString(R.string.invalid_password)))
            .assertDoesNotExist()
    }

    @Test
    fun assertThatEmailTextFieldHasError() {
        composeTestRule.onNode(hasTestTag("emailTextField"), useUnmergedTree = true)
            .performTextInput("user")
        composeTestRule.onNode(hasText(composeTestRule.activity.getString(R.string.invalid_email)))
            .assertIsDisplayed()
    }

    @Test
    fun assertThatPasswordTextFieldHasError() {
        composeTestRule.onNode(hasTestTag("passwordTextField"), useUnmergedTree = true)
            .performTextInput("12")
        composeTestRule.onNode(hasText(composeTestRule.activity.getString(R.string.invalid_password)))
            .assertIsDisplayed()
    }
}