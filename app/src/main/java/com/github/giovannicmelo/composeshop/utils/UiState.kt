package com.github.giovannicmelo.composeshop.utils

sealed class UiState<out R> {
    object Idle : UiState<Nothing>()
    object Loading : UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
    data class Failure(val message: String) : UiState<Nothing>()
}