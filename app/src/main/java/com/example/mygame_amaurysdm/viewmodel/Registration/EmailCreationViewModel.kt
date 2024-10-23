package com.example.mygame_amaurysdm.viewmodel.Registration

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.mygame_amaurysdm.navigation.UserCreationDestinations

class EmailCreationViewModel: ViewModel(){
    val onBackButtonClick: (navController: NavHostController) -> Unit =
        { navController ->
            navController.navigate(UserCreationDestinations.INTRO_OPTION){
                popUpTo(UserCreationDestinations.INTRO_OPTION){
                    inclusive = true
                }
            }
        }

    fun checkEmailPassword(email: String, password: String): Boolean {
        if (email != "" && password != "" && password.length >= 8) {
            return true;
        }
        return false;
    }
}