package com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leventsurer.ecommerceappwithcompose.domain.use_case.data_base.GetAProductByIdUseCase
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val getAProductByIdUseCase: GetAProductByIdUseCase
) :ViewModel() {


    private val _getAProductByIdState = mutableStateOf(ProductDetailState())
    val getAProductByIdState : State<ProductDetailState> = _getAProductByIdState
    private fun getAProductById(productId:String){
        getAProductByIdUseCase.executeGetAProductById(productId).onEach {
            when(it){
                is Resource.Loading->{
                    Log.e("kontrol","viewmodel loading")
                    _getAProductByIdState.value = ProductDetailState(isLoading = true)
                }
                is Resource.Error->{
                    Log.e("kontrol","viewmodel error : ${it.message}")

                    _getAProductByIdState.value = ProductDetailState(error = it.message)
                }
                is Resource.Success->{
                    _getAProductByIdState.value = ProductDetailState(productDetail = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }


    fun onEvent(productDetailEvent: ProductDetailEvent){
        when(productDetailEvent){
            is ProductDetailEvent.GetProductDetailById ->{
                getAProductById(productDetailEvent.productId)
            }
        }
    }


}