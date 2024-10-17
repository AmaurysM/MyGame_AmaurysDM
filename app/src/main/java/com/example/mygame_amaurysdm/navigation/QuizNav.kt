package com.example.mygame_amaurysdm.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mygame_amaurysdm.model.Quiz
import com.example.mygame_amaurysdm.model.UserBag
import com.example.mygame_amaurysdm.model.defaultQuiz
import com.example.mygame_amaurysdm.screens.SettingsScreen
import com.example.mygame_amaurysdm.screens.quiz.IntroScreen
import com.example.mygame_amaurysdm.screens.quiz.QuizGameScreen
import com.example.mygame_amaurysdm.screens.quiz.ResultScreen


@Composable
fun QuizNav(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = "intro_Screen"
    ) {

        composable(route = "intro_Screen") {
            IntroScreen(modifier = modifier, navController = navController)
        }

        composable(route = "game_Screen") {
            QuizGameScreen(modifier = modifier, navController = navController)
        }

        composable(route = "result_Screen") {

            ResultScreen(modifier = modifier, navController = navController)
        }

        composable(route = "settings_Screen") {
            SettingsScreen(modifier = modifier, navController = navController)
        }
    }
}
