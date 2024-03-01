package com.example.hilowgamecompositionnavigationdemo.screen.about

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AboutScreen(
    aboutText: String = "Demo app for Jetpack Compose",
    userId: Int = 0,
    onNavigateToMainMenu:() -> Unit
) {
    Column {
        Text(text = "$aboutText, userId: $userId")
        Button(onClick = onNavigateToMainMenu) {
            Text(text = "Main menu")
        }
    }
}
