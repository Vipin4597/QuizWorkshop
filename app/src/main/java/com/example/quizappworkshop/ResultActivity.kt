package com.example.quizappworkshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvResult: TextView = findViewById(R.id.tvResult)

        // Retrieve selected answers from intent extras
        val selectedAnswers = intent.getIntegerArrayListExtra("selectedAnswers")

        // Calculate score
        val score = calculateScore(selectedAnswers)

        // Display result
        tvResult.text = "Your score is $score out of ${selectedAnswers?.size}"
    }

    private fun calculateScore(selectedAnswers: ArrayList<Int>?): Int {
        var score = 0
        val correctAnswers = arrayOf(0, 0, 0) // Predefined correct answers

        if (selectedAnswers != null) {
            for (i in selectedAnswers.indices) {
                if (selectedAnswers[i] == correctAnswers[i]) {
                    score++
                }
            }
        }
        return score
    }
}