package com.example.mygame_amaurysdm.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mygame_amaurysdm.R
import com.example.mygame_amaurysdm.navigation.UserCreationDestinations
import kotlinx.coroutines.delay

@Preview(showBackground = true)
@Composable
fun SplashScreen(navController: NavHostController = rememberNavController()) {
    val scale = remember{
        Animatable(0f, 1f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.5f,
            animationSpec = tween(
                durationMillis = 1500
                ,0
                , easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000)
        navController.navigate(UserCreationDestinations.INTRO_OPTION){
            popUpTo(navController.graph.startDestinationId) {
                inclusive = true
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
        , horizontalAlignment = Alignment.CenterHorizontally
        , verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.img_logo)
            , contentDescription = "Logo"
            , modifier = Modifier.scale(scale.value)
        )
        Text(
            text = "QuizME"
            , style = MaterialTheme.typography.displayLarge
            , color = MaterialTheme.colorScheme.primary
            , fontWeight = androidx.compose.ui.text.font.FontWeight.ExtraBold
        )
    }
}