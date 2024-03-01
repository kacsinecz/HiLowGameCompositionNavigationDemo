package com.example.hilowgamecompositionnavigationdemo.screen.help

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HelpScreen(
    helpText: String = "Use the app well",
    onNavigateToMainMenu:() -> Unit
) {
    Column {
        Text(text = helpText)
        Button(onClick = onNavigateToMainMenu) {
            Text(text = "Main menu")
        }
    }

}