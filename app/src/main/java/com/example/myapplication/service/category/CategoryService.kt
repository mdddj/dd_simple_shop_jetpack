package com.example.myapplication.service.category

import com.example.myapplication.util.MyResponseResult
import retrofit2.Call
import retrofit2.http.GET

interface CategoryService {

    @GET("/category")
    fun getCategorys(): Call<MyResponseResult<String>>
}