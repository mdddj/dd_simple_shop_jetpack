package com.example.myapplication.util

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * 服务器相关请求的封装实现
 *
 * 实现功能: 根据泛型动态创建相关services
 *
 * 使用object声明为单例类
 */
object BaseApiServiceCreate {

    private const val BASE_URL = "https://itbug.shop/"

    private val retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    inline fun <reified T> create(): T = create(T::class.java)
}

/**
 * 封装携程的异步等待操作
 * 等待异步携程的操作执行完毕将 T (实体) 返回
 */
suspend fun <T> Call<T>.await(): T {
    return suspendCoroutine { continuation ->
        enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                response.body()?.let { data ->
                    continuation.resume(data)
                }
            }
            override fun onFailure(call: Call<T>, t: Throwable) {
                continuation.resumeWithException(t)
            }

        })
    }
}