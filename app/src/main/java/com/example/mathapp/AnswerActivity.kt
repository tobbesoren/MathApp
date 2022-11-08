package com.example.mathapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class AnswerActivity : AppCompatActivity() {

    lateinit var resultView : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        resultView = findViewById(R.id.answerView)

        val answeredCorrectly = intent.getBooleanExtra("answeredCorrectly", false)
        val firstNumber = intent.getIntExtra("firstNumber", 0)
        val secondNumber = intent.getIntExtra("secondNumber", 0)
        val mathMethod = intent.getCharExtra("mathMethod", '+')

        if(answeredCorrectly) {
            when(mathMethod) {
                '+' ->  resultView.text =
                    "Rätt! $firstNumber $mathMethod $secondNumber = ${firstNumber + secondNumber}"
                '-' -> resultView.text =
                    "Rätt! $firstNumber $mathMethod $secondNumber = ${firstNumber - secondNumber}"
                'x' -> resultView.text =
                    "Rätt! $firstNumber $mathMethod $secondNumber = ${firstNumber * secondNumber}"
                '/' -> resultView.text =
                    "Rätt! $firstNumber $mathMethod $secondNumber = ${firstNumber / secondNumber}"
            }
        } else {
            when(mathMethod) {
                '+' ->  resultView.text =
                    "Fel! $firstNumber $mathMethod $secondNumber = ${firstNumber + secondNumber}"
                '-' -> resultView.text =
                    "Fel! $firstNumber $mathMethod $secondNumber = ${firstNumber - secondNumber}"
                'x' -> resultView.text =
                    "Fel! $firstNumber $mathMethod $secondNumber = ${firstNumber * secondNumber}"
                '/' -> resultView.text =
                    "Fel! $firstNumber $mathMethod $secondNumber = ${firstNumber / secondNumber}"
            }
        }



    }


}