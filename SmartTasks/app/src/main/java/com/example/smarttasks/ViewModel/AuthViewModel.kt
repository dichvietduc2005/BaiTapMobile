package com.example.smarttasks.ViewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {
    var email by mutableStateOf("")
    var code by mutableStateOf("")
    var password by mutableStateOf("")
}