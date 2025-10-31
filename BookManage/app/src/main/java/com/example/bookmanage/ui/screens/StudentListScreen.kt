package com.example.bookmanage.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import com.example.bookmanage.model.Manager
import com.example.bookmanage.model.Student

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentListScreen(manager: Manager) {
    val students = remember { manager.getStudents() }
    var newStudentName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            " Danh sách Sinh viên",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = newStudentName,
                onValueChange = { newStudentName = it },
                label = { Text("Nhập tên sinh viên") },
                modifier = Modifier.weight(1f)
            )

            Spacer(Modifier.width(8.dp))

            Button(
                onClick = {
                    if (newStudentName.isNotBlank()) {
                        val newId = (students.maxOfOrNull { it.id } ?: 0) + 1
                        manager.addStudent(Student(newId, newStudentName))
                        newStudentName = ""
                    }
                }
            ) {
                Text("Thêm")
            }
        }

        Spacer(Modifier.height(24.dp))

        Divider()

        Spacer(Modifier.height(8.dp))


        if (students.isEmpty()) {
            Text("Chưa có sinh viên nào trong hệ thống.")
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(students) { student ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 4.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = " ${student.name}",
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                text = "ID: ${student.id}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }
        }
    }
}
