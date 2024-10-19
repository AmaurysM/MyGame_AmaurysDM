package com.example.mygame_amaurysdm.screens.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mygame_amaurysdm.model.UserBag
import com.example.mygame_amaurysdm.viewmodel.NextButton

@Composable
fun ResultScreen(
    modifier: Modifier = Modifier, navController: NavHostController = rememberNavController()
) {
    val user = UserBag.getCurrentUser()
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(10.dp)
    ) {
        when (user.gradeBook.quizzes.size) {
            0 -> {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "No quizzes found")
                }
            }

            else -> {
                user.gradeBook.quizzes.forEach { quiz ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.surface),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = quiz.name,
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = "Score: ${quiz.score}/${quiz.questions.size}",
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
            }
        }
        NextButton(onButtonClick = {
            navController.navigate("game_Screen")
        }, "Try Quiz")
    }
}




