package com.example.mygame_amaurysdm.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.mygame_amaurysdm.screens.HomeScreen
import com.example.mygame_amaurysdm.screens.SettingsScreen
import com.example.mygame_amaurysdm.screens.SplashScreen
import com.example.mygame_amaurysdm.screens.quiz.IntroScreen
import com.example.mygame_amaurysdm.screens.quiz.ResultScreen
import com.example.mygame_amaurysdm.screens.usercreation.LoginScreen
import com.example.mygame_amaurysdm.screens.usercreation.OptionScreen
import com.example.mygame_amaurysdm.screens.usercreation.Registration.RegisterScreen
import com.example.mygame_amaurysdm.viewmodel.HomeViewModel
import com.example.mygame_amaurysdm.viewmodel.IntroOptionsViewModel
import com.example.mygame_amaurysdm.viewmodel.LoginViewModel
import com.example.mygame_amaurysdm.viewmodel.Quiz
import com.example.mygame_amaurysdm.viewmodel.Registration.RegisterViewModel

object UserCreationDestinations {
    const val ROUTE = "user_creation"

    const val LOGIN = "login"
    const val REGISTER = "register"

    const val INTRO_OPTION = "Option_Screen"
    const val SPLASH = "splash"
}

object HomeDestinations {
    const val HOME = "home"
}


@Preview(showBackground = true)
@Composable
fun UserCreationNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = UserCreationDestinations.ROUTE,
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
    ) {
        navigation(
            startDestination = UserCreationDestinations.SPLASH,
            route = UserCreationDestinations.ROUTE
        ){
            composable(UserCreationDestinations.SPLASH) { SplashScreen(navController) }

            composable(UserCreationDestinations.INTRO_OPTION) {
                val viewModel = it.sharedViewModel<IntroOptionsViewModel>(navController)
                OptionScreen(navController,viewModel)
            }

            composable(UserCreationDestinations.LOGIN) {
                val viewModel = it.sharedViewModel<LoginViewModel>(navController)
                LoginScreen(modifier,navController,viewModel)
            }

            composable(UserCreationDestinations.REGISTER) {
                val viewModel = it.sharedViewModel<RegisterViewModel>(navController)
                RegisterScreen(modifier, navController, viewModel)
            }


        }

        composable(HomeDestinations.HOME) {
            val navController = rememberNavController()
            val viewModel = it.sharedViewModel<HomeViewModel>(navController)
            HomeScreen(
                modifier = modifier,
                navController = navController,
                homeViewModel = viewModel
            )
        }
    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(navController: NavHostController): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}
fun travelAndPopUp(navController: NavHostController, route: String, popUp: String) {
    navController.navigate(route) {
        launchSingleTop = true
        popUpTo(popUp) { inclusive = false }
    }
}

