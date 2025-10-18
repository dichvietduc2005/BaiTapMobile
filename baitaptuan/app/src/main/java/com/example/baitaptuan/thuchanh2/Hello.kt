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
import java.nio.file.WatchEvent

class Hello : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BaitaptuanTheme {
                HelloScreen()
            }
        }
    }
}
@Composable
fun HelloScreen(){
    var nameText by remember { mutableStateOf("Hello") }
    var nameColor by remember { mutableStateOf(Color.Red) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Text("My First App")

        Spacer(modifier = Modifier.height(50.dp))

        Text(text=nameText, color = nameColor)
        Spacer(modifier = Modifier.height(100.dp))
        Button(
            onClick = {
                nameText="Duc"
                nameColor=Color.Blue
            }
        ) {
            Text("Say Hi!!")
        }
    }

}



@Preview(showBackground = true)
@Composable
fun HelloScreenPreview() {
    BaitaptuanTheme {
        HelloScreen()
    }
}