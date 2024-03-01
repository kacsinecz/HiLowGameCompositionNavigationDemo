package com.example.hilowgamecompositionnavigationdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.hilowgamecompositionnavigationdemo.screen.about.AboutScreen
import com.example.hilowgamecompositionnavigationdemo.screen.game.GameScreen
import com.example.hilowgamecompositionnavigationdemo.screen.help.HelpScreen
import com.example.hilowgamecompositionnavigationdemo.screen.mainmenu.MainMenuScreen
import com.example.hilowgamecompositionnavigationdemo.ui.theme.HiLowGameCompositionNavigationDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HiLowGameCompositionNavigationDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyAppNavHost()
                }
            }
        }
    }
}

@Composable
fun MyAppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = "mainmenuscreen"
) {
    NavHost(navController = navController, startDestination = startDestination ) {
        composable("mainmenuscreen") {
            MainMenuScreen(
                onNavigateToGame = {navController.navigate("gamescreen?upperBound=20")},
                onNavigateToHelp = {navController.navigate("helpscreen/this is the help text")},
                navController)
        }

        composable("gamescreen?upperBound={upperBound}",
            arguments = listOf(navArgument("upperBound"){
                defaultValue = 10
                type = NavType.IntType})) {
            GameScreen(
                onNavigateToMainMenu = {navController.navigate("mainmenuscreen")}
            )
        }

        composable("aboutscreen") {
            AboutScreen(
                onNavigateToMainMenu = {navController.navigate("mainmenuscreen")}
            )
        }

        composable("helpscreen/{helptext}",
            arguments = listOf(navArgument("helptext"){
                type = NavType.StringType})
        ) {
            navBackStackEntry -> val text = navBackStackEntry.arguments?.getString("helptext")

            text?.let {
                HelpScreen(
                    text,
                    onNavigateToMainMenu = {navController.navigate("mainmenuscreen")}
                )
            }
        }
    }
}