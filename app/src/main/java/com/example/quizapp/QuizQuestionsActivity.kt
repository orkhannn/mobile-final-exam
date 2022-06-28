package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

 /*var progressBar: ProgressBar = findViewById<ProgressBar>(R.id.progressBar)
    var tvProgress = findViewById<TextView>(R.id.tv_progress)
    var tvQuestion = findViewById<TextView>(R.id.tv_question)
    var ivImage = findViewById<ImageView>(R.id.iv_image)
    var tvOptionOne = findViewById<TextView>(R.id.tv_option_one)
    var tvOptionTwo = findViewById<TextView>(R.id.tv_option_two)
    var tvOptionThree = findViewById<TextView>(R.id.tv_option_three)
    var tvOptionFour = findViewById<TextView>(R.id.tv_option_four)
    */

class QuizQuestionsActivity : AppCompatActivity() , View.OnClickListener {


    private var mCurrentPosition:Int = 1;
    private var mQuestionsList:ArrayList<Question>? = null;
    private var mSelectedOptionPosition:Int = 0;
    private var mCorrectAnswers: Int = 0;
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionsList = Constants.getQuestions()

        setQuestion()

        findViewById<TextView>(R.id.tv_option_one).setOnClickListener(this)
        findViewById<TextView>(R.id.tv_option_two).setOnClickListener(this)
        findViewById<TextView>(R.id.tv_option_three).setOnClickListener(this)
        findViewById<TextView>(R.id.tv_option_four).setOnClickListener(this)
        findViewById<Button>(R.id.btn_submit).setOnClickListener(this)
    }

    private fun setQuestion(){
        val question = mQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()
        if(mCurrentPosition == mQuestionsList!!.size){
            findViewById<Button>(R.id.btn_submit).text = "FINISH"
        }else{
            findViewById<Button>(R.id.btn_submit).text = "SUBMIT"
        }

        findViewById<ProgressBar>(R.id.progressBar).progress = mCurrentPosition;
        findViewById<TextView>(R.id.tv_progress).text =
            "$mCurrentPosition" + "/" + findViewById<ProgressBar>(R.id.progressBar).max
        findViewById<TextView>(R.id.tv_question).text = question!!.question
        findViewById<ImageView>(R.id.iv_image).setImageResource(question.image)
        findViewById<TextView>(R.id.tv_option_one).text = question.optionOne
        findViewById<TextView>(R.id.tv_option_two).text = question.optionTwo
        findViewById<TextView>(R.id.tv_option_three).text = question.optionThree
        findViewById<TextView>(R.id.tv_option_four).text = question.optionFour
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0,findViewById<TextView>(R.id.tv_option_one))
        options.add(1,findViewById<TextView>(R.id.tv_option_two))
        options.add(2,findViewById<TextView>(R.id.tv_option_three))
        options.add(3,findViewById<TextView>(R.id.tv_option_four))

        for (option in options){
            option.setTextColor(Color.parseColor("#7a8089"))
            option.typeface = Typeface.DEFAULT;
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
 when(v?.id){
    R.id.tv_option_one -> {
         selectedOptionView(findViewById<TextView>(R.id.tv_option_one), 1 )
     }
     R.id.tv_option_two -> {
         selectedOptionView(findViewById<TextView>(R.id.tv_option_two), 2 )
     }
     R.id.tv_option_three -> {
         selectedOptionView(findViewById<TextView>(R.id.tv_option_three), 3 )
     }
     R.id.tv_option_four -> {
         selectedOptionView(findViewById<TextView>(R.id.tv_option_four), 4 )
     }
     R.id.btn_submit -> {
         if(mSelectedOptionPosition == 0) {
             mCurrentPosition++

             when{
                 mCurrentPosition <= mQuestionsList!!.size -> {
                     setQuestion()
                 }else -> {
                     val intent = Intent(this, ResultActivity::class.java)
                     intent.putExtra(Constants.USER_NAME, mUserName)
                     intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                     intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                 startActivity(intent)
                 }
             }
         } else {
             val question = mQuestionsList?.get(mCurrentPosition -1)
             if(question!!.correctAnswer != mSelectedOptionPosition){
                 answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
             }else{
                 mCorrectAnswers++;
             }
             answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

             if(mCurrentPosition == mQuestionsList!!.size) {
                 findViewById<Button>(R.id.btn_submit).text = "FINISH"
             }else{
                 findViewById<Button>(R.id.btn_submit).text = "NEXT"
             }
             mSelectedOptionPosition = 0;
         }
     }
 }
}

private fun answerView(answer: Int, drawableView: Int) {
    when(answer) {
        1 -> {
            findViewById<TextView>(R.id.tv_option_one).background = ContextCompat.getDrawable(
                this, drawableView
            )
        }
        2 -> {
            findViewById<TextView>(R.id.tv_option_two).background = ContextCompat.getDrawable(
                this, drawableView
            )
        }
        3 -> {
            findViewById<TextView>(R.id.tv_option_three).background = ContextCompat.getDrawable(
                this, drawableView
            )
        }
        4 -> {
            findViewById<TextView>(R.id.tv_option_four).background = ContextCompat.getDrawable(
                this, drawableView
            )
        }
    }
}

private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
 defaultOptionsView()
 mSelectedOptionPosition = selectedOptionNum

 tv.setTextColor(Color.parseColor("#363a43"))
 tv.setTypeface(tv.typeface, Typeface.BOLD)
 tv.background = ContextCompat.getDrawable(
     this,
     R.drawable.selected_option_border_bg
 )
}
}