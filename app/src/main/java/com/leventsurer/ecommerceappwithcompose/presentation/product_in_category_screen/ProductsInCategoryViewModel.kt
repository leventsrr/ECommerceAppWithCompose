package com.leventsurer.ecommerceappwithcompose.presentation.product_in_category_screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leventsurer.ecommerceappwithcompose.data.local.room.FavoriteProductModel
import com.leventsurer.ecommerceappwithcompose.domain.use_case.data_base.GetProductsInCategoryUseCase
import com.leventsurer.ecommerceappwithcompose.domain.use_case.room.favorite_products.AddFavoriteProductUseCase
import com.leventsurer.ecommerceappwithcompose.domain.use_case.room.favorite_products.DeleteFavoriteProductUseCase
import com.leventsurer.ecommerceappwithcompose.domain.use_case.room.favorite_products.GetFavoriteProductsUseCase
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductsInCategoryViewModel @Inject constructor(
    private val getProductsInCategoryUseCase: GetProductsInCategoryUseCase,
    private val addFavoriteProductUseCase: AddFavoriteProductUseCase,
    private val getFavoriteProductsUseCase: GetFavoriteProductsUseCase,
    private val deleteFavoriteProductUseCase: DeleteFavoriteProductUseCase
) : ViewModel() {

    private val _productsInCategoryState = mutableStateOf(ProductsInCategoryState())
    val productsInCategoryState: State<ProductsInCategoryState> = _productsInCategoryState

    private val _addProductToFavoriteState = mutableStateOf(AddProductToFavoriteState())
    val addProductToFavoriteState: State<AddProductToFavoriteState> = _addProductToFavoriteState

    private val _getFavoriteProducts = mutableStateOf(GetFavoritesProductsState())
    val getFavoriteProducts: State<GetFavoritesProductsState> = _getFavoriteProducts

    private val _removeProductFromFavorite = mutableStateOf(RemoveProductFromFavoriteState())
    val removeProductFromFavorite: State<RemoveProductFromFavoriteState> = _removeProductFromFavorite

    private fun getFavoriteProducts() {
        getFavoriteProductsUseCase.executeGetProducts().onEach {
            when (it) {
                is Resource.Loading -> {}
                is Resource.Error -> {}
                is Resource.Success -> {
                    _getFavoriteProducts.value =
                        GetFavoritesProductsState(favoriteProducts = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun removeProductFromFavorite(favoriteProductModel: FavoriteProductModel) {
        deleteFavoriteProductUseCase.executeDeleteFavoriteProduct(favoriteProductModel).onEach {
            when (it) {
                is Resource.Success -> {
                    _removeProductFromFavorite.value =
                        RemoveProductFromFavoriteState(result = it.data!!)
                }

                is Resource.Loading -> {
                    _removeProductFromFavorite.value =
                        RemoveProductFromFavoriteState(isLoading = true)
                }

                is Resource.Error -> {
                    _removeProductFromFavorite.value =
                        RemoveProductFromFavoriteState(error = it.message)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getProductsInCategory(categoryName: String) {
        getProductsInCategoryUseCase.executeGetProductsInCategory(categoryName).onEach {
            when (it) {
                is Resource.Loading -> {
                    _productsInCategoryState.value = ProductsInCategoryState(isLoading = true)
                }

                is Resource.Error -> {
                    _productsInCategoryState.value = ProductsInCategoryState(error = it.message)
                }

                is Resource.Success -> {
                    _productsInCategoryState.value =
                        ProductsInCategoryState(productsInCategory = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun addProductToCart(favoriteProductModel: FavoriteProductModel) {
        addFavoriteProductUseCase.executeAddProductUseCase(favoriteProductModel).onEach {
            when (it) {
                is Resource.Loading -> {
                    _addProductToFavoriteState.value = AddProductToFavoriteState(isLoading = true)
                }

                is Resource.Error -> {
                    _addProductToFavoriteState.value = AddProductToFavoriteState(error = it.message)
                }

                is Resource.Success -> {
                    _addProductToFavoriteState.value = AddProductToFavoriteState(result = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onEvent(productsInCategoryEvent: ProductsInCategoryEvent) {
        when (productsInCategoryEvent) {
            is ProductsInCategoryEvent.GetProductInProductsInCategory -> {
                getProductsInCategory(productsInCategoryEvent.categoryName)
            }

            is ProductsInCategoryEvent.AddProductToCart -> {
                addProductToCart(productsInCategoryEvent.favoriteProductModel)
            }

            is ProductsInCategoryEvent.GetFavoriteProducts -> {
                getFavoriteProducts()
            }

            is ProductsInCategoryEvent.RemoveProductFromFavorite -> {
                removeProductFromFavorite(productsInCategoryEvent.favoriteProductModel)
            }

        }
    }


}