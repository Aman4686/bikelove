package com.example.bikelove.cloud.authorization.model.login

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("accessToken")
    val accessToken: String? = null,

    @SerializedName("user")
    val user: User? = User()
) {

    data class User(
        @SerializedName("firstName")
        val firstName: String? = null,
        @SerializedName("lastName")
        val lastName: String? = null,
        @SerializedName("patronymic")
        val patronymic: String? = null,
        @SerializedName("shopId")
        val shopId: Int? = null,
        @SerializedName("balance")
        val balance: Int? = null,
        @SerializedName("creditLimit")
        val creditLimit: Int? = null,
        @SerializedName("id")
        val id: String? = null,
        @SerializedName("email")
        val email: String? = null,
        @SerializedName("phoneNumber")
        val phoneNumber: String? = null,
        @SerializedName("emailConfirmed")
        val emailConfirmed: Boolean? = null,
        @SerializedName("phoneNumberConfirmed")
        val phoneNumberConfirmed: Boolean? = null,
        @SerializedName("roles")
        val roles: ArrayList<String> = arrayListOf()
    )

}

