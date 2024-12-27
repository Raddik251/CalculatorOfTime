package com.example.calculatoroftime

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var firstOperandET: EditText
    private lateinit var secondOperandET: EditText

    private lateinit var sumBTN: Button
    private lateinit var difBTN: Button

    private lateinit var resultTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        firstOperandET = findViewById(R.id.firstOperandET)
        secondOperandET = findViewById(R.id.secondOperandET)
        sumBTN = findViewById(R.id.sumBTN)
        difBTN = findViewById(R.id.difBTN)
        resultTV = findViewById(R.id.resultTV)

        sumBTN.setOnClickListener(this)
        difBTN.setOnClickListener(this)


    }

    override fun onClick(viewIn: View) {

        var first = firstOperandET.text.toString()
        var second = secondOperandET.text.toString()

        if (firstOperandET.text.isEmpty() || secondOperandET.text.isEmpty()) {
            first = "0h0m0s"
            second = "0h0m0s"
        }

        when (viewIn.id) {
            R.id.sumBTN -> resultTV.text = Operation(first, second).sumTimes()
            R.id.difBTN -> resultTV.text = Operation(first, second).difTimes()
        }


    }
}