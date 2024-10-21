package com.example.mygame_amaurysdm.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.mygame_amaurysdm.model.UserBag
import com.example.mygame_amaurysdm.navigation.UserCreationDestinations
import com.example.mygame_amaurysdm.screens.usercreation.LoginScreen

data class LoginData(var email: String, var password: String)

@Composable
fun Login(modifier: Modifier, navController: NavHostController) {
    var loginData by remember { mutableStateOf(LoginData("", "")) }
    LoginScreen(
        loginData = loginData,
        onLoginChange = { newLoginData -> loginData = newLoginData },
        onCreateAccountClick = {
            navController.navigate(UserCreationDestinations.REGISTER) {
                popUpTo(navController.graph.startDestinationId) {
                    inclusive = true
                }
            }
        },
        onLoginClick = {
            if (checkLogin(loginData)) {
                navController.navigate(UserCreationDestinations.HOME) {
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = true
                    }
                }
            }
        }
    )
}

fun checkLogin(loginData: LoginData): Boolean {
    val user = UserBag.getUser { it.email == loginData.email && it.password == loginData.password }
    if (user.isNotEmpty()) {
        UserBag.setCurrent(user[0])
        return true;
    }

    return false;
}