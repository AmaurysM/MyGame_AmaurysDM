package com.example.mygame_amaurysdm.model

data class LoginData(var email: String, var password: String)
data class RegisterData(var username: String, var email: String, var password: String)

data class Question (val qText: String, val qOptions: List<String>, val qAnswer: List<String>)
data class Quiz(val name: String, val questions: List<Question>, var score: Int = 0)
data class GradeBook(var quizzes: MutableList<Quiz> = mutableListOf())

data class User(var username: String, var email: String, var password: String, var gradeBook: GradeBook = GradeBook())

val defaultQuiz: List<Question> = listOf(
    Question("What is the capital of France?", listOf("Paris", "London", "Berlin", "Madrid"), listOf("Paris"))
    , Question("What is the largest country in the world by area?", listOf("Russia", "China", "USA", "Canada"), listOf("Russia"))
    , Question("What is the currency of Japan?", listOf("Yen", "Dollar", "Euro", "Pound"), listOf("Yen"))
    , Question("What is the capital of Spain?", listOf("Paris", "London", "Berlin", "Madrid"), listOf("Madrid"))
)
