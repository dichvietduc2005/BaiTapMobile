package com.example.bookmanage.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bookmanage.model.*

@Composable
fun LibraryScreen(manager: Manager) {
    var selectedStudentName by remember { mutableStateOf("Nguyen Van A") }
    var isAddingMode by remember { mutableStateOf(false) }
    val currentStudent = manager.getStudentByName(selectedStudentName)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Hệ thống Quản lý Thư viện", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))


        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = selectedStudentName,
                onValueChange = { selectedStudentName = it },
                label = { Text("Tên sinh viên") },
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(Modifier.height(16.dp))

        currentStudent?.let { student ->
            if (student.borrowedBooks.isEmpty() && !isAddingMode) {
                Text("${student.name} chưa mượn sách nào.")
                Spacer(Modifier.height(8.dp))
                Button(onClick = { isAddingMode = true }) {
                    Text("Thêm")

                }
            } else if (isAddingMode) {
                Text("Chọn sách để mượn")
                Spacer(Modifier.height(8.dp))
                LazyColumn {
                    items(manager.getBooks()) { book ->
                        val alreadyBorrowed = student.borrowedBooks.contains(book)
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp)
                        ) {
                            Checkbox(
                                checked = alreadyBorrowed,
                                onCheckedChange = { checked ->
                                    if (checked) student.borrowBook(book)
                                    else student.returnBook(book)
                                }
                            )
                            Text(book.title)
                        }
                    }
                }
                Spacer(Modifier.height(16.dp))
                Button(onClick = { isAddingMode = false }) {
                    Text("Xong")
                }
            } else {
                Text("Danh sách sách ${student.name} đã mượn:")
                Spacer(Modifier.height(8.dp))
                LazyColumn {
                    items(student.borrowedBooks) { book ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp)
                        ) {
                            Checkbox(
                                checked = true,
                                onCheckedChange = { checked ->
                                    if (!checked) student.returnBook(book)
                                }
                            )
                            Text(book.title)
                        }
                    }
                }
                Spacer(Modifier.height(16.dp))
                Button(onClick = { isAddingMode = true }) {
                    Text("Thêm sách khác")
                }
            }
        } ?: Text("Không tìm thấy sinh viên")
    }
}
