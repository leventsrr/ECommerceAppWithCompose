package com.leventsurer.ecommerceappwithcompose.presentation.cart_screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leventsurer.ecommerceappwithcompose.domain.use_case.data_base.GetAllPastCartsUseCase
import com.leventsurer.ecommerceappwithcompose.domain.use_case.room.favorite_products.GetFavoriteProductsUseCase
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
) : ViewModel(){

    private val _getAllPastCartsState = mutableStateOf(PastCartState())
    val getAllPastCartsState : State<PastCartState> = _getAllPastCartsState

    private val _getCurrentCartState = mutableStateOf(CurrentCartState())
    val getCurrentCartState : State<CurrentCartState> = _getCurrentCartState


    private fun getAllPastCarts(){
        getAllPastCartsUseCase.executeGetAllPastCarts().onEach {
            when(it){
                is Resource.Loading ->{
                    _getAllPastCartsState.value = PastCartState(isLoading = true)
                }
                is Resource.Error->{
                    _getAllPastCartsState.value = PastCartState(error = it.message)
                }
                is Resource.Success->{
                    _getAllPastCartsState.value = PastCartState(pastCarts = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }


    private fun getCurrentCart(){
        executeGetProductsInCart.executeGetProductsInCart().onEach {
            when(it){
                is Resource.Loading ->{
                    Log.e("kontrol","getCurrentCart loading")
                    _getCurrentCartState.value = CurrentCartState(isLoading = true)
                }
                is Resource.Error->{
                    _getCurrentCartState.value = CurrentCartState(error = it.message)
                }
                is Resource.Success->{
                    Log.e("kontrol","getCurrentCart success ${it.data!!.size}")
                    _getCurrentCartState.value = CurrentCartState(currentCart = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }




    fun onEvent(cartEvent: CartEvent){
        when(cartEvent){
            is CartEvent.GetPastCarts->{
                getAllPastCarts()
            }
            is CartEvent.GetCurrentCart->{
                getCurrentCart()
            }
        }
    }




}