package com.leventsurer.ecommerceappwithcompose.presentation.favorite_products_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leventsurer.ecommerceappwithcompose.data.local.room.FavoriteProductModel
import com.leventsurer.ecommerceappwithcompose.domain.use_case.room.favorite_products.DeleteFavoriteProductUseCase
import com.leventsurer.ecommerceappwithcompose.domain.use_case.room.favorite_products.GetFavoriteProductsUseCase
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getFavoriteProductsUseCase: GetFavoriteProductsUseCase,
    private val deleteFavoriteProductUseCase: DeleteFavoriteProductUseCase
) : ViewModel() {
    private val _getFavoriteProductsUseCase = mutableStateOf(GetFavoriteProductsState())
    val getFavoriteProducts: State<GetFavoriteProductsState> = _getFavoriteProductsUseCase

    private val _deleteFavoriteProductState = mutableStateOf(DeleteFavoriteProductState())
    val deleteFavoriteProductState: State<DeleteFavoriteProductState> = _deleteFavoriteProductState

    private fun getFavoriteProducts() {
        getFavoriteProductsUseCase.executeGetProducts().onEach {
            when (it) {
                is Resource.Loading -> {
                    _getFavoriteProductsUseCase.value = GetFavoriteProductsState(isLoading = true)
                }

                is Resource.Error -> {
                    _getFavoriteProductsUseCase.value = GetFavoriteProductsState(error = it.message)
                }

                is Resource.Success -> {
                    _getFavoriteProductsUseCase.value =
                        GetFavoriteProductsState(favoriteProducts = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun deleteFavoriteProduct(favoriteProductModel: FavoriteProductModel) {
        deleteFavoriteProductUseCase.executeDeleteFavoriteProduct(favoriteProductModel).onEach {
            when (it) {
                is Resource.Loading -> {
                    _deleteFavoriteProductState.value = DeleteFavoriteProductState(isLoading = true)
                }

                is Resource.Error -> {
                    _deleteFavoriteProductState.value =
                        DeleteFavoriteProductState(error = it.message)
                }

                is Resource.Success -> {
                    _deleteFavoriteProductState.value = DeleteFavoriteProductState(result = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onEvent(favoriteEvent: FavoriteEvent) {
        when (favoriteEvent) {
            is FavoriteEvent.GetFavoriteProducts -> {
                getFavoriteProducts()
            }

            is FavoriteEvent.DeleteFavoriteProduct -> {
                deleteFavoriteProduct(favoriteEvent.favoriteProductModel)
            }
        }
    }
}