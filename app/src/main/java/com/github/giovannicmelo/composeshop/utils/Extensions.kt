package com.github.giovannicmelo.composeshop.utils

import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

inline fun <reified T : Any> T.toJson(): String = Gson().toJson(this, T::class.java)
inline fun <reified T : Any> String.fromJson(): T = Gson().fromJson(this, T::class.java)

fun <R> Flow<R>.toStateFlow(coroutineScope: CoroutineScope, initialValue: R?) =
    stateIn(coroutineScope, SharingStarted.Lazily, initialValue)
