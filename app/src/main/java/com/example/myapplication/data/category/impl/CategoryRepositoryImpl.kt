package com.example.myapplication.data.category.impl

import android.util.Log
import com.example.myapplication.data.category.CategoryRepository
import com.example.myapplication.service.category.CategoryService
import com.example.myapplication.util.BaseApiServiceCreate
import com.example.myapplication.util.await
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext
import timber.log.Timber

/**
 * 获取全局分类数据的实现
 */
class CategoryRepositoryImpl : CategoryRepository {


    /**
     * 存放分类数据状态
     */
    private val categorys = MutableStateFlow<List<Category>>(listOf())

    /**
     * 从服务器获取分类数据
     * withContext (是一个挂起函数,async的简化写法)
     */
    override suspend fun getCategorys() {

        withContext(Dispatchers.IO) {
            val result = CategoryService.getInstance().getCategorys()
            if(result.isSuccess()){
                val data = result.getData
                val list = Gson().fromJson(data,List::class.java)
                Timber.d("${list.size}")
            }
        }

    }

    /**
     * 获取博客分类数据
     */
    override suspend fun getBlogCategorys() {
        withContext(Dispatchers.IO) {
            val result = CategoryService.getInstance().getBlogsCategorys()
            Log.i("Myapp"," 获取到博客分类数据${result}")
            if(result.isSuccess()){

            }
        }
    }

    /**
     * 观察超级大分类数据
     * 这个方法用来干嘛的??
     * ps: 当分类数据变更的时候,在compose 组件里面可以通过 #collectAsState 方法来转变为组件状态来刷新UI
     */
    override fun observeCategory(): Flow<List<Category>> {
        return categorys
    }
}