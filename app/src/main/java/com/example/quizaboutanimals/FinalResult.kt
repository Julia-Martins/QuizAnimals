package com.example.quizaboutanimals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FinalResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_result)

        val txtName: TextView = findViewById(R.id.txtUsername)
        val txtScore: TextView = findViewById(R.id.txtScore)
        val btnFinish: Button = findViewById(R.id.btnFinish)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWER, 0)

        txtName.text = intent.getStringExtra(Constants.USER_NAME)

        txtScore.text = "Your score is $correctAnswer out $totalQuestions"

        btnFinish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}