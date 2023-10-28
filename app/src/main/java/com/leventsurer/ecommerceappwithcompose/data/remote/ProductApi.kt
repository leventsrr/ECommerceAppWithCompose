package com.leventsurer.ecommerceappwithcompose.data.remote

import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetProductResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {
        @GET("products/category/{categoryName}")
        suspend fun getProductsInCategory(@Path("categoryName") categoryName:String) :ArrayList<GetProductResponse>
}