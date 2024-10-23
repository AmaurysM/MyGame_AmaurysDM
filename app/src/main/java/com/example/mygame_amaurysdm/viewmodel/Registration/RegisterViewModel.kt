package com.example.mygame_amaurysdm.viewmodel.Registration

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.mygame_amaurysdm.screens.usercreation.Registration.EmailCreationScreen
import com.example.mygame_amaurysdm.screens.usercreation.Registration.UsernameCreationScreen

data class RegisterData(
    var username: String,
    var email: String,
    var password: String,
    var firstName: String,
    var lastName: String,
    var dateOfBirth: String
)

class RegisterViewModel : ViewModel() {
    private var registerData by mutableStateOf(RegisterData("", "", "", "", "", ""))
    var accountStep = mutableIntStateOf(1)
    val onLoginClick: (navController: NavHostController) -> Unit = { navController ->
        navController.navigate("login") {
            popUpTo(navController.graph.startDestinationId) {
                inclusive = true
            }
        }
    }

    private val onRegistrationChange: (RegisterData) -> Unit =
        { newRegisterData -> registerData = newRegisterData }


    val screenState: @Composable (navController: NavHostController) -> Unit =
        @androidx.compose.runtime.Composable { navController ->
            when (accountStep.intValue) {
                1 -> EmailCreationScreen(
                    registerData,
                    onRegistrationChange,
                    accountStep,
                    navController
                )

                2 -> UsernameCreationScreen(
                    registerData,
                    onRegistrationChange,
                    accountStep,
                    navController
                )
            }
        }

}

