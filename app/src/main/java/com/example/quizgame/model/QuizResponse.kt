package com.example.quizgame.model

data class QuizResponse(
    val response_code: Int,
    val results: List<Result>
){
    data class Result(
        val category: String,
        val correct_answer: String,
        val difficulty: String,
        val incorrect_answers: ArrayList<String>,
        val question: String,
        val type: String
    ){
        private val inCorrectAnswerWithCorrectAnswer: ArrayList<String>
        get(){
            inCorrectAnswerWithCorrectAnswer.addAll(incorrect_answers)
            inCorrectAnswerWithCorrectAnswer.add(correct_answer)
            inCorrectAnswerWithCorrectAnswer.shuffle()
            return inCorrectAnswerWithCorrectAnswer
        }
    }
}