package com.example.smarttasks.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.smarttasks.ViewModel.AuthViewModel
import com.example.smarttasks.ui.screens.CompleteScreen
import com.example.smarttasks.ui.screens.ConfirmScreen
import com.example.smarttasks.ui.screens.ForgotPassword
import com.example.smarttasks.ui.screens.ResetPasswordScreen
import com.example.smarttasks.ui.screens.VerifyCodeScreen

@Composable
fun Nav(navController: NavHostController, viewModel: AuthViewModel) {
    NavHost(navController = navController, startDestination = "forgot_pass") {
        composable("forgot_pass") {
            ForgotPassword(
                viewModel = viewModel,
                onNext = { navController.navigate("verify") },
                onBack = {navController.popBackStack()}
            )
        }
        composable("verify") {
            VerifyCodeScreen (
                viewModel = viewModel,
                onNext = { navController.navigate("reset_pass") },
                onBack = {navController.popBackStack()}
            )
        }

        composable("reset_pass") {
            ResetPasswordScreen(
                viewModel = viewModel,
                onNext = { navController.navigate("comfirm") },
                onBack = {navController.popBackStack()}
            )
        }

        composable("comfirm") {
            ConfirmScreen(
                viewModel = viewModel,
                onNext = { navController.navigate("complete") },
                onBack = {navController.popBackStack()}
            )
        }

        composable("complete") {
            CompleteScreen(
                viewModel = viewModel,
                onNext = { navController.navigate("forgot_pass") }
            )
        }


    }
}