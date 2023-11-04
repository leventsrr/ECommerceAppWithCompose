package com.leventsurer.ecommerceappwithcompose.domain.use_case.room.product_to_cart

import android.util.Log
import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductInCartModel
import com.leventsurer.ecommerceappwithcompose.domain.repository.RoomProductsDatabaseRepository
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductsInCartUseCase @Inject constructor(
    private val roomProductsDatabaseRepository: RoomProductsDatabaseRepository
){

    fun executeGetProductsInCart(): Flow<Resource<List<ProductInCartModel>>> = flow{
        try {
            Log.e("kontrol","executeGetProductsInCart try")
            emit(Resource.Loading())
            val productsInCart = roomProductsDatabaseRepository.getProductsToCart()
            emit(Resource.Success(productsInCart))
        }catch (e:Exception){
            Log.e("kontrol","executeGetProductsInCart error:${e.message}")
            emit(Resource.Error(e.message ?: "Error"))
        }
    }
}