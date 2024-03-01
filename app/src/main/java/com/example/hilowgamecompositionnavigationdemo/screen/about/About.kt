package com.example.hilowgamecompositionnavigationdemo.screen.about

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AboutScreen(
    aboutText: String = "Demo app for Jetpack Compose",
    userId: Int = 0
) {
    Text(text = "$aboutText, userId: $userId")
}
