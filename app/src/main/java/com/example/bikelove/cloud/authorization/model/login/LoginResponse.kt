package com.example.bikelove.cloud.authorization.model.login

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("accessToken")
    val accessToken: String? = null,

    @SerializedName("user")
    val user: User? = User()
) {

    data class User(
        @SerializedName("id")
        var id: String? = null,
        @SerializedName("email")
        var email: String? = null,
        @SerializedName("emailConfirmed")
        var emailConfirmed: Boolean? = null,
        @SerializedName("phoneNumber")
        var phoneNumber: String? = null,
        @SerializedName("phoneNumberConfirmed")
        var phoneNumberConfirmed: Boolean? = null,
        @SerializedName("twoFactorEnabled")
        var twoFactorEnabled: Boolean? = null,
        @SerializedName("firstName")
        var firstName: String? = null,
        @SerializedName("lastName")
        var lastName: String? = null,
        @SerializedName("patronymic")
        var patronymic: String? = null,
        @SerializedName("shopId")
        var shopId: Int? = null,
        @SerializedName("isEmployee")
        var isEmployee: Boolean? = null,
        @SerializedName("bike")
        var bike: String? = null,
        @SerializedName("balance")
        var balance: Int? = null,
        @SerializedName("creditLimit")
        var creditLimit: Int? = null,
        @SerializedName("created")
        var created: String? = null,
        @SerializedName("updated")
        var updated: String? = null,
        @SerializedName("gender")
        var gender: String? = null,
        @SerializedName("birth")
        var birth: String? = null,
        @SerializedName("language")
        var language: String? = null,
        @SerializedName("lastInteraction")
        var lastInteraction: String? = null,
        @SerializedName("interactionFail")
        var interactionFail: String? = null,
        @SerializedName("unsolvedTasks")
        var unsolvedTasks: Boolean? = null
    )

}

