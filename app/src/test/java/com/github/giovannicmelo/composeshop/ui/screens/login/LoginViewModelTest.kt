package com.github.giovannicmelo.composeshop.ui.screens.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.Rule
import org.junit.Test

class LoginViewModelTest {

    private val viewModel = LoginViewModel()

    @JvmField
    @Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `Assert that e-mail and password are valid`() {
        val email = "user@email.com"
        val password = "123456"
        viewModel.email.postValue(email)
        viewModel.password.postValue(password)

        val observerMock: Observer<Boolean> = mock()
        viewModel.loginValid.observeForever(observerMock)

        verify(observerMock, times(2)).onChanged(true)
    }

    @Test
    fun `Assert that e-mail is valid`() {
        val email = "user@email.com"
        viewModel.email.postValue(email)

        val observerMock: Observer<Boolean> = mock()
        viewModel.emailValid.observeForever(observerMock)

        verify(observerMock, times(1)).onChanged(true)
    }

    @Test
    fun `Assert that password is valid`() {
        val password = "123456"
        viewModel.password.postValue(password)

        val observerMock: Observer<Boolean> = mock()
        viewModel.passwordValid.observeForever(observerMock)

        verify(observerMock, times(1)).onChanged(true)
    }
}