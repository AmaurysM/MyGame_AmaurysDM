package com.example.mygame_amaurysdm.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mygame_amaurysdm.screens.IntroScreen
import com.example.mygame_amaurysdm.screens.Quiz

@Composable
fun QuizNav(modifier: Modifier = Modifier,navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController
        , startDestination = "intro_Screen"
    ){
        composable(route = "intro_Screen") {
            IntroScreen(modifier = modifier, navController = navController)
        }

        composable(route = "game_Screen") {
            Quiz(modifier = modifier, navController = navController)
        }
    }
}