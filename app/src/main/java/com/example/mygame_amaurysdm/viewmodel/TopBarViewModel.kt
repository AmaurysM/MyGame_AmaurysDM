package com.example.mygame_amaurysdm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.mygame_amaurysdm.navigation.QuizDestinations

class TopBarViewModel: ViewModel() {

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