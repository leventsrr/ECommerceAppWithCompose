package com.leventsurer.ecommerceappwithcompose.presentation.cart_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leventsurer.ecommerceappwithcompose.domain.use_case.data_base.GetAProductByIdUseCase
import com.leventsurer.ecommerceappwithcompose.domain.use_case.data_base.GetAllPastCartsUseCase
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class CartViewModel @Inject constructor(
    private val getAllPastCartsUseCase: GetAllPastCartsUseCase,
    private val getAProductByIdUseCase: GetAProductByIdUseCase,
) : ViewModel(){

    private val _getAllPastCartsState = mutableStateOf(CartState())
    val getAllCartsState : State<CartState> = _getAllPastCartsState



    private fun getAllPastCarts(){
        getAllPastCartsUseCase.executeGetAllPastCarts().onEach {
            when(it){
                is Resource.Loading ->{
                    _getAllPastCartsState.value = CartState(isLoading = true)
                }
                is Resource.Error->{
                    _getAllPastCartsState.value = CartState(error = it.message)
                }
                is Resource.Success->{
                    _getAllPastCartsState.value = CartState(pastCarts = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    /*private fun getAProductByIdInCart(){
        getAProductByIdUseCase.executeGetAProductById("1").onEach {
            when(it){
                is Resource.Loading -> {}
                is Resource.Error -> {}
                is Resource.Success -> {}
            }
        }.launchIn(viewModelScope)
    }*/

    fun onEvent(cartEvent: CartEvent){
        when(cartEvent){
            is CartEvent.GetPastCarts->{
                getAllPastCarts()
            }
        }
    }




}