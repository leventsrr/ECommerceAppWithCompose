package com.leventsurer.ecommerceappwithcompose.domain.use_case.data_base

import android.util.Log
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetAllCartsResponse
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetProductResponse
import com.leventsurer.ecommerceappwithcompose.domain.model.PastCart
import com.leventsurer.ecommerceappwithcompose.domain.model.ProductWithQuantity
import com.leventsurer.ecommerceappwithcompose.domain.repository.DatabaseRepository
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAProductByIdUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository
) {
    fun executeGetAProductById(productId: String): Flow<Resource<GetProductResponse>> = flow {
        try {
            emit(Resource.Loading())
            val product = databaseRepository.getAProductById(productId)
            emit(Resource.Success(product))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Error"))
        }
    }

    fun executeGetProductsById(allPastCarts: ArrayList<GetAllCartsResponse>): Flow<Resource<ArrayList<PastCart>>> =
        flow {
            val carts = ArrayList<PastCart>()
            try {
                emit(Resource.Loading())
                allPastCarts.forEach { pastCart ->
                    val cartProducts = ArrayList<ProductWithQuantity>()
                    pastCart.products.forEachIndexed { index, product ->
                        val product =
                            databaseRepository.getAProductById(product.productId.toString())
                        cartProducts.add(
                            ProductWithQuantity(
                                product = product,
                                quantity = pastCart.products[index].quantity
                            )
                        )
                    }
                    carts.add(PastCart(cartDate = pastCart.date, products = cartProducts))
                }
                emit(Resource.Success(carts))
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Error"))
            }
        }


}