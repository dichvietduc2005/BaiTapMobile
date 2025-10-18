package com.example.baitaptuan.thuchanh2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.baitaptuan.R
import com.example.baitaptuan.thuchanh2.ui.theme.BaitaptuanTheme




@Composable
fun DesignScreen(navController: NavHostController){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(R.drawable.uth),
            contentDescription = "Icon",
            modifier = Modifier
                .size(180.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(100.dp))
        Text("Jetpack Compose")
        Spacer(modifier = Modifier.height(25.dp))
        Text("Jetpack Compose is the modern UI tool kit for building...")
        Spacer(modifier = Modifier.height(200.dp))

        Button(
            onClick ={navController.navigate("ui_components")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp)

        ) {
            Text("Im Ready")

        }
    }
}


@Preview(showBackground = true)
@Composable
fun DesignScreenPreview() {
    BaitaptuanTheme {
        DesignScreen(navController= rememberNavController())
    }
}