package com.example.myapplication.service.category

import com.example.myapplication.data.category.impl.ArchAllModel
import com.example.myapplication.util.BaseApiServiceCreate
import com.example.myapplication.util.MyResponseResult
import retrofit2.Call
import retrofit2.http.GET

interface CategoryService {



    @GET("category")
    suspend fun getCategorys(): MyResponseResult<String>

    @GET("api/blog/statistics")
    suspend fun getBlogsCategorys() : MyResponseResult<ArchAllModel>


    companion object {
        var service: CategoryService? = null
        fun getInstance() : CategoryService {
            return service ?: BaseApiServiceCreate.create(CategoryService::class.java)
        }
    }

}