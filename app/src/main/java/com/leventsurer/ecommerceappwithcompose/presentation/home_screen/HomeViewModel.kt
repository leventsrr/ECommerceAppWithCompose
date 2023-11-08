package com.leventsurer.ecommerceappwithcompose.presentation.home_screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leventsurer.ecommerceappwithcompose.data.local.room.FavoriteProductModel
import com.leventsurer.ecommerceappwithcompose.domain.use_case.data_base.GetAllCategoriesUseCase
import com.leventsurer.ecommerceappwithcompose.domain.use_case.data_base.GetAllProductsUseCase
import com.leventsurer.ecommerceappwithcompose.domain.use_case.data_base.SearchProductByNameUseCase
import com.leventsurer.ecommerceappwithcompose.domain.use_case.room.favorite_products.AddFavoriteProductUseCase
import com.leventsurer.ecommerceappwithcompose.domain.use_case.room.favorite_products.DeleteFavoriteProductUseCase
import com.leventsurer.ecommerceappwithcompose.domain.use_case.room.favorite_products.GetFavoriteProductsUseCase
import com.leventsurer.ecommerceappwithcompose.presentation.product_in_category_screen.GetFavoritesProductsState
import com.leventsurer.ecommerceappwithcompose.presentation.product_in_category_screen.RemoveProductFromFavoriteState
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val getAllProductsUseCase: GetAllProductsUseCase,
    private val searchProductByNameUseCase: SearchProductByNameUseCase,
    private val getFavoriteProductsUseCase: GetFavoriteProductsUseCase,
    private val addProductToFavoriteProductsUseCase: AddFavoriteProductUseCase,
    private val deleteFavoriteProductUseCase: DeleteFavoriteProductUseCase
) : ViewModel() {

    private val _newArrivalProductsState = mutableStateOf(NewArrivalProductsState())
    val newArrivalProductsState: State<NewArrivalProductsState> = _newArrivalProductsState

    private val _topCategoriesState = mutableStateOf(TopCategoriesState())
    val topCategoriesState: State<TopCategoriesState> = _topCategoriesState

    private val _searchProductByNameState = mutableStateOf(SearchProductByNameState())
    val searchProductByNameState: State<SearchProductByNameState> = _searchProductByNameState

    private val _getFavoriteProducts = mutableStateOf(GetFavoritesProductsState())
    val getFavoriteProducts: State<GetFavoritesProductsState> = _getFavoriteProducts

    private val _addProductToFavorite = mutableStateOf(AddProductToFavoriteState())
    val addProductToFavorite: State<AddProductToFavoriteState> = _addProductToFavorite

    private val _removeProductFromFavorite = mutableStateOf(RemoveProductFromFavoriteState())
    val removeProductFromFavorite: State<RemoveProductFromFavoriteState> =
        _removeProductFromFavorite

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
        }
    }

    private fun addProductToFavorite(favoriteProductModel: FavoriteProductModel) {
        addProductToFavoriteProductsUseCase.executeAddProductUseCase(favoriteProductModel).onEach {
            when (it) {
                is Resource.Loading -> {}
                is Resource.Error -> {}
                is Resource.Success -> {
                    _addProductToFavorite.value = AddProductToFavoriteState(result = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getNewArrivalProducts() {
        getAllProductsUseCase.executeGetRandomProductsInAll().onEach {
            when (it) {
                is Resource.Loading -> {
                    _newArrivalProductsState.value = NewArrivalProductsState(isLoading = true)
                }

                is Resource.Error -> {
                    _newArrivalProductsState.value = NewArrivalProductsState(error = it.message)
                }

                is Resource.Success -> {
                    _newArrivalProductsState.value =
                        NewArrivalProductsState(newArrivalProducts = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }


    private fun getTopCategories() {
        getAllCategoriesUseCase.executeGetUAllCategories().onEach {
            when (it) {
                is Resource.Loading -> {
                    _topCategoriesState.value = TopCategoriesState(isLoading = true)
                }

                is Resource.Error -> {
                    _topCategoriesState.value = TopCategoriesState(error = it.message)
                }

                is Resource.Success -> {
                    _topCategoriesState.value = TopCategoriesState(topCategories = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun searchProductByName(productName: String) {
        searchProductByNameUseCase.executeSearchProductByName(productName).onEach {
            when (it) {
                is Resource.Loading -> {
                    _searchProductByNameState.value = SearchProductByNameState(isLoading = true)
                }

                is Resource.Error -> {
                    _searchProductByNameState.value = SearchProductByNameState(error = it.message)
                }

                is Resource.Success -> {
                    _searchProductByNameState.value = SearchProductByNameState(products = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onEvent(homeEvent: HomeEvent) {
        when (homeEvent) {
            is HomeEvent.GetHomeScreenData -> {
                getNewArrivalProducts()
                getTopCategories()
            }

            is HomeEvent.SearchProductByName -> {
                searchProductByName(homeEvent.productName)
            }

            is HomeEvent.GetFavoriteProducts -> {
                getFavoriteProducts()
            }

            is HomeEvent.AddProductToFavorite -> {
                addProductToFavorite(homeEvent.favoriteProductModel)
            }

            is HomeEvent.RemoveProductFromFavorite -> {
                removeProductFromFavorite(homeEvent.favoriteProductModel)
            }
        }
    }
}