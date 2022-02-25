package com.github.giovannicmelo.composeshop.ui.screens.forgotpassword

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.*
import org.junit.Assert
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
        viewModel.setEmail(email)

        val result = viewModel.validateEmail() ?: false

        Assert.assertTrue(result)
    }
}