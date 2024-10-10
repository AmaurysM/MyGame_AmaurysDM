package com.example.mygame_amaurysdm.model

import androidx.navigation.NavHostController

fun checkLogin(loginData: LoginData, navController: NavHostController){
    if(loginData.email == "admin" && loginData.password == "admin"){
        navController.navigate("game")
    }
}