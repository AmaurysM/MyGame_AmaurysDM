package com.example.mygame_amaurysdm.model

import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

fun checkLogin(loginData: LoginData) : Boolean{
    val user = UserBag.getUser { it.email == loginData.email && it.password == loginData.password }
    if(user.isNotEmpty()) {
        UserBag.setCurrent(user[0])
        return true;
    }

    return false;
}

fun checkRegister(registerData: RegisterData): Boolean{
    if(registerData.username.isEmpty() || registerData.email.isEmpty() || registerData.password.isEmpty()) {
        return false;
    }else if(registerData.password.length < 8) {
        return false;
    }else if(UserBag.getUser { it.email == registerData.email }.isNotEmpty()) {
        return false;
    }else if(UserBag.getUser { it.username == registerData.username }.isNotEmpty()) {
        return false;
    }else {
        val user = User(registerData.username, registerData.email, registerData.password)
        UserBag.addUser(user)
        UserBag.setCurrent(user)
        return true;
    }
}

