package com.leventsurer.ecommerceappwithcompose.domain.use_case.room.product_to_cart

import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductInCartModel
import com.leventsurer.ecommerceappwithcompose.domain.repository.RoomProductsDatabaseRepository
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AddProductToCartUseCase @Inject constructor(
    private val roomProductsDatabaseRepository: RoomProductsDatabaseRepository
) {
    fun executeAddProductToCart(productInCartModel: ProductInCartModel): Flow<Resource<Boolean>> =
        flow {
            try {
                emit(Resource.Loading())
                val currentCartProducts = roomProductsDatabaseRepository.getProductsToCart()
                currentCartProducts.forEach { product ->
                    if (productInCartModel.productId == product.productId) {
                        productInCartModel.productQuantity += product.productQuantity
                        roomProductsDatabaseRepository.insertProductToCart(productInCartModel)
                    }
                }
                roomProductsDatabaseRepository.insertProductToCart(productInCartModel)
                emit(Resource.Success(true))
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Error"))
            }
        }
}