package com.leventsurer.ecommerceappwithcompose.domain.use_case.room.product_to_cart

import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductInCartModel
import com.leventsurer.ecommerceappwithcompose.domain.repository.RoomProductsDatabaseRepository
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject



class DeleteProductsFromCartUseCase @Inject constructor(
    private val roomProductsDatabaseRepository: RoomProductsDatabaseRepository
){

    fun executeDeleteProductsFromCart(productInCartModel: ProductInCartModel): Flow<Resource<Boolean>> = flow{
        try {
            emit(Resource.Loading())
             roomProductsDatabaseRepository.deleteProductToCart(productInCartModel)
            emit(Resource.Success(true))
        }catch (e:Exception){
            emit(Resource.Error(e.message ?: "Error"))
        }
    }
}