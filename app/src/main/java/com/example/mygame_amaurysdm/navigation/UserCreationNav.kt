package com.example.mygame_amaurysdm.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mygame_amaurysdm.model.RegisterData
import com.example.mygame_amaurysdm.model.LoginData
import com.example.mygame_amaurysdm.model.checkLogin
import com.example.mygame_amaurysdm.model.checkRegister
import com.example.mygame_amaurysdm.screens.HomeScreen
import com.example.mygame_amaurysdm.screens.usercreation.LoginScreen
import com.example.mygame_amaurysdm.screens.usercreation.RegisterScreen

@Preview(showBackground = true)
@Composable
fun UserCreationNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    var loginData by remember { mutableStateOf(LoginData("", "")) }
    var registerData by remember { mutableStateOf(RegisterData("", "", "")) }

    NavHost(
        navController = navController,
        startDestination = "register",
        modifier = modifier
    ) {


        composable(route = "login") {
            LoginScreen(
                loginData = loginData,
                onLoginChange = { newLoginData -> loginData = newLoginData },
                onCreateAccountClick = {
                    navController.navigate("register") {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                    }
                                       },
                onLoginClick = {
                    if (checkLogin(loginData)) {
                        navController.navigate("home") {
                            popUpTo(navController.graph.startDestinationId) {
                                inclusive = true
                            }
                        }
                    }
                }
            )
        }

        composable(route = "register") {
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

        composable(route = "home") {
            HomeScreen()
        }


    }
}