package com.leventsurer.ecommerceappwithcompose.domain.use_case.data_base

import android.util.Log
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.CategoriesResponse
import com.leventsurer.ecommerceappwithcompose.data.remote.dto.response.GetProductResponse
import com.leventsurer.ecommerceappwithcompose.domain.model.CategoryProductQuantityModel
import com.leventsurer.ecommerceappwithcompose.domain.repository.DatabaseRepository
import com.leventsurer.ecommerceappwithcompose.tools.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductsInCategoryUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository
) {
     fun executeGetProductsInCategory(categoriesResponse: CategoriesResponse): Flow<Resource<ArrayList<CategoryProductQuantityModel>>> = flow {
        try {
            emit(Resource.Loading())
            val productsQuantityInCategory:ArrayList<CategoryProductQuantityModel> = arrayListOf()
            categoriesResponse.forEach {categoryName->
                val productQuantity = databaseRepository.getProductsInCategory(categoryName).size
                productsQuantityInCategory.add(CategoryProductQuantityModel(categoryName = categoryName, categoryQuantity = productQuantity))
            }
            emit(Resource.Success(productsQuantityInCategory))
        }catch (e:Exception){
            emit(Resource.Error(e.message ?: "Error"))
        }
    }
}