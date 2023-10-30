package com.leventsurer.ecommerceappwithcompose.presentation.categories_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.CategoriesResponse
import com.leventsurer.ecommerceappwithcompose.domain.use_case.data_base.GetAllCategoriesUseCase
import com.leventsurer.ecommerceappwithcompose.domain.use_case.data_base.GetProductsInCategoryUseCase
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val getProductsInCategoryUseCase: GetProductsInCategoryUseCase
) : ViewModel() {

    private val _categoriesState = mutableStateOf(CategoriesState())
    val categoriesState: State<CategoriesState> = _categoriesState

    private val _productsInCategoryState = mutableStateOf(ProductState())
    val productsInCategoryState: State<ProductState> = _productsInCategoryState


    private fun getAllCategories() {
        getAllCategoriesUseCase.executeGetUAllCategories().onEach {
            when (it) {
                is Resource.Loading -> {
                    _categoriesState.value = CategoriesState(isLoading = true)
                }

                is Resource.Error -> {
                    _categoriesState.value = CategoriesState(error = it.message)
                }

                is Resource.Success -> {
                    _categoriesState.value = CategoriesState(categories = it.data)
                    getProductsInCategory(it.data!!)
                }
            }
        }.launchIn(viewModelScope)
    }


    private fun getProductsInCategory(categoriesResponse:CategoriesResponse) {
        getProductsInCategoryUseCase.executeGetProductsInAllCategory(categoriesResponse).onEach {
            when (it) {
                is Resource.Loading -> {
                    _productsInCategoryState.value = ProductState(isLoading = true)
                }

                is Resource.Error -> {
                    _productsInCategoryState.value = ProductState(error = it.message)
                }

                is Resource.Success -> {
                    _productsInCategoryState.value = ProductState(productsAndQuantity = it.data)

                }
            }
        }.launchIn(viewModelScope)


    }

    fun onEvent(categoriesEvent: CategoriesEvent) {
        when (categoriesEvent) {
            is CategoriesEvent.GetAllCategories -> {
                getAllCategories()
            }
        }
    }


}