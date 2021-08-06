package com.example.myapplication.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.models.TodoViewModel



@Composable
fun HomeScreenComposable() {
    Scaffold {

        Text(text = "首页")
        
    }
}

@Preview()
@Composable
fun TodoScreenPreview() {
}