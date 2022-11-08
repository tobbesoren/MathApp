package com.example.mathapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MathMethodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math_method)

        val plusButton = findViewById<Button>(R.id.plusButton)
        val minusButton = findViewById<Button>(R.id.minusButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divisionButton = findViewById<Button>(R.id.divisionButton)

        plusButton.setOnClickListener {

        }

        minusButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = (Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra("mathMethod",'-')
            startActivity(intent)
        }

        multiplyButton.setOnClickListener {

        }

        divisionButton.setOnClickListener {

        }

    }
}