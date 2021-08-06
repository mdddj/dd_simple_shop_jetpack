package com.example.myapplication.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {

    private val _todoItems = MutableLiveData<List<TodoItem>>(listOf<TodoItem>())
    val todoItems: LiveData<List<TodoItem>> = _todoItems
    fun addItem(item: TodoItem) {

    }

    fun removeItem(item: TodoItem) {

    }

}

data class TodoItem(
    private val item: String,
    private val id: Int
)