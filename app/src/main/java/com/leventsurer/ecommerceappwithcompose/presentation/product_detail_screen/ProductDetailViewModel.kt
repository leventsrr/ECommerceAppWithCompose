package com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leventsurer.ecommerceappwithcompose.data.local.room.FavoriteProductModel
import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductInCartModel
import com.leventsurer.ecommerceappwithcompose.domain.use_case.data_base.GetAProductByIdUseCase
import com.leventsurer.ecommerceappwithcompose.domain.use_case.room.favorite_products.AddFavoriteProductUseCase
import com.leventsurer.ecommerceappwithcompose.domain.use_case.room.favorite_products.DeleteFavoriteProductUseCase
import com.leventsurer.ecommerceappwithcompose.domain.use_case.room.favorite_products.GetFavoriteProductsUseCase
import com.leventsurer.ecommerceappwithcompose.domain.use_case.room.product_to_cart.AddProductToCartUseCase
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val getAProductByIdUseCase: GetAProductByIdUseCase,
    private val addProductToCartUseCase: AddProductToCartUseCase,
    private val getFavoriteProductsUseCase: GetFavoriteProductsUseCase,
    private val addFavoriteProductUseCase: AddFavoriteProductUseCase,
    private val deleteFavoriteProductUseCase: DeleteFavoriteProductUseCase
) : ViewModel() {

    private val _getAProductByIdState = mutableStateOf(ProductDetailState())
    val getAProductByIdState: State<ProductDetailState> = _getAProductByIdState

    private val _productCartTransactionState = mutableStateOf(ProductCartTransactionsState())
    val productCartTransactionState: State<ProductCartTransactionsState> =
        _productCartTransactionState

    private val _getFavoriteProductsState = mutableStateOf(GetFavoriteProductsState())
    val getFavoriteProductsState: State<GetFavoriteProductsState> = _getFavoriteProductsState

    private val _addProductToFavorites = mutableStateOf(false)
    val addProductToFavorites = _addProductToFavorites

    private val _removeProductFromFavorites = mutableStateOf(false)
    val removeProductFromFavorite = _removeProductFromFavorites

    private fun removeProductFromFavorites(favoriteProductModel: FavoriteProductModel) {
        deleteFavoriteProductUseCase.executeDeleteFavoriteProduct(favoriteProductModel).onEach {
            when (it) {
                is Resource.Loading -> {}
                is Resource.Error -> {}
                is Resource.Success -> {
                    _removeProductFromFavorites.value = it.data!!
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun addProductToFavorites(favoriteProductModel: FavoriteProductModel) {
        addFavoriteProductUseCase.executeAddProductUseCase(favoriteProductModel).onEach {
            when (it) {
                is Resource.Loading -> {}
                is Resource.Error -> {}
                is Resource.Success -> {
                    _addProductToFavorites.value = it.data!!
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getFavoriteProducts() {
        getFavoriteProductsUseCase.executeGetProducts().onEach {
            when (it) {
                is Resource.Loading -> {
                    _getFavoriteProductsState.value = GetFavoriteProductsState(isLoading = true)
                }

                is Resource.Error -> {
                    _getFavoriteProductsState.value = GetFavoriteProductsState(error = it.message)
                }

                is Resource.Success -> {
                    _getFavoriteProductsState.value = GetFavoriteProductsState(result = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getAProductById(productId: String) {
        getAProductByIdUseCase.executeGetAProductById(productId).onEach {
            when (it) {
                is Resource.Loading -> {
                    _getAProductByIdState.value = ProductDetailState(isLoading = true)
                }

                is Resource.Error -> {
                    _getAProductByIdState.value = ProductDetailState(error = it.message)
                }

                is Resource.Success -> {
                    _getAProductByIdState.value = ProductDetailState(productDetail = it.data)
                    getFavoriteProducts()
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun addProductToCart(productInCartModel: ProductInCartModel) {
        addProductToCartUseCase.executeAddProductToCart(productInCartModel).onEach {
            when (it) {
                is Resource.Loading -> {
                    _productCartTransactionState.value =
                        ProductCartTransactionsState(isLoading = true)
                }

                is Resource.Error -> {
                    _productCartTransactionState.value =
                        ProductCartTransactionsState(error = it.message)
                }

                is Resource.Success -> {
                    _productCartTransactionState.value =
                        ProductCartTransactionsState(result = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onEvent(productDetailEvent: ProductDetailEvent) {
        when (productDetailEvent) {
            is ProductDetailEvent.GetProductDetailById -> {
                getAProductById(productDetailEvent.productId)
            }

            is ProductDetailEvent.AddProductToCart -> {
                addProductToCart(productDetailEvent.productInCartModel)
            }

            is ProductDetailEvent.DeleteProductFromCart -> {}

            is ProductDetailEvent.AddProductToFavorites -> {
                addProductToFavorites(productDetailEvent.favoriteProductModel)
            }

            is ProductDetailEvent.RemoveProductToFavorites -> {
                removeProductFromFavorites(productDetailEvent.favoriteProductModel)
            }

        }
    }
}