package com.example.mygame_amaurysdm.model

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

fun checkLogin(loginData: LoginData): Boolean {
    val user = UserBag.getUser { it.email == loginData.email && it.password == loginData.password }
    if (user.isNotEmpty()) {
        UserBag.setCurrent(user[0])
        return true;
    }

    return false;
}

fun checkRegister(registerData: RegisterData): Boolean {
    if (registerData.username.isEmpty() || registerData.email.isEmpty() || registerData.password.isEmpty()) {
        return false;
    } else if (registerData.password.length < 8) {
        return false;
    } else if (UserBag.getUser { it.email == registerData.email }.isNotEmpty()) {
        return false;
    } else if (UserBag.getUser { it.username == registerData.username }.isNotEmpty()) {
        return false;
    } else {
        val user = User(registerData.username, registerData.email, password = registerData.password)
        UserBag.addUser(user)
        UserBag.setCurrent(user)
        return true;
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
        Button(onClick = {
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

fun checkAnswer(inputAnswer: List<String>, question: Question): Boolean = question.qAnswer.containsAll(inputAnswer)

