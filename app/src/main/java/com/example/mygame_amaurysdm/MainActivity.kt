package com.example.mygame_amaurysdm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.navigation.compose.rememberNavController
import com.example.compose.AppTheme
import com.example.mygame_amaurysdm.navigation.UserCreationNavigation

// import com.example.mygame_amaurysdm.ui.theme.MyGame_AmaurysDMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                    val navController = rememberNavController()
                    UserCreationNavigation(
                        navController = navController,
                    )

            }
        }
    }
}

/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        Greeting("Android")
    }
}*/
