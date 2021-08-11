package com.example.myapplication.data.category.impl


/**
 * 超级大分类
 */
data class Category (
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
