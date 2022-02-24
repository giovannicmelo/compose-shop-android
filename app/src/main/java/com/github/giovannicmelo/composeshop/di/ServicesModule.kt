package com.github.giovannicmelo.composeshop.di

import com.github.giovannicmelo.composeshop.data.services.FirebaseAuthService
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ServicesModule {

    @Provides
    @ViewModelScoped
    fun provideFirebaseAuthService(auth: FirebaseAuth) = FirebaseAuthService(auth)
}