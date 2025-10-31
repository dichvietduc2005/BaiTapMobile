package com.example.smarttasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.smarttasks.ViewModel.AuthViewModel
import com.example.smarttasks.navigation.Nav
import com.example.smarttasks.ui.theme.SmartTasksTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartTasksTheme {
                Surface(modifier = Modifier,color = MaterialTheme.colorScheme.background) {
                    MainApp()
                }
            }
        }
    }
}

@Composable
fun MainApp() {
    // ✅ Khởi tạo navController và viewModel bên trong Compose
    val navController = rememberNavController()
    val viewModel: AuthViewModel = viewModel()

    // ✅ Truyền đúng 2 tham số bắt buộc cho Nav
    Nav(navController = navController, viewModel = viewModel)
}
