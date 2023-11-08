package com.leventsurer.ecommerceappwithcompose.presentation.cart_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductInCartModel
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetAllCartsResponse
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.Product
import com.leventsurer.ecommerceappwithcompose.domain.use_case.data_base.GetAProductByIdUseCase
import com.leventsurer.ecommerceappwithcompose.domain.use_case.data_base.GetAllPastCartsUseCase
import com.leventsurer.ecommerceappwithcompose.domain.use_case.room.product_to_cart.DeleteProductsFromCartUseCase
import com.leventsurer.ecommerceappwithcompose.domain.use_case.room.product_to_cart.GetProductsInCartUseCase
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val getAllPastCartsUseCase: GetAllPastCartsUseCase,
    private val executeGetProductsInCart: GetProductsInCartUseCase,
    private val getAProductByIdUseCase: GetAProductByIdUseCase,
    private val deleteProductsFromCartUseCase: DeleteProductsFromCartUseCase
) : ViewModel() {
    private val _getAllPastCartsState = mutableStateOf(PastCartState())
    val getAllPastCartsState: State<PastCartState> = _getAllPastCartsState

    private val _getCurrentCartState = mutableStateOf(CurrentCartState())
    val getCurrentCartState: State<CurrentCartState> = _getCurrentCartState


    private val _getPastCartsWithProducts = mutableStateOf(ProductsInPastCartState())
    val getPastCartsWithProducts: State<ProductsInPastCartState> = _getPastCartsWithProducts

    private val _deleteProductFromCurrentCart = mutableStateOf(DeleteProductFromCurrentCartState())
    val deleteProductFromCurrentCart: State<DeleteProductFromCurrentCartState> =
        _deleteProductFromCurrentCart


    private fun getProductsById(allCart: ArrayList<GetAllCartsResponse>) {
        getAProductByIdUseCase.executeGetProductsById(allCart).onEach {
            when (it) {
                is Resource.Loading -> {
                    _getPastCartsWithProducts.value = ProductsInPastCartState(isLoading = true)
                }

                is Resource.Error -> {
                    _getPastCartsWithProducts.value = ProductsInPastCartState(error = it.message)
                }

                is Resource.Success -> {
                    _getPastCartsWithProducts.value =
                        ProductsInPastCartState(pastCarts = it.data!!, isLoading = false)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun deleteProductFromCurrentCart(productInCartModel: ProductInCartModel) {
        deleteProductsFromCartUseCase.executeDeleteProductsFromCart(productInCartModel).onEach {
            when (it) {
                is Resource.Loading -> {
                    _deleteProductFromCurrentCart.value =
                        DeleteProductFromCurrentCartState(isLoading = true)
                }

                is Resource.Error -> {
                    _deleteProductFromCurrentCart.value =
                        DeleteProductFromCurrentCartState(error = it.message)
                }

                is Resource.Success -> {
                    _deleteProductFromCurrentCart.value =
                        DeleteProductFromCurrentCartState(result = it.data)
                }
            }
        }
    }

    private fun getPastCartWithIncludesProducts() {
        getAllPastCartsUseCase.executeGetAllPastCarts().onEach {
            when (it) {
                is Resource.Loading -> {
                    _getAllPastCartsState.value = PastCartState(isLoading = true)
                }

                is Resource.Error -> {
                    _getAllPastCartsState.value = PastCartState(error = it.message)
                }

                is Resource.Success -> {
                    getProductsById(it.data!!)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getCurrentCart() {
        executeGetProductsInCart.executeGetProductsInCart().onEach {
            when (it) {
                is Resource.Loading -> {
                    _getCurrentCartState.value = CurrentCartState(isLoading = true)
                }

                is Resource.Error -> {
                    _getCurrentCartState.value = CurrentCartState(error = it.message)
                }

                is Resource.Success -> {
                    _getCurrentCartState.value = CurrentCartState(currentCart = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onEvent(cartEvent: CartEvent) {
        when (cartEvent) {
            is CartEvent.GetPastCarts -> {
                getPastCartWithIncludesProducts()
            }

            is CartEvent.GetCurrentCart -> {
                getCurrentCart()
            }

            is CartEvent.DeleteProductFromCurrentCart -> {
                deleteProductFromCurrentCart(cartEvent.productInCartModel)
            }

        }
    }
}