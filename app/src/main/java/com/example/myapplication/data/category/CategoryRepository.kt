package com.example.myapplication.data.category

import com.example.myapplication.data.category.impl.Category
import kotlinx.coroutines.flow.Flow

// 分类相关数据访问接口
interface CategoryRepository {

    /**
     * 从服务器获取分类数据
     */
    suspend fun getCategorys()

    /**
     * 获取博客分类数据
     */
    suspend fun getBlogCategorys()

    /**
     * 观察超级大分类数据
     */
    fun observeCategory():Flow<List<Category>>

}