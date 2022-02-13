package com.github.giovannicmelo.composeshop.ui.screens.forgotpassword

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.*
import org.junit.Rule
import org.junit.Test

class ForgotPasswordViewModelTest {

    private val viewModel = ForgotPasswordViewModel()

    @JvmField
    @Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `Assert that e-mail is valid`() {
        val email = "user@email.com"
        viewModel.email.postValue(email)

        val observerMock: Observer<Boolean> = mock()
        viewModel.emailValid.observeForever(observerMock)

        verify(observerMock, times(1)).onChanged(true)
    }
}