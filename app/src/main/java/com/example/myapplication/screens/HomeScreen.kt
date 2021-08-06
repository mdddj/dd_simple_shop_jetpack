package com.example.myapplication.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.models.TodoViewModel


@Composable
fun HomeScreenComposable() {
    Scaffold(
        topBar = { SearchAppbar() }
    ) {
        Text(text = "首页")
    }
}


// 顶部搜索栏
@Composable
fun SearchAppbar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = Icons.Filled.Home, contentDescription = "典典的小卖部")
        Row(modifier = Modifier.weight(1f)) {
            Box(modifier = Modifier.padding(16.dp)) {
                TextField(
                    value = "", onValueChange = {}, colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color.LightGray, CircleShape)
                )
            }
        }
    }
}


@Preview()
@Composable
fun TodoScreenPreview() {
    SearchAppbar()
}