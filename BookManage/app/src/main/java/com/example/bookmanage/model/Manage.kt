package com.example.bookmanage.model

import androidx.compose.runtime.mutableStateListOf

class Manager {
    private val books = mutableStateListOf<Book>()
    private val students = mutableStateListOf<Student>()

    fun addBook(book: Book) = books.add(book)
    fun addStudent(student: Student) = students.add(student)

    fun getStudents() = students
    fun getBooks() = books

    fun getStudentByName(name: String): Student? {
        return students.find { it.name == name }
    }
}
