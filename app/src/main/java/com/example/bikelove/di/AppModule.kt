package com.example.bikelove.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.bikelove.BuildConfig
import com.example.bikelove.cloud.authorization.AuthorizationAPI
import com.example.bikelove.cloud.authorization.AuthorizationConst.SHARED_PREFERENCES_AUTHORIZATION_KEY
import com.example.bikelove.storage.useCase.SharedPreferencesHelper
import com.example.bikelove.storage.useCase.SharedPreferencesHelperImpl
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Named("baseUrl")
    fun providesBaseUrl() : String = "https://bikeshop.1gb.ua/"

    @Provides
    @Singleton
    fun provideOkHttpClient() : OkHttpClient {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(OkHttpProfilerInterceptor() )
        }
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(@Named("baseUrl") BASE_URL : String, client: OkHttpClient) : Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(client)
        .build()

}