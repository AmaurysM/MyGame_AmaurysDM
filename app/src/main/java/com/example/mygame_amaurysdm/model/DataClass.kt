package com.example.mygame_amaurysdm.model

data class LoginData(var email: String, var password: String)
data class RegisterData(var username: String, var email: String, var password: String)
data class User(var username: String, var email: String, var password: String)

data class Question(val question: String, val options: List<String>, val correctAnswer: List<String>, val correct: Boolean)
//data class QuizQuestions(val questions: List<Question>)

//data class UserData(var userInfo: Map<String, String>)