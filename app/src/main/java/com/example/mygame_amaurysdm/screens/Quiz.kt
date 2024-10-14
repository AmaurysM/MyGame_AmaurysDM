package com.example.mygame_amaurysdm.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mygame_amaurysdm.model.QuizQuestions

@Preview
@Composable
fun Quiz(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    QuizQuestions: QuizQuestions = QuizQuestions()
) {
    val questions = QuizQuestions.getQuestions()
    val scrollable = remember { mutableStateOf(false) }
    LazyRow(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(10.dp)
    ) {
        items(questions) { question ->
            Card(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(370.dp)
                    .background(MaterialTheme.colorScheme.background)
                    .padding(10.dp)
            ) {
                Text(
                    text = question.question,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(10.dp)
                )
                for (option in question.options) {
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        if (question.correctAnswer.size > 1) {
                            var checkedState by remember { mutableStateOf(false) }
                            Checkbox(
                                checked = checkedState, onCheckedChange = { checkedState = it }
                            )

                        } else {
                            var checkedState by remember { mutableStateOf(false) }
                            RadioButton(
                                selected = checkedState,
                                onClick = { checkedState = !checkedState },
                                colors = RadioButtonDefaults.colors()

                            )

                        }
                        Text(
                            text = option,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                }
            }
        }
    }
}