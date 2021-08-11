package com.example.myapplication.util

/**
 * 和服务器数据返回的数据相匹配
 */
sealed class MyResponseResult<T>(
    private val data: T,
    private val state: Int,
    private val message: String
) {
    /**
     * 服务器状态码是否正确
     */
    fun isSuccess(): Boolean {
        return state == 200
    }

    val getData get() = data
}