package com.example.myapplication.data.category.impl

import com.example.myapplication.data.category.CategoryRepository
import com.example.myapplication.service.category.CategoryService
import com.example.myapplication.util.BaseApiServiceCreate
import com.example.myapplication.util.await
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * 获取全局分类数据的实现
 */
class CategoryRepositoryImpl : CategoryRepository {

    private val service: CategoryService = BaseApiServiceCreate.create(CategoryService::class.java)



    /**
     * 从服务器获取分类数据
     * withContext (是一个挂起函数,async的简化写法)
     */
    override suspend fun getCategorys() {

        withContext(Dispatchers.IO) {
           val result =  service.getCategorys().await()
            println(result)
        }

    }
}