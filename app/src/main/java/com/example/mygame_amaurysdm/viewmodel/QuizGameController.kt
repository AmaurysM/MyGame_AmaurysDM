package com.example.mygame_amaurysdm.viewmodel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
    modifier: Modifier, navController: NavHostController, quiz: Quiz = Quiz(
        "Default Quiz ${UserBag.getCurrentUser().gradeBook.quizzes.size + 1}",
        defaultQuiz
    )
) {
    var currentQuestionIndex by remember { mutableIntStateOf(0) }
    var selectedOption by remember { mutableStateOf("") }
    var score by remember { mutableIntStateOf(0) }
    var buttonText by remember { mutableStateOf("Next") }


    QuizGameScreen(
        modifier
        , navController
        , quiz
        , selectedOption = selectedOption
        , onOptionSelected = {
            selectedOption = it
        }
        , currentQuestionIndex = currentQuestionIndex
        , buttonText = buttonText
        , onNextClick = {
            if (checkAnswer(
                    listOf(selectedOption),
                    quiz.questions[currentQuestionIndex]
                )
            ) score++

            if (selectedOption == "") {
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
fun RadioOption(option: String, selected: Boolean, onOptionSelected: (String) -> Unit) {
    Row() {
        RadioButton(
            selected = selected, onClick = { onOptionSelected(option) }
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
        ) {
            Text(
                text = text,
                color = MaterialTheme.colorScheme.inversePrimary,
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
    )
)