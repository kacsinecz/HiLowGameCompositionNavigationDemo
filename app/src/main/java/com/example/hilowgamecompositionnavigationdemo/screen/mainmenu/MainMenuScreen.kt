package com.example.hilowgamecompositionnavigationdemo.screen.mainmenu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainMenuScreen(
    onNavigateToGame:() -> Unit,
    onNavigateToHelp:() -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedButton(
            modifier = Modifier.requiredWidth(200.dp) ,
            onClick = onNavigateToGame
        ) {
            Text(text = "Start")
        }

        OutlinedButton(
            modifier = Modifier.requiredWidth(200.dp) ,
            onClick = onNavigateToHelp
        ) {
            Text(text = "Help")
        }

        OutlinedButton(
            modifier = Modifier.requiredWidth(200.dp) ,
            onClick = {
                navController.navigate("aboutscreen")
            }
        ) {
            Text(text = "About")
        }
    }
}
