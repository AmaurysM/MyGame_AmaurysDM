package com.example.mygame_amaurysdm.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.mygame_amaurysdm.model.UserBag
import com.example.mygame_amaurysdm.navigation.HomeDestinations
import com.example.mygame_amaurysdm.navigation.QuizDestinations
import com.example.mygame_amaurysdm.navigation.UserCreationDestinations

data class LoginData(var email: String, var password: String)

class LoginViewModel : ViewModel() {
    var loginData by mutableStateOf(LoginData("", ""))

    /*fun navigateToRegister(navController: NavHostController): () -> Unit {
        val nav = navController.navigate(UserCreationDestinations.REGISTER) {
            popUpTo(navController.graph.startDestinationId) {
                inclusive = true
            }
        }
        return { nav }
    }*/

    val navigateToRegister: (navController: NavHostController) -> Unit = { navController ->
        navController.navigate(UserCreationDestinations.REGISTER) {
            popUpTo(navController.graph.startDestinationId) {
                inclusive = true
            }
        }
    }

    val navigateToHome: (navController: NavHostController) -> Unit =
        { navController ->
            navController.navigate(HomeDestinations.HOME) {
                popUpTo(navController.graph.startDestinationId) {
                    inclusive = true
                }
            }
        }

    /*fun navigateToHome(navController: NavHostController, loginData: LoginData): () -> Unit {
        val nav = if (checkLogin(loginData)) {
            navController.navigate(UserCreationDestinations.HOME) {
                popUpTo(navController.graph.startDestinationId) {
                    inclusive = true
                }
            }
        } else {

        }
        return { nav }
    }*/

    fun checkLogin(loginData: LoginData): Boolean {
        val user =
            UserBag.getUser { it.email == loginData.email && it.password == loginData.password }
        if (user.isNotEmpty()) {
            UserBag.setCurrent(user[0])
            return true;
        }

        return false;
    }
}


