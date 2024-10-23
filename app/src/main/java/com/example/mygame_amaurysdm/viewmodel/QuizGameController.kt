package com.example.mygame_amaurysdm.viewmodel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mygame_amaurysdm.model.Question
import com.example.mygame_amaurysdm.model.Quiz
import com.example.mygame_amaurysdm.model.UserBag
import com.example.mygame_amaurysdm.screens.quiz.QuizGameScreen


@Composable
fun Quiz(
    modifier: Modifier
    , navController: NavHostController
    , quiz: Quiz = Quiz(
        "Default Quiz ${UserBag.getCurrentUser().gradeBook.quizzes.size + 1}",
        defaultQuiz
    )
) {
    var currentQuestionIndex by remember { mutableIntStateOf(0) }
    val selectedOptions = remember { mutableStateListOf<String>() }
    var score by remember { mutableIntStateOf(0) }
    var buttonText by remember { mutableStateOf("Next") }


    QuizGameScreen(
        modifier
        , navController
        , quiz
        , selectedOptions = selectedOptions
        , currentQuestionIndex = currentQuestionIndex
        , buttonText = buttonText
        , onNextClick = {
            if (
                checkAnswer(
                    selectedOptions,
                    quiz.questions[currentQuestionIndex]
                )
            ) score++

            if (selectedOptions.isEmpty()) {
                ; // if no option is selected do nothing
            } else if (currentQuestionIndex < quiz.questions.size - 1) {
                currentQuestionIndex++
            } else {
                quiz.score = score
                UserBag.getCurrentUser().gradeBook.quizzes.add(quiz)
                buttonText = "Finish"
                navController.navigate("result_Screen")
            }
        }
    )
}/**/


@Composable
fun RadioOption(option: String, selectedOptions: MutableList<String>) {
    Row() {
        RadioButton(
            selected = selectedOptions.contains(option)
            , onClick = {
                selectedOptions.clear();
                selectedOptions.add(option)
            }
        )

        Text(
            text = option,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Composable
fun CheckBoxOption(option: String, selectedOptions: MutableList<String>) {
    Row() {
        Checkbox(
            checked = selectedOptions.contains(option)
            , onCheckedChange = {
                if (selectedOptions.contains(option)) {
                    selectedOptions.remove(option)
                }
                else {
                    selectedOptions.add(option)
                }
            }
        )
        Text(
            text = option,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Composable
fun NextButton(onButtonClick: () -> Unit, text: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            onClick = {
                onButtonClick()
            }, shape = MaterialTheme.shapes.medium
            , colors = ButtonColors(
                containerColor = MaterialTheme.colorScheme.onPrimaryContainer
                , contentColor = MaterialTheme.colorScheme.primaryContainer
                , disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer
                , disabledContentColor = MaterialTheme.colorScheme.onSecondaryContainer
            )
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

fun checkAnswer(inputAnswer: List<String>, question: Question): Boolean =
    question.qAnswer.containsAll(inputAnswer)

val defaultQuiz: List<Question> = listOf(
    Question(
        "What is the capital of France?",
        listOf("Paris", "London", "Berlin", "Madrid"),
        listOf("Paris")
    ),
    Question(
        "What is the largest country in the world by area?",
        listOf("Russia", "China", "USA", "Canada"),
        listOf("Russia")
    ),
    Question(
        "What is the currency of Japan?",
        listOf("Yen", "Dollar", "Euro", "Pound"),
        listOf("Yen")
    ),
    Question(
        "What is the capital of Spain?",
        listOf("Paris", "London", "Berlin", "Madrid"),
        listOf("Madrid")
    ),
    Question(
        "Which of the following are considered planets in our solar system?",
        listOf("Earth", "Pluto", "Jupiter", "Saturn"),
        listOf("Earth", "Jupiter", "Saturn")
    ),
    Question(
        "What is the largest ocean in the world?",
        listOf("Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"),
        listOf("Pacific Ocean")
    ),
    Question(
        "What is the capital of Italy?",
        listOf("Paris", "London", "Berlin", "Rome"),
        listOf("Rome")
    ),
    Question(
        "Which of the following animals are mammals?",
        listOf("Elephant", "Black Mamba", "Lion", "Penguins", "Komoto Dragon"),
        listOf("Elephant", "Lion")
    )
)