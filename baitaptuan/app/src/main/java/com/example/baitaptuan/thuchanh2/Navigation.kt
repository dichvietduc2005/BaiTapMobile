package com.example.baitaptuan.thuchanh2

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Navigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("welcome") { DesignScreen(navController) }
        composable("ui_components") { UIScreen(navController) }
        composable("text_detail") { TextDetail(navController) }
        composable("image") { ImageScreen(navController) }
        composable("text_field") { TextField(navController) }
        composable("row_layout") { RowLayout(navController) }
        composable("pass_word") { Password(navController) }

    }
}
