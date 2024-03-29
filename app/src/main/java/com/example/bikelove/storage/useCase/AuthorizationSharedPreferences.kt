package com.example.bikelove.storage.useCase

import android.content.SharedPreferences
import com.example.bikelove.cloud.authorization.AuthorizationConst.SHARED_PREFERENCES_REFRESH_TOKEN_KEY
import com.example.bikelove.cloud.authorization.AuthorizationConst.SHARED_PREFERENCES_TOKEN_KEY
import javax.inject.Inject
import javax.inject.Named

interface AuthorizationSharedPreferences {
    fun putToken(token: String)
    fun getToken(): String?
    fun putRefreshToken(token: String)
    fun getRefreshToken(): String?
}

class AuthorizationSharedPreferencesImpl constructor(
    private val sharedPreferences: SharedPreferences
) : AuthorizationSharedPreferences {

    override fun putToken(token: String) {
        sharedPreferences.edit()
            .putString(SHARED_PREFERENCES_TOKEN_KEY, token)
            .apply()
    }

    override fun getToken(): String? {
        return sharedPreferences.getString(SHARED_PREFERENCES_TOKEN_KEY, null)
    }

    override fun putRefreshToken(token: String) {
        sharedPreferences.edit()
            .putString(SHARED_PREFERENCES_REFRESH_TOKEN_KEY, token)
            .apply()
    }

    override fun getRefreshToken(): String? {
        return sharedPreferences.getString(SHARED_PREFERENCES_REFRESH_TOKEN_KEY, null)
    }

}