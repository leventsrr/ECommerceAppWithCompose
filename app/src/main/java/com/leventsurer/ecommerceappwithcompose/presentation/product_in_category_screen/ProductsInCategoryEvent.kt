package com.leventsurer.ecommerceappwithcompose.presentation.product_in_category_screen

sealed class ProductsInCategoryEvent {

    data class GetProductInProductsInCategory(val categoryName:String):ProductsInCategoryEvent()
}