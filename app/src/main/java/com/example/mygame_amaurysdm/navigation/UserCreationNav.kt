package com.example.mygame_amaurysdm.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mygame_amaurysdm.screens.HomeScreen
import com.example.mygame_amaurysdm.screens.SplashScreen
import com.example.mygame_amaurysdm.screens.usercreation.OptionScreen
import com.example.mygame_amaurysdm.viewmodel.Login
import com.example.mygame_amaurysdm.viewmodel.Register

object UserCreationDestinations {
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val HOME = "home"
    const val INTRO_OPTION = "Option_Screen"
    const val SPLASH = "splash"
}

@Preview(showBackground = true)
@Composable
fun UserCreationNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = UserCreationDestinations.SPLASH,
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
    ) {

        composable(UserCreationDestinations.SPLASH) {
            SplashScreen(navController)
        }
        composable(UserCreationDestinations.INTRO_OPTION) {
            OptionScreen(
                registerButton = {
                    travelAndPopUp(
                        navController
                        , UserCreationDestinations.REGISTER
                        , UserCreationDestinations.INTRO_OPTION
                    )
                },
                loginButton = {
                    travelAndPopUp(
                        navController
                        , UserCreationDestinations.LOGIN
                        , UserCreationDestinations.INTRO_OPTION
                    )
                }
            )
        }

        composable(UserCreationDestinations.LOGIN) {
            Login(
                modifier = modifier, navController = navController
            )
        }

        composable(UserCreationDestinations.REGISTER) {
            Register(
                modifier = modifier, navController = navController
            )
        }

        composable(UserCreationDestinations.HOME) {
            val innerViewNavController = rememberNavController()
            HomeScreen(
                modifier = modifier,
                navController = innerViewNavController,
                userPicClick = {
                    travelAndPopUp(
                        innerViewNavController
                        , QuizDestinations.SETTINGS
                        , innerViewNavController.graph.startDestinationId.toString()
                    )
                },
                onLogoClick = {
                    travelAndPopUp(
                        innerViewNavController
                        , QuizDestinations.INTRO
                        , innerViewNavController.graph.startDestinationId.toString()
                    )
                }
            )
        }
    }
}

fun travelAndPopUp(navController: NavHostController, route: String, popUp: String) {
    navController.navigate(route) {
        launchSingleTop = true
        popUpTo(popUp) { inclusive = false }
    }
}

