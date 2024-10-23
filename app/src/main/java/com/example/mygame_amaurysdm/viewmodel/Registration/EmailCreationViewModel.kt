package com.example.mygame_amaurysdm.viewmodel.Registration

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController

class EmailCreationViewModel: ViewModel(){
    val onBackButtonClick: (navController: NavHostController) -> Unit =
        { navController -> navController.popBackStack() }

    fun checkEmailPassword(email: String, password: String): Boolean {
        if (email != "" && password != "" && password.length >= 8) {
            return true;
        }
        return false;
    }
}