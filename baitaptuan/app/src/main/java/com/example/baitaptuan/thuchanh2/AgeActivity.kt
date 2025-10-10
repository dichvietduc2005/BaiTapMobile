package com.example.baitaptuan.thuchanh2

import android.R.attr.label
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
import androidx.compose.material3.ButtonColors
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

class AgeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BaitaptuanTheme {
                AgeScreen()
            }
        }
    }
}

@Composable
fun AgeScreen(){
    var nameValue by remember { mutableStateOf("") }
    var ageValue by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("THỰC HÀNH 01")
        TextField(
            value = nameValue,
            onValueChange = {nameValue=it},
            label = {Text("Họ Và tên")}
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = ageValue,
            onValueChange = {ageValue=it},
            label = {Text("Tuổi")}
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick ={
                val number = ageValue.toIntOrNull()
                if(number != null){
                    errorMessage=""
                    if(number > 65){
                        message="Người Già"
                    }
                    else if(number >6 && number <=65){
                        message = "Người Lớn"
                    }
                    else if(number >=2 && number <=6){
                        message = "Trẻ em"
                    }
                    else{
                        message="Em Bé"
                    }
                }else{
                    errorMessage ="Vui Lòng Nhập Số"
                    message=""
                }
            }
        )
        {
            Text("Kiểm tra")
        }
        Spacer(modifier = Modifier.height(12.dp))
        if(errorMessage.isNotEmpty()){
            Text(errorMessage, color = Color.Red)
        }
        if(message.isNotEmpty()){
            Text(nameValue+" "+message)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun AgeScreenPreview() {
    BaitaptuanTheme {
        AgeScreen()
    }
}