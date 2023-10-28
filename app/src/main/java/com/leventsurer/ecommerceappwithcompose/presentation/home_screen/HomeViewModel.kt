package com.leventsurer.ecommerceappwithcompose.presentation.home_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leventsurer.ecommerceappwithcompose.domain.use_case.data_base.GetAllCategoriesUseCase
import com.leventsurer.ecommerceappwithcompose.domain.use_case.data_base.GetAllProductsUseCase
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val getAllProductsUseCase: GetAllProductsUseCase
) : ViewModel(){

    private val _newArrivalProductsState = mutableStateOf(NewArrivalProductsState())
    val newArrivalProductsState : State<NewArrivalProductsState> = _newArrivalProductsState

    private val _topCategoriesState = mutableStateOf(TopCategoriesState())
    val topCategoriesState : State<TopCategoriesState> = _topCategoriesState


    private fun getNewArrivalProducts(){
        getAllProductsUseCase.executeGetRandomProductsInAll().onEach {
            when(it){
                is Resource.Loading ->{
                    _newArrivalProductsState.value = NewArrivalProductsState(isLoading = true)
                }
                is Resource.Error ->{
                    _newArrivalProductsState.value = NewArrivalProductsState(error = it.message)
                }
                is Resource.Success->{
                    _newArrivalProductsState.value = NewArrivalProductsState(newArrivalProducts = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }


    private fun getTopCategories(){
        getAllCategoriesUseCase.executeGetUAllCategories().onEach {
            when(it){
                is Resource.Loading ->{
                    _topCategoriesState.value = TopCategoriesState(isLoading = true)
                }
                is Resource.Error ->{
                    _topCategoriesState.value = TopCategoriesState(error = it.message)
                }
                is Resource.Success->{
                    _topCategoriesState.value = TopCategoriesState(topCategories = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }


    fun onEvent(homeEvent: HomeEvent){
        when(homeEvent){
            is HomeEvent.GetHomeScreenData->{
                getNewArrivalProducts()
                getTopCategories()
            }
        }
    }


}