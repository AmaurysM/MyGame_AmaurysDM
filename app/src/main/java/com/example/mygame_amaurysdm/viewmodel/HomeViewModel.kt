package com.example.mygame_amaurysdm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mygame_amaurysdm.navigation.QuizDestinations
import com.example.mygame_amaurysdm.navigation.travelAndPopUp

class HomeViewModel: ViewModel() {

    val userPicClicked: (navController: NavHostController) -> Unit = { navController ->
        navController.navigate(QuizDestinations.SETTINGS) {
            popUpTo(navController.graph.startDestinationId) { inclusive = false }
        }
    }

    val logoClicked: (navController: NavHostController) -> Unit = { navController ->
        navController.navigate(QuizDestinations.INTRO) {
            popUpTo(navController.graph.startDestinationId) { inclusive = false }
        }
    }
}