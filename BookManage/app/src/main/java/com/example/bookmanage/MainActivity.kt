package com.example.bookmanage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

import com.example.bookmanage.model.*
import com.example.bookmanage.ui.LibraryScreen
import com.example.bookmanage.ui.components.NavBar
import com.example.bookmanage.ui.screens.BookListScreen
import com.example.bookmanage.ui.screens.StudentListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibraryApp()
        }
    }
}

@Composable
fun LibraryApp() {
    val manager = remember { Manager() }
    var selectedTab by remember { mutableStateOf(0) }

    // Dữ liệu mẫu
    LaunchedEffect(Unit) {
        manager.addBook(Book(1, "Sách 01"))
        manager.addBook(Book(2, "Sách 02"))
        manager.addStudent(Student(1, "Nguyen Van A"))
        manager.addStudent(Student(2, "Nguyen Thi B"))
        manager.addStudent(Student(3, "Nguyen Van C"))
    }

    Scaffold(
        bottomBar = {
            NavBar(
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it }
            )
        }
    ) { padding ->
        Surface(modifier = Modifier.padding(padding)) {
            when (selectedTab) {
                0 -> LibraryScreen(manager)
                1 -> BookListScreen(manager)
                2 -> StudentListScreen(manager)
            }
        }
    }
}
