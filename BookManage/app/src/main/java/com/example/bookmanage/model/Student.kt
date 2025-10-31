package com.example.bookmanage.model

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

data class Student(
    val id:Int,
    val name:String,

) {
    val borrowedBooks = mutableStateListOf<Book>()
    fun borrowBook(book: Book) {
        if (!borrowedBooks.contains(book)) {
            borrowedBooks.add(book)
        }
    }

    fun returnBook(book: Book) {
        borrowedBooks.remove(book)
    }
}