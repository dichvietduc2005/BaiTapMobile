package com.example.bookmanage.model

data class Book(
    val id: Int,
    val title: String,
    var isBorrowed: Boolean = false
)
