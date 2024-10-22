package com.example.mygame_amaurysdm.screens.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mygame_amaurysdm.model.Question
import com.example.mygame_amaurysdm.model.Quiz
import com.example.mygame_amaurysdm.viewmodel.CheckBoxOption
import com.example.mygame_amaurysdm.viewmodel.NextButton
import com.example.mygame_amaurysdm.viewmodel.RadioOption

// @Preview(showBackground = true, device = "id:pixel_6", name = "QuizGameScreen")
@Composable
fun QuizGameScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    quiz: Quiz,
    onNextClick: () -> Unit = {},
    selectedOptions: MutableList<String>,
    currentQuestionIndex: Int,
    buttonText: String
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(10.dp)
        ) {

            QuestionContent(
                quiz.questions[currentQuestionIndex], selectedOptions
            )
            NextButton(onButtonClick = {
                onNextClick()
            }, buttonText)

        }
    }
}

@Composable
fun QuestionContent(
    question: Question, selectedOptions: MutableList<String>
) {
    Column {
        Text(
            text = question.qText,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        selectedOptions.clear()
        if (question.qAnswer.size == 1) {
            question.qOptions.forEach { option ->
                RadioOption(option, selectedOptions)
            }
        }else {
            question.qOptions.forEach { option ->
                CheckBoxOption(option, selectedOptions)
            }
        }
    }
}

/**/

