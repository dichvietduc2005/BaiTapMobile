package com.example.baitaptuan.thuchanh2


import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.baitaptuan.thuchanh2.ui.theme.BaitaptuanTheme
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UIScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("UI Components List", color = Color.Blue) }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("UI Components List", color = Color.Blue)

            Spacer(modifier = Modifier.height(16.dp))

            Text("Display", modifier = Modifier.align(Alignment.Start).padding(start = 6.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Blue) ,
                onClick = { navController.navigate("text_detail") }
            )
             {
                Column(
                    modifier = Modifier.padding(12.dp)
                ) {
                    Text(
                        text = "Text",
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "Displays text")
                }

            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Blue),
                onClick= { navController.navigate(route = "image")}
            ) {
                Column(
                    modifier = Modifier.padding(12.dp)
                ) {
                    Text(
                        text = "Image",
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "Displays an image")
                }

            }
            Text("Input", modifier = Modifier.align(Alignment.Start).padding(start = 6.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Blue),
                onClick ={navController.navigate(route="text_field")}
            ) {
                Column(
                    modifier = Modifier.padding(12.dp)
                ) {
                    Text(
                        text = "Text Field",
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "Input field for text")
                }

            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Blue),
                onClick = {navController.navigate("pass_word")}
            ) {
                Column(
                    modifier = Modifier.padding(12.dp)
                ) {
                    Text(
                        text = "PasswordField",
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "Input field for Password")
                }
            }
            Text("Layout", modifier = Modifier.align(Alignment.Start).padding(start = 6.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Blue),
                onClick = {navController.navigate(route = "row_layout")}
            ) {
                Column(
                    modifier = Modifier.padding(12.dp) // canh lề trong cho cả nhóm Text
                ) {
                    Text(
                        text = "Row",
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "Input field for text")
                }

            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Blue)
            ) {
                Column(
                    modifier = Modifier.padding(12.dp)
                ) {
                    Text(
                        text = "Column",
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "Input field for Password")
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Red)
            ) {
                Column(
                    modifier = Modifier.padding(12.dp)
                ) {
                    Text(
                        text = "Tự Tìm Hiểu",
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "Input field for Password")
                }
            }

        }

    }
}
@Preview(showBackground = true)
@Composable
fun UIScreenPreview() {
    BaitaptuanTheme {
        UIScreen(navController= rememberNavController())
    }
}