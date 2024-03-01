package com.example.hilowgamecompositionnavigationdemo.screen.help

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HelpScreen(
    helpText: String = "Use the app well",
) {
    Text(text = helpText)
}