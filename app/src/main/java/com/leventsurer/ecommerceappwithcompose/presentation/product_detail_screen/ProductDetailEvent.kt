package com.leventsurer.ecommerceappwithcompose.presentation.product_detail_screen

sealed class ProductDetailEvent {

    data class GetProductDetailById(val productId:String) : ProductDetailEvent()
}