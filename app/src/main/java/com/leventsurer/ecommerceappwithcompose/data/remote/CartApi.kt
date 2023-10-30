package com.leventsurer.ecommerceappwithcompose.data.remote

import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetAllCartsResponse
import retrofit2.http.GET

interface CartApi {

    @GET("carts")
    suspend fun getAllPastCarts() : ArrayList<GetAllCartsResponse>
}