package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra(Constants.USER_NAME)
        findViewById<TextView>(R.id.tv_name).text = "Master " + username;
        val correctanswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val totalquestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        findViewById<TextView>(R.id.tv_score).text = "Your Score is " + correctanswers + " out of " + totalquestions;

        findViewById<Button>(R.id.btn_finish).setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}