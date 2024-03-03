package com.example.bikelove.cloud.authorization

import com.example.bikelove.base.Resource
import com.example.bikelove.cloud.authorization.model.login.LoginRequestBody
import com.example.bikelove.cloud.authorization.model.login.LoginResponse
import com.example.bikelove.cloud.authorization.model.login.LoginResult
import com.example.bikelove.utils.ResponseUtils
import javax.inject.Inject

class AuthorizationRepository @Inject constructor(private val authorizationAPI: AuthorizationAPI) {

    suspend fun login(loginRequestBody: LoginRequestBody) : Resource<LoginResult> {

        val response = authorizationAPI.login(loginRequestBody)
        val result = response.body()
        return try {

            //Handling api success responses (201, 200)
            if (response.isSuccessful && result!=null) {

                Resource.Success(LoginResult(
                    result.accessToken
                ))
            } else {
                //Handling api error response (501, 404)
                Resource.ErrorResponse(ResponseUtils.getErrorResponse(response.errorBody()!!.string()))

            }
        } catch (e: Exception) {
            //This is for handling errors where we sometimes misconfigured retrofit instance
            Resource.Error(e.message ?: "An error occured")
        }

    }

}