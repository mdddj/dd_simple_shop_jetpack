package com.example.myapplication.data.category.impl

import com.google.gson.Gson

// 分类的数据模型类

typealias Categorys = ArrayList<CategoryElement>

data class CategoryElement (
    val cname: String,
    val cpic: String,
    val subcategories: List<Subcategory>,
    val cid: Long
)

data class Subcategory (
    val subcid: Long,
    val scpic: String,
    val subcname: String
)
