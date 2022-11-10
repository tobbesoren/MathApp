package com.example.mathapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var questionTextView : TextView
    lateinit var answerView : EditText
    var firstNumber = 0
    var secondNumber = 0
    var mathMethod = '+'


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionTextView = findViewById(R.id.textView)
        answerView = findViewById(R.id.answerEditText)

        val checkButton = findViewById<Button>(R.id.button)
        checkButton.setOnClickListener {
            checkAnswerAndStartAnswerActivity()
        }

        val mathMethodButton = findViewById<Button>(R.id.mathMethodButton)
        mathMethodButton.setOnClickListener {
            val intent = Intent(this, MathMethodActivity::class.java)
            intent.putExtra("mathMethod", mathMethod)
            startActivity(intent)
        }

        setNewQuestion()

    }

    override fun onResume() {
        super.onResume()
        mathMethod = intent!!.getCharExtra("mathMethod", '+')
        Log.d("!!!!", "mathMethod: $mathMethod")
        setNewQuestion()
        answerView.setText("")
    }


    fun checkAnswerAndStartAnswerActivity() {
        val answerText = answerView.text.toString()
        val answer = answerText.toIntOrNull()
        val correctAnswer : Int

        var answeredCorrectly = false

        when(mathMethod) {
            '+' ->  correctAnswer = firstNumber + secondNumber
            '-' -> correctAnswer = firstNumber - secondNumber
            'x' -> correctAnswer = firstNumber * secondNumber
            '/' -> correctAnswer = firstNumber / secondNumber
            else -> correctAnswer = 0
        }



        if(answer == correctAnswer) {
            answeredCorrectly = true
        }

        val intent = Intent(this, AnswerActivity::class.java)
        intent.putExtra("answeredCorrectly", answeredCorrectly)
        intent.putExtra("firstNumber", firstNumber)
        intent.putExtra("secondNumber", secondNumber)
        intent.putExtra("mathMethod", mathMethod)
        startActivity(intent)
    }

    fun setNewQuestion() {

        firstNumber = (1..10).random()
        secondNumber = (1..10).random()

        questionTextView.text = "$firstNumber $mathMethod $secondNumber"

    }
}