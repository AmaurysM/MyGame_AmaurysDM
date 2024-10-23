package com.example.mygame_amaurysdm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.mygame_amaurysdm.navigation.UserCreationDestinations

class IntroOptionsViewModel: ViewModel() {

    val register: (navController: NavHostController) -> Unit = { navController ->
        navController.navigate(UserCreationDestinations.REGISTER) {
            launchSingleTop = true
            popUpTo(navController.graph.id) { inclusive = false }
        }
    }

    val login: (navController: NavHostController) -> Unit = { navController ->
        navController.navigate(UserCreationDestinations.LOGIN) {
            launchSingleTop = true
            popUpTo(navController.graph.id) { inclusive = false }
        }
    }
}