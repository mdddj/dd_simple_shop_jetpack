package com.example.myapplication.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.category.impl.Category

/**
 * 超级大分类的view-model
 */
class CategoryViewModel : ViewModel() {

    /**
     * 分类集合
     */
    val categorys: MutableLiveData<List<Category>> by lazy {
        MutableLiveData<List<Category>>()
    }
}