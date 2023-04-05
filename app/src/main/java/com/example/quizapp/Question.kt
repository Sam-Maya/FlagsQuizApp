package com.example.quizapp

data class Question(
    val id : Int,
    val question : String,
    val img : Int,
    val optionOne : String,
    val optionTwo : String,
    val optionThree : String,
    val optionFour : String,
    val ans : Int
    )
