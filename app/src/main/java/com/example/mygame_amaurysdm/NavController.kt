package com.example.mygame_amaurysdm

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
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
import com.example.mygame_amaurysdm.model.LoginData
import com.example.mygame_amaurysdm.model.checkLogin
import com.example.mygame_amaurysdm.screens.GameScreen
import com.example.mygame_amaurysdm.screens.LoginScreen
import com.example.mygame_amaurysdm.screens.RegisterScreen

@Preview(showBackground = true)
@Composable
fun GameNavigation(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = "login",
        modifier = modifier
    ){


        composable(route = "login"){
            var loginData by remember { mutableStateOf(LoginData("", "")) }
            LoginScreen(
                loginData = loginData
                , onLoginChange = { newLoginData -> loginData = newLoginData }
                , onCreateAccountClick = { navController.navigate("register") }
                , onLoginClick = {
                    checkLogin(loginData,navController)
                }
            )
        }
        
        composable(route = "register"){
            RegisterScreen()
        }

        composable(route = "game"){
            GameScreen()
        }


    }
}