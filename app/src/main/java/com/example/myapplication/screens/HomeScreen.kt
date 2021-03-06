package com.example.myapplication.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import androidx.compose.runtime.*
import com.example.myapplication.data.category.impl.CategoryRepositoryImpl
import kotlinx.coroutines.withContext
import timber.log.Timber


@Composable
fun HomeScreenComposable(

) {


    val categoryResponse = remember {
        CategoryRepositoryImpl()
    }

    LaunchedEffect(Unit){
        categoryResponse.getBlogCategorys()
    }


    val data = categoryResponse.observeCategory().collectAsState(initial = emptyList()).value

    Timber.d("$data")

    Scaffold(
        topBar = { SearchAppbar(repositoryImpl = categoryResponse) }
    ) {
        Text(text = "首页")
    }
}


// 顶部搜索栏
@Composable
fun SearchAppbar(repositoryImpl: CategoryRepositoryImpl) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.width(width = 12.dp))
        Icon(
            painter = painterResource(id = R.drawable.svg_diandian), contentDescription = null,
            modifier = Modifier.size(45.dp, 45.dp),
            tint = Color.Black
        )
        Row(modifier = Modifier.weight(1f)) {
            Box(modifier = Modifier.padding(horizontal = 5.dp,vertical = 5.dp)) {
                TextField(
                    value = "",
                    onValueChange = {
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color.LightGray, CircleShape),
                    label = {
                        Text(text = "请输入搜索内容,比如辣条")
                    }
                )
            }
        }
    }
}


@Preview()
@Composable
fun TodoScreenPreview() {
    SearchAppbar(repositoryImpl = CategoryRepositoryImpl())
}