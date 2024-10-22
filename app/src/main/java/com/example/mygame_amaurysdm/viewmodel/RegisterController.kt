package com.example.mygame_amaurysdm.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.mygame_amaurysdm.model.User
import com.example.mygame_amaurysdm.model.UserBag
import com.example.mygame_amaurysdm.screens.usercreation.RegisterScreen
import com.example.mygame_amaurysdm.screens.usercreation.Step1
import com.example.mygame_amaurysdm.screens.usercreation.Step2

data class RegisterData(var username: String, var email: String, var password: String, var firstName: String, var lastName: String, var dateOfBirth: String)

@Composable
fun Register(modifier: Modifier, navController: NavHostController) {
    var registerData by remember { mutableStateOf(RegisterData("", "", "", "", "", "")) }
    val accountStep = remember { mutableIntStateOf(1) }
    val onRegistrationChange: (RegisterData) -> Unit = { newRegisterData -> registerData = newRegisterData }
    val onBackButtonClick: () -> Unit = { navController.popBackStack() }
    val onCreateAccountClick: () -> Unit = {
        if (checkRegister(registerData)) {
            navController.navigate("home") {
                popUpTo(navController.graph.startDestinationId) {
                    inclusive = true
                }
            }
        }
    }

    RegisterScreen(
         onLoginClick = { navController.navigate("login") }
        , accountStep = accountStep
        , userCreationState = {
            when (accountStep.intValue) {
                1 -> Step1(
                    registerData
                    , onRegistrationChange
                    , onBackButtonClick
                    , accountStep
                )

                2 -> Step2(
                    registerData,
                    onRegistrationChange,
                    onCreateAccountClick,
                    accountStep
                )
            }
        }
    )

}
fun checkEmailPassword(email: String, password: String): Boolean {
    if (email != "" && password != "" && password.length >= 8) {
        return true;
    }
    return false;
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
        val user = User(registerData.username, registerData.email, password = registerData.password, registerData.firstName, registerData.lastName, registerData.dateOfBirth)
        UserBag.addUser(user)
        UserBag.setCurrent(user)
        return true;
    }
}