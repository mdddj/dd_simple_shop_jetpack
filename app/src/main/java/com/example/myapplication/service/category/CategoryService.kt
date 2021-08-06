package com.example.myapplication.service.category

import retrofit2.Call
import retrofit2.http.GET

interface CategoryService {

    @GET("/category")
    fun getCategorys(): Call<Result<String>>
}