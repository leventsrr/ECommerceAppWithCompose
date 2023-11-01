package com.leventsurer.ecommerceappwithcompose.presentation.product_in_category_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductModel
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.Product
import com.leventsurer.ecommerceappwithcompose.domain.use_case.data_base.GetProductsInCategoryUseCase
import com.leventsurer.ecommerceappwithcompose.domain.use_case.room.AddProductUseCase
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class ProductsInCategoryViewModel @Inject constructor(
    private val getProductsInCategoryUseCase: GetProductsInCategoryUseCase,
    private val addProductUseCase: AddProductUseCase
): ViewModel() {

    private val _productsInCategoryState = mutableStateOf(ProductsInCategoryState())
    val productsInCategoryState : State<ProductsInCategoryState>  = _productsInCategoryState



    private fun getProductsInCategory(categoryName:String){
        getProductsInCategoryUseCase.executeGetProductsInCategory(categoryName).onEach {
            when(it){
                is Resource.Loading ->{
                    _productsInCategoryState.value = ProductsInCategoryState(isLoading = true)
                }
                is Resource.Error ->{
                    _productsInCategoryState.value = ProductsInCategoryState(error = it.message)
                }
                is Resource.Success ->{
                    _productsInCategoryState.value = ProductsInCategoryState(productsInCategory = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun addProductToCart(productModel:ProductModel){
        addProductUseCase.executeAddProductUseCase(productModel)
    }

    fun onEvent(productsInCategoryEvent: ProductsInCategoryEvent){
        when(productsInCategoryEvent){
            is ProductsInCategoryEvent.GetProductInProductsInCategory ->{
                getProductsInCategory(productsInCategoryEvent.categoryName)
            }
            is ProductsInCategoryEvent.AddProductToCart->{
                addProductToCart(productsInCategoryEvent.productModel)
            }
        }
    }


}