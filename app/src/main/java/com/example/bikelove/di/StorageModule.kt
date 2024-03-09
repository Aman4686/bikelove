package com.example.bikelove.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.bikelove.cloud.authorization.AuthorizationConst
import com.example.bikelove.storage.useCase.SharedPreferencesHelper
import com.example.bikelove.storage.useCase.SharedPreferencesHelperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StorageModule {

    @Singleton
    @Named("authorization")
    @Provides
    fun provideTokenSharedPreferences(app: Application): SharedPreferences {
        return app.applicationContext.getSharedPreferences(
            AuthorizationConst.SHARED_PREFERENCES_AUTHORIZATION_KEY,
            Context.MODE_PRIVATE
        )
    }

    @Singleton
    @Provides
    fun provideSharedPreferencesHelper(sharedPreferences: SharedPreferences): SharedPreferencesHelper {
        return SharedPreferencesHelperImpl(sharedPreferences)
    }


}