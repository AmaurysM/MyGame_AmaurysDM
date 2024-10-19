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
import com.example.mygame_amaurysdm.viewmodel.Login
import com.example.mygame_amaurysdm.viewmodel.Register

@Preview(showBackground = true)
@Composable
fun UserCreationNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = "register",
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
    ) {

        composable(route = "login") {
            Login(
                modifier = modifier, navController = navController
            )
        }

        composable(route = "register") {
            Register(
                modifier = modifier, navController = navController
            )
        }

        composable(route = "home") {
            val innerViewNavController = rememberNavController()
            HomeScreen(
                modifier = modifier,
                navController = innerViewNavController,
                userPicClick = { innerViewNavController.navigate("settings_Screen") },
                onLogoClick = { innerViewNavController.navigate("intro_Screen") }
            )
        }
    }
}