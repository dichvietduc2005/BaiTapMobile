package com.example.bookmanage.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun NavBar(selectedTab: Int, onTabSelected: (Int) -> Unit) {
    val tabs = listOf(
        "Quản lý" to Icons.Default.Home,
        "DS Sách" to Icons.Default.List,
        "Sinh viên" to Icons.Default.Person
    )

    NavigationBar {
        tabs.forEachIndexed { index, (label, icon) ->
            NavigationBarItem(
                selected = selectedTab == index,
                onClick = { onTabSelected(index) },
                icon = { Icon(icon, contentDescription = label) },
                label = { Text(label) }
            )
        }
    }
}
