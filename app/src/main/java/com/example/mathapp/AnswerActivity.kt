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
        Log.d("!!!", "Rätt? $answeredCorrectly")
        if(answeredCorrectly) {
            resultView.text = "Rätt!"
        } else {
            resultView.text = "Fel!"
        }



    }


}