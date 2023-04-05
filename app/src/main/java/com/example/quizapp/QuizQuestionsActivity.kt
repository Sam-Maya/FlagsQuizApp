package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity() {
    var questionV : TextView? = null
    var imageV : ImageView? = null
    var progressV : ProgressBar? = null
    var progressTextV : TextView? = null
    var optionV1 : TextView? = null
    var optionV2 : TextView? = null
    var optionV3 : TextView? = null
    var optionV4 : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        questionV = findViewById(R.id.questionText)
        imageV = findViewById(R.id.image)
        progressV = findViewById(R.id.progressBar)
        progressTextV = findViewById(R.id.progressText)
        optionV1 = findViewById(R.id.option1)
        optionV2 = findViewById(R.id.option2)
        optionV3 = findViewById(R.id.option3)
        optionV4 = findViewById(R.id.option4)

        val questionsList = Constrants.getQuestions()
        Log.i("questionsList size", "${questionsList.size}")

        var current = 1
        var question = questionsList[current - 1]
        questionV?.text = question.question
        imageV?.setImageResource(question.img)
        progressV?.progress = current
        progressTextV?.text = "$current/${questionsList.size}"
        optionV1?.text = question.optionOne
        optionV2?.text = question.optionTwo
        optionV3?.text = question.optionThree
        optionV4?.text = question.optionFour

    }


}