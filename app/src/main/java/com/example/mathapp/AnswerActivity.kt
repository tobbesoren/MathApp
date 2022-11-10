package com.example.mathapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class AnswerActivity : AppCompatActivity() {

    lateinit var resultView : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        resultView = findViewById(R.id.answerView)

        val returnButton = findViewById<Button>(R.id.returnButton)

        returnButton.setOnClickListener {
            finish()
        }

        val answeredCorrectly = intent.getBooleanExtra("answeredCorrectly", false)
        val firstNumber = intent.getIntExtra("firstNumber", 0)
        val secondNumber = intent.getIntExtra("secondNumber", 0)
        val mathMethod = intent.getCharExtra("mathMethod", '+')

        if(answeredCorrectly) {
            when(mathMethod) {
                '+' ->  resultView.text =
                    getString(
                        R.string.correctAnswerText,
                        firstNumber.toString(),
                        mathMethod.toString(),
                        secondNumber.toString(),
                        (firstNumber + secondNumber).toString()
                    )
                '-' -> resultView.text =
                    getString(
                        R.string.correctAnswerText,
                        firstNumber.toString(),
                        mathMethod.toString(),
                        secondNumber.toString(),
                        (firstNumber - secondNumber).toString()
                    )
                'x' -> resultView.text =
                    getString(
                        R.string.correctAnswerText,
                        firstNumber.toString(),
                        mathMethod.toString(),
                        secondNumber.toString(),
                        (firstNumber * secondNumber).toString()
                    )
                '/' -> resultView.text =
                    getString(
                        R.string.correctAnswerText,
                        firstNumber.toString(),
                        mathMethod.toString(),
                        secondNumber.toString(),
                        (firstNumber / secondNumber).toString()
                    )
            }
        } else {
            when(mathMethod) {
                '+' ->  resultView.text =
                    getString(
                        R.string.wrongAnswerText,
                        firstNumber.toString(),
                        mathMethod.toString(),
                        secondNumber.toString(),
                        (firstNumber + secondNumber).toString()
                    )
                '-' -> resultView.text =
                    getString(
                        R.string.wrongAnswerText,
                        firstNumber.toString(),
                        mathMethod.toString(),
                        secondNumber.toString(),
                        (firstNumber - secondNumber).toString()
                        )
                'x' -> resultView.text =
                    getString(
                        R.string.wrongAnswerText,
                        firstNumber.toString(),
                        mathMethod.toString(),
                        secondNumber.toString(),
                        (firstNumber * secondNumber).toString()
                    )
                '/' -> resultView.text =
                    getString(
                        R.string.wrongAnswerText,
                        firstNumber.toString(),
                        mathMethod.toString(),
                        secondNumber.toString(),
                        (firstNumber / secondNumber).toString()
                    )
            }
        }



    }


}