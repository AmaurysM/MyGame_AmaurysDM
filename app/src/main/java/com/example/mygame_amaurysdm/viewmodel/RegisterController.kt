package com.example.mygame_amaurysdm.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.mygame_amaurysdm.model.User
import com.example.mygame_amaurysdm.model.UserBag
import com.example.mygame_amaurysdm.screens.usercreation.RegisterScreen

data class RegisterData(var username: String, var email: String, var password: String)

@Composable
fun Register(modifier: Modifier, navController: NavHostController) {
    var registerData by remember { mutableStateOf(RegisterData("", "", "")) }
    RegisterScreen(
        registrationData = registerData,
        onRegistrationChange = { newRegisterData -> registerData = newRegisterData },
        onCreateAccountClick = {
            if (checkRegister(registerData)) {
                navController.navigate("home") {
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = true
                    }
                }
            }
        },
        onLoginClick = { navController.navigate("login") }
    )

}

fun checkRegister(registerData: RegisterData): Boolean {
    if (registerData.username.isEmpty() || registerData.email.isEmpty() || registerData.password.isEmpty()) {
        return false;
    } else if (registerData.password.length < 8) {
        return false;
    } else if (UserBag.getUser { it.email == registerData.email }.isNotEmpty()) {
        return false;
    } else if (UserBag.getUser { it.username == registerData.username }.isNotEmpty()) {
        return false;
    } else {
        val user = User(registerData.username, registerData.email, password = registerData.password)
        UserBag.addUser(user)
        UserBag.setCurrent(user)
        return true;
    }
}