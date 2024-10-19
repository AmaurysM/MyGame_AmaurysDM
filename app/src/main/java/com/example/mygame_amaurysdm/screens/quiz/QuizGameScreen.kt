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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mygame_amaurysdm.model.Question
import com.example.mygame_amaurysdm.model.Quiz
import com.example.mygame_amaurysdm.model.UserBag
import com.example.mygame_amaurysdm.viewmodel.NextButton
import com.example.mygame_amaurysdm.viewmodel.RadioOption
import com.example.mygame_amaurysdm.viewmodel.checkAnswer
import com.example.mygame_amaurysdm.viewmodel.defaultQuiz

// @Preview(showBackground = true, device = "id:pixel_6", name = "QuizGameScreen")
@Composable
fun QuizGameScreen(
    modifier: Modifier = Modifier
    , navController: NavHostController = rememberNavController()
    , quiz: Quiz
    , onNextClick: () -> Unit = {}
    , onOptionSelected: (String) -> Unit = {}
    , selectedOption: String
    , currentQuestionIndex: Int
    , buttonText: String
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
                quiz.questions[currentQuestionIndex]
                , selectedOption
                , onOptionSelected
            )
            NextButton(onButtonClick = {
                onNextClick()
            }, buttonText)

        }
    }
}

@Composable
fun QuestionContent(question: Question
                    , selectedOption: String
                    , onOptionSelected: (String) -> Unit
){
    Column{
        Text(
            text = question.qText,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        question.qOptions.forEach { option ->
            RadioOption(option, option == selectedOption) {
                onOptionSelected(it)
            }
        }
    }
}

/**/

