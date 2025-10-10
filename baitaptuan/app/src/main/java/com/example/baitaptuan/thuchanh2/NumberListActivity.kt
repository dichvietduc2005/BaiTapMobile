package com.example.baitaptuan.thuchanh2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.baitaptuan.thuchanh2.ui.theme.BaitaptuanTheme

class NumberListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BaitaptuanTheme {
                NumberScreen()
            }
        }
    }
}
@Composable
fun NumberScreen() {
        var inputValue by remember { mutableStateOf("")}
        var listNumbers by remember { mutableStateOf(listOf<Int>())}
        var errorMessenger by remember {mutableStateOf("")}

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
                onValueChange = { inputValue = it },
                label = { Text("Nhập vào 1 số") }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    val number = inputValue.toIntOrNull()
                    if(number != null){
                        errorMessenger = ""
                        listNumbers=(1..number).toList()
                    }else{
                        errorMessenger="Dữ liệu nhập không hợp lệ"
                        listNumbers= emptyList()
                    }
                },
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Tạo")
            }
            Spacer(modifier = Modifier.height(16.dp))
            if (errorMessenger.isNotEmpty()) {
                Text(errorMessenger, color = Color.Red)
            }
            listNumbers.forEach { num ->
                Text(
                    text = num.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .background(Color.Red)
                        .padding(8.dp),
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
@Preview(showBackground = true)
@Composable
fun NumberScreenPreview() {
    BaitaptuanTheme {
        NumberScreen()
    }
}



