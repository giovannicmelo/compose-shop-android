package com.github.giovannicmelo.composeshop.utils

import android.content.Context
import android.content.Intent

object Actions {

    object ForgotPassword {

        object Navigation : NavigationAction() {
            override val action = "intent.action.forgotpassword.open"
        }
    }
}

abstract class NavigationAction {

    abstract val action: String
    fun createIntent(context: Context): Intent = getActionIntent(context, action)

    private fun getActionIntent(context: Context, action: String): Intent =
        Intent(action).setPackage(context.packageName)
}