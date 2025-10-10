package com.example.baitaptuan.thuchanh2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.baitaptuan.thuchanh2.ui.theme.BaitaptuanTheme

class EmailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BaitaptuanTheme {
                EmailScreen()
            }
        }
    }
}
@Composable
fun EmailScreen() {
    var inputValue by remember { mutableStateOf("") }
    var errorMessenger by remember { mutableStateOf("") }
    var messenger by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        TextField(
            value = inputValue,
            onValueChange = {inputValue=it},
            label = {Text("Nhập Email")}
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                val email: String? = inputValue.ifBlank { null }
                if(email.isNullOrEmpty()){
                    errorMessenger="Email Không Hợp Lệ"
                    messenger=""
                }
                else if('@' !in email){
                    errorMessenger="Email Không đúng định dạng"
                    messenger=""
                }
                else{
                    errorMessenger=""
                    messenger="Bạn đã nhập email hợp lệ"
                }

            }
        ) {
            Text("Kiểm Tra")
        }
        Spacer(modifier = Modifier.height(12.dp))

        if(messenger.isNotEmpty()){
            Text(messenger, color = Color.Green)
        }
        if(errorMessenger.isNotEmpty()){
            Text(errorMessenger, color = Color.Red)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun EmailScreenPreview() {
    BaitaptuanTheme {
        EmailScreen()
    }
}