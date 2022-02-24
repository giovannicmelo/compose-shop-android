package com.github.giovannicmelo.composeshop.ui.screens.login

import android.os.Parcel
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.github.giovannicmelo.composeshop.data.ResultWrapper
import com.github.giovannicmelo.composeshop.data.services.FirebaseAuthService
import com.github.giovannicmelo.composeshop.ui.screens.CoroutinesTestRule
import com.github.giovannicmelo.composeshop.utils.UiState
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.nhaarman.mockitokotlin2.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class LoginViewModelTest {

    private val serviceMock: FirebaseAuthService = mock()
    private val viewModel = LoginViewModel(serviceMock)

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @Test
    fun `Assert that e-mail is valid`() {
        val email = "user@email.com"
        viewModel.setEmail(email)

        val result = viewModel.validateEmail() ?: false

        Assert.assertTrue(result)
    }


    @Test
    fun `Assert that password is valid`() {
        val password = "123456"
        viewModel.setPassword(password)

        val result = viewModel.validatePassword() ?: false

        Assert.assertTrue(result)
    }

    @Test
    fun `Assert that initial state is idle`() {
        val currentState = viewModel.uiState.value
        Assert.assertTrue(currentState is UiState.Idle)
    }
}