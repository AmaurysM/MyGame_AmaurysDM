package com.example.mygame_amaurysdm.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mygame_amaurysdm.screens.SettingsScreen
import com.example.mygame_amaurysdm.screens.quiz.IntroScreen
import com.example.mygame_amaurysdm.screens.quiz.QuizGameScreen
import com.example.mygame_amaurysdm.screens.quiz.ResultScreen
import com.example.mygame_amaurysdm.viewmodel.Quiz


@Composable
fun QuizNav(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = "intro_Screen"
    ) {

        composable(route = "intro_Screen") {
            IntroScreen(modifier = modifier, navController = navController)
        }

        composable(route = "game_Screen") {
            Quiz(
                modifier = modifier,
                navController = navController,
            )
        }

        composable(route = "result_Screen") {

            ResultScreen(modifier = modifier, navController = navController)
        }

        composable(route = "settings_Screen") {
            SettingsScreen(modifier = modifier, navController = navController)
        }
    }
}
