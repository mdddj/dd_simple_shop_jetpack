package com.example.myapplication.util

/**
 * 和服务器数据返回的数据相匹配
 */
sealed class Result<T>(
    private val data: T,
    private val state: Int,
    private val message: String
)