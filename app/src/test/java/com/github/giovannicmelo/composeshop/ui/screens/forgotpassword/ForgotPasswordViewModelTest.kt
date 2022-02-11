package com.github.giovannicmelo.composeshop.ui.screens.forgotpassword

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.clearInvocations
import com.nhaarman.mockitokotlin2.inOrder
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import org.junit.Rule
import org.junit.Test

class ForgotPasswordViewModelTest {

    private val viewModel = ForgotPasswordViewModel()
    private val observerMock: Observer<ForgotPasswordState> = mock()

    @JvmField
    @Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `When e-mail is valid, assert that state changed to success`() {
        val email = "user@email.com"
        val state = ForgotPasswordState().success()
        viewModel.email.postValue(email)

        clearInvocations(observerMock)
        viewModel.state.observeForever(observerMock)

        inOrder(observerMock) {
            verify(observerMock, times(1)).onChanged(state)
        }
    }

    @Test
    fun `When e-mail is not valid, assert that state changed to error`() {
        val email = "user"
        val state = ForgotPasswordState().error()
        viewModel.email.postValue(email)

        clearInvocations(observerMock)
        viewModel.state.observeForever(observerMock)

        inOrder(observerMock) {
            verify(observerMock, times(1)).onChanged(state)
        }
    }
}