package com.github.giovannicmelo.composeshop.ui.screens

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.junit.Rule

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

        val loginValidObserver: Observer<Boolean> = mock()
        viewModel.loginValid.observeForever(loginValidObserver)

        verify(loginValidObserver, times(2)).onChanged(true)
    }
}