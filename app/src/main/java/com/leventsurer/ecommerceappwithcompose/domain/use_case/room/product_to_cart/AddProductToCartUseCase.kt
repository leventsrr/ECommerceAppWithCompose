package com.leventsurer.ecommerceappwithcompose.domain.use_case.room.product_to_cart

import android.util.Log
import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductInCartModel
import com.leventsurer.ecommerceappwithcompose.domain.repository.RoomProductsDatabaseRepository
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AddProductToCartUseCase @Inject constructor(
    private val roomProductsDatabaseRepository: RoomProductsDatabaseRepository
) {
    fun executeAddProductToCart(productInCartModel: ProductInCartModel): Flow<Resource<Boolean>> = flow {
        try {
            Log.e("kontrol","executeAddProductToCart try")
            emit(Resource.Loading())
            roomProductsDatabaseRepository.insertProductToCart(productInCartModel)
            emit(Resource.Success(true))
        }catch (e:Exception){
            Log.e("kontrol","executeAddProductToCart cath ${e.message}")

            emit(Resource.Error(e.message ?: "Error"))
        }
    }
}