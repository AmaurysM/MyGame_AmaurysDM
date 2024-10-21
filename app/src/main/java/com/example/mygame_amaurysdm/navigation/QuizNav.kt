package com.example.mygame_amaurysdm.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mygame_amaurysdm.screens.SettingsScreen
import com.example.mygame_amaurysdm.screens.quiz.IntroScreen
import com.example.mygame_amaurysdm.screens.quiz.ResultScreen
import com.example.mygame_amaurysdm.viewmodel.Quiz

object QuizDestinations {
    const val INTRO = "intro_Screen"
    const val GAME = "game_Screen"
    const val RESULT = "result_Screen"
    const val SETTINGS = "settings_Screen"
}

@Composable
fun QuizNav(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        navController = navController
        , startDestination = QuizDestinations.INTRO
    ) {

        composable(route = QuizDestinations.INTRO) {
            IntroScreen(
                modifier = modifier
                , navController = navController)
        }

        composable(route = QuizDestinations.GAME) {
            Quiz(
                modifier = modifier
                , navController = navController,
            )
        }

        composable(route = QuizDestinations.RESULT) {

            ResultScreen(
                modifier = modifier
                , navController = navController
            )
        }

        composable(route = QuizDestinations.SETTINGS) {
            SettingsScreen(
                modifier = modifier
                , navController = navController
            )
        }
    }
}

