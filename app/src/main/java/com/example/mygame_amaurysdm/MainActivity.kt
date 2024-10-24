package com.example.mygame_amaurysdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.mygame_amaurysdm.navigation.UserCreationNavigation
import com.example.mygame_amaurysdm.screens.TopBar
import com.example.mygame_amaurysdm.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            var isVisible by remember {mutableStateOf(false)}
            val navController = rememberNavController()
            AppTheme {
                Scaffold(
                    topBar = {
                        if (isVisible) {
                            TopBar(
                                modifier = Modifier,
                                navController = navController,
                                visible = isVisible,
                            )
                        }
                    }
                ){innerPadding->
                    UserCreationNavigation(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                    ){
                        topBarVisible ->
                        isVisible = topBarVisible
                    }
                }


            }
        }
    }
}

