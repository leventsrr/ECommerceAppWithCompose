package com.leventsurer.ecommerceappwithcompose.data.remote.dto.request

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("password")
    val password: String,
    @SerializedName("username")
    val username: String
) {
    override fun toString() = ""
}