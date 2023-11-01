package com.leventsurer.ecommerceappwithcompose.presentation.product_in_category_screen

import com.leventsurer.ecommerceappwithcompose.data.local.room.ProductModel
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.Product

sealed class ProductsInCategoryEvent {

    data class GetProductInProductsInCategory(val categoryName:String):ProductsInCategoryEvent()

    data class AddProductToCart(val productModel: ProductModel):ProductsInCategoryEvent()
}