package com.example.mygame_amaurysdm.model

class QuizQuestions {
    private var questions: List<Question> = listOf(
        Question(
            "What is the capital of France?",
            listOf("Paris", "London", "Berlin", "Madrid"),
            listOf("Paris"),
            false
        ), Question(
            "Which planet is known as the Red Planet?",
            listOf("Mars", "Venus", "Jupiter", "Saturn"),
            listOf("Mars"),
            false
        ), Question(
            "What is the largest mammal in the world?",
            listOf("Elephant", "Blue Whale", "Giraffe", "Hippopotamus"),
            listOf("Blue Whale"),
            false
        ), Question(
            "What is the chemical symbol for gold?",
            listOf("Go", "Ag", "Au", "Gd"),
            listOf("Au"),
            false
        ), Question(
            "Which of these are wonders of the world?",
            listOf("The Eiffel Tower", "Taj Mahal", "Great Wall of China", "Colosseum"),
            listOf("The Eiffel Tower", "The Great Wall of China"),
            false
        )
    )

    private var score = 0

    fun getQuestions(): List<Question> {
        return questions
    }


}