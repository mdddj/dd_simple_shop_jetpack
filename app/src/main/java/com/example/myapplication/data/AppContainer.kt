package com.example.myapplication.data

import android.content.Context
import com.example.myapplication.data.category.CategoryRepository
import com.example.myapplication.data.category.impl.CategoryRepositoryImpl

interface AppContainer {
    val categoryRepository:CategoryRepository

}

class AppContainerImpl(private val appContext: Context) : AppContainer {

    override val categoryRepository: CategoryRepository by lazy {
        CategoryRepositoryImpl()
    }

}