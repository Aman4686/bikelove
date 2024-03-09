package com.example.bikelove.di

import com.example.bikelove.cloud.authorization.AuthorizationAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideAuthorizationAPI(retrofit : Retrofit): AuthorizationAPI = retrofit.create(
        AuthorizationAPI::class.java)

}