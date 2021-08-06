package com.example.myapplication.data.category

import com.example.myapplication.data.category.impl.Categorys

// 分类相关数据访问接口
interface CategoryRepository {

    // 获取分类数据
    suspend fun getCategorys()

}