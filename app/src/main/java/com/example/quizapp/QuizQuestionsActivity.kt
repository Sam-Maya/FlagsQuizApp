package com.example.quizapp

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    //need to keep track of question we're on and answer selected
    private var current = 1
    private var selectedOption : Int? = null

    //Bringing in all views that need to be changed / updated
    private var questionV : TextView? = null
    private var imageV : ImageView? = null
    private var progressV : ProgressBar? = null
    private var progressTextV : TextView? = null
    private var optionV1 : TextView? = null
    private var optionV2 : TextView? = null
    private var optionV3 : TextView? = null
    private var optionV4 : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        //setting all global variables = to their respective id's from XML
        questionV = findViewById(R.id.questionText)
        imageV = findViewById(R.id.image)
        progressV = findViewById(R.id.progressBar)
        progressTextV = findViewById(R.id.progressText)
        optionV1 = findViewById(R.id.option1)
        optionV2 = findViewById(R.id.option2)
        optionV3 = findViewById(R.id.option3)
        optionV4 = findViewById(R.id.option4)

        val questionsList = Constrants.getQuestions()

        var question = questionsList[current - 1]
        questionV?.text = question.question
        imageV?.setImageResource(question.img)
        progressV?.progress = current
        progressTextV?.text = "$current/${questionsList.size}"
        optionV1?.text = question.optionOne
        optionV2?.text = question.optionTwo
        optionV3?.text = question.optionThree
        optionV4?.text = question.optionFour

        optionV1?.setOnClickListener(this)
        optionV2?.setOnClickListener(this)
        optionV3?.setOnClickListener(this)
        optionV4?.setOnClickListener(this)

    }

    //this function highlights the options selected by the user
    private fun onSelect(tv : TextView, id : Int){
        onDefault()
        tv.typeface = Typeface.DEFAULT_BOLD
        tv.setTextColor(ContextCompat.getColor(this, R.color.black))
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_border)
        selectedOption = id
    }

    //returns all options to default view
    private fun onDefault() {
        val optionsArr = ArrayList<TextView>()
        optionV1?.let{
            optionsArr.add(it)
        }
        optionV2?.let{
            optionsArr.add(it)
        }
        optionV3?.let{
            optionsArr.add(it)
        }
        optionV4?.let{
            optionsArr.add(it)
        }

        for (option in optionsArr){
            option.typeface = Typeface.DEFAULT
            option.setTextColor(ContextCompat.getColor(this, R.color.grey))
            option.background = ContextCompat.getDrawable(this, R.drawable.default_border)
            selectedOption = null
        }
    }

    //checks what was clicked on
    override fun onClick(view: View?) {
        when (view){
            optionV1 -> optionV1?.let {onSelect(it, 1) }
            optionV2 -> optionV2?.let {onSelect(it, 2) }
            optionV3 -> optionV3?.let {onSelect(it, 3) }
            optionV4 -> optionV4?.let {onSelect(it, 4) }
        }
    }


}