package com.example.myapplication.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

/// 屏幕元数据
enum class AllScreen(
    val icon: ImageVector,
    val body: @Composable ((String) -> Unit) -> Unit
) {


    // 首页
    HomeScreen(
        icon = Icons.Filled.Home,
        body = {
            HomeScreenComposable()
        }
    ),

    // 九块九包邮页面
    NineNineScreen(
        icon = Icons.Filled.Edit,
        body = {
            NineNineScreenComposable()
        }
    );


    // 页面切换方法

    @Composable
    fun Content(currentChange: (String) -> Unit) {
        body(currentChange)
    }


}