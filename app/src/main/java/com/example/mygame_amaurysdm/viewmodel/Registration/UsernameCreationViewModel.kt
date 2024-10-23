package com.example.mygame_amaurysdm.viewmodel.Registration

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.mygame_amaurysdm.model.User
import com.example.mygame_amaurysdm.model.UserBag

class UsernameCreationViewModel : ViewModel() {
    val onCreateAccountClick: (navController: NavHostController) -> Unit = { navController ->

        navController.navigate("home") {
            popUpTo(navController.graph.startDestinationId) {
                inclusive = true
            }
        }

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
            val user = User(
                registerData.username,
                registerData.email,
                password = registerData.password,
                registerData.firstName,
                registerData.lastName,
                registerData.dateOfBirth
            )
            UserBag.addUser(user)
            UserBag.setCurrent(user)
            return true;
        }
    }
}