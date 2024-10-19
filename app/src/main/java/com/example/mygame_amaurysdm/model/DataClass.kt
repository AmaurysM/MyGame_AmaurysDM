package com.example.mygame_amaurysdm.model

data class Question(val qText: String, val qOptions: List<String>, val qAnswer: List<String>)
data class Quiz(val name: String, val questions: List<Question>, var score: Int = 0)
data class GradeBook(var quizzes: MutableList<Quiz> = mutableListOf())

data class User(
    var username: String,
    var email: String,
    var password: String,
    var gradeBook: GradeBook = GradeBook()
)


