package com.example.calculatoroftime

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var toolbarMain: Toolbar

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

        toolbarMain = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)
        title = "Калькулятор времени"
        toolbarMain.subtitle = "версия 2"
        toolbarMain.setLogo(R.drawable.logo_time_48)

        firstOperandET = findViewById(R.id.firstOperandET)
        secondOperandET = findViewById(R.id.secondOperandET)
        sumBTN = findViewById(R.id.sumBTN)
        difBTN = findViewById(R.id.difBTN)
        resultTV = findViewById(R.id.resultTV)

        sumBTN.setOnClickListener(this)
        difBTN.setOnClickListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.resetMenuMain -> {
                firstOperandET.text.clear()
                secondOperandET.text.clear()
                resultTV.text = "Результат"
                resultTV.setTextColor(getColor(R.color.black))
                Toast.makeText(
                    applicationContext,
                    "Данные очищены",
                    Toast.LENGTH_LONG
                ).show()
            }

            R.id.exitMenuMain -> {
                finish()
                Toast.makeText(
                    applicationContext,
                    "Приложение закрыто",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onClick(viewIn: View) {

        val colorResult = getColor(R.color.red)

        var first = firstOperandET.text.toString()
        var second = secondOperandET.text.toString()

        if (firstOperandET.text.isEmpty() || secondOperandET.text.isEmpty()) {
            first = "0h0m0s"
            second = "0h0m0s"
        }

        when (viewIn.id) {
            R.id.sumBTN -> {
                resultTV.text = Operation(first, second).sumTimes()
                resultTV.setTextColor(colorResult)
                Toast.makeText(
                    applicationContext,
                    "Результат: ${resultTV.text}",
                    Toast.LENGTH_LONG
                ).show()
            }

            R.id.difBTN -> {
                resultTV.text = Operation(first, second).difTimes()
                resultTV.setTextColor(colorResult)
                Toast.makeText(
                    applicationContext,
                    "Результат: ${resultTV.text}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }


    }
}