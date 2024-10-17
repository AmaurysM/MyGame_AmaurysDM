package com.example.mygame_amaurysdm.screens.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
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
import com.example.mygame_amaurysdm.model.NextButton
import com.example.mygame_amaurysdm.model.Quiz
import com.example.mygame_amaurysdm.model.UserBag
import com.example.mygame_amaurysdm.model.checkAnswer
import com.example.mygame_amaurysdm.model.defaultQuiz

@Preview(showBackground = true, device = "id:pixel_6", name = "QuizGameScreen")
@Composable
fun QuizGameScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    quiz: Quiz = Quiz("Default Quiz ${UserBag.getCurrentUser().gradeBook.quizzes.size +1}", defaultQuiz)
) {
    //val user = UserBag.getCurrentUser()
    //val quiz = user.gradeBook.quizzes.last()
    var currentQuestionIndex by remember { mutableIntStateOf(0) }
    //val currentQuestion by remember { mutableStateOf(quiz.questions[currentQuestionIndex]) }
    var selectedOption by remember { mutableStateOf("") }
    var score by remember { mutableIntStateOf(0) }

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
            var buttonText by remember { mutableStateOf("Next") }
            Text(
                text = quiz.questions[currentQuestionIndex].qText,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            quiz.questions[currentQuestionIndex].qOptions.forEach { option ->
                RadioOption(option, option == selectedOption) {
                    selectedOption = it
                }
            }
            NextButton(onButtonClick = {

                if (checkAnswer(listOf(selectedOption), quiz.questions[currentQuestionIndex])) score++

                if (selectedOption == "") {
                    ; // if no option is selected do nothing
                }else if (currentQuestionIndex < quiz.questions.size-1) {
                    currentQuestionIndex++
                } else {
                    quiz.score = score
                    UserBag.getCurrentUser().gradeBook.quizzes.add(quiz)
                    buttonText = "Finish"
                    navController.navigate("result_Screen")
                }
            }, buttonText)

        }
    }
}


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
/**/

