package com.example.mygame_amaurysdm

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
import com.example.mygame_amaurysdm.screens.LoginScreen
import com.example.mygame_amaurysdm.screens.RegisterScreen

@Preview(showBackground = true)
@Composable
fun GameNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "register",
        modifier = modifier
    ) {


        composable(route = "login") {
            var loginData by remember { mutableStateOf(LoginData("", "")) }
            LoginScreen(
                loginData = loginData,
                onLoginChange = { newLoginData -> loginData = newLoginData },
                onCreateAccountClick = { navController.navigate("register") },
                onLoginClick = {
                    if (checkLogin(loginData)) {
                        navController.navigate("game") {
                            popUpTo(navController.graph.startDestinationId) {
                                inclusive = true
                            }
                        }
                    }
                }
            )
        }

        composable(route = "register") {
            var registerData by remember { mutableStateOf(RegisterData("", "", "")) }
            RegisterScreen(
                registrationData = registerData,
                onRegistrationChange = { newRegisterData -> registerData = newRegisterData },
                onCreateAccountClick = {
                    if (checkRegister(registerData)) {
                        navController.navigate("game") {
                            popUpTo(navController.graph.startDestinationId) {
                                inclusive = true
                            }
                        }
                    }
                },
                onLoginClick = { navController.navigate("login") }
            )
        }

        composable(route = "game") {
            HomeScreen()
        }


    }
}