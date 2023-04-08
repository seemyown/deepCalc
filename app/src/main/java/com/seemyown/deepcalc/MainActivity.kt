package com.seemyown.deepcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView

    private var operand1: Double? = null
    private var operand2: Double? = null
    private var operation = " "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.result_text_view)

        val btn0: Button = findViewById(R.id.btn_0)
        val btn1: Button = findViewById(R.id.btn_1)
        val btn2: Button = findViewById(R.id.btn_2)
        val btn3: Button = findViewById(R.id.btn_3)
        val btn4: Button = findViewById(R.id.btn_4)
        val btn5: Button = findViewById(R.id.btn_5)
        val btn6: Button = findViewById(R.id.btn_6)
        val btn7: Button = findViewById(R.id.btn_7)
        val btn8: Button = findViewById(R.id.btn_8)
        val btn9: Button = findViewById(R.id.btn_9)
        val btnPlus: Button = findViewById(R.id.btn_plus)
        val btnMinus: Button = findViewById(R.id.btn_minus)
        val btnMultiply: Button = findViewById(R.id.btn_multiply)
        val btnDivide: Button = findViewById(R.id.btn_divide)
        val btnEquals: Button = findViewById(R.id.btn_equals)
        val btnDecimal: Button = findViewById(R.id.btn_decimal)
        val btnPlusMinus: Button = findViewById(R.id.btn_plus_minus)

        val listener = View.OnClickListener { v ->
            val btn = v as Button
            when (btn.id) {
                R.id.btn_0 -> numberClicked("0")
                R.id.btn_1 -> numberClicked("1")
                R.id.btn_2 -> numberClicked("2")
                R.id.btn_3 -> numberClicked("3")
                R.id.btn_4 -> numberClicked("4")
                R.id.btn_5 -> numberClicked("5")
                R.id.btn_6 -> numberClicked("6")
                R.id.btn_7 -> numberClicked("7")
                R.id.btn_8 -> numberClicked("8")
                R.id.btn_9 -> numberClicked("9")
                R.id.btn_decimal -> decimalClicked()
                R.id.btn_plus_minus -> plusMinusClicked()
                R.id.btn_plus -> operationClicked("+")
                R.id.btn_minus -> operationClicked("-")
                R.id.btn_multiply -> operationClicked("*")
                R.id.btn_divide -> operationClicked("/")
                R.id.btn_equals -> equalsClicked()
            }
        }

        btn0.setOnClickListener(listener)
        btn1.setOnClickListener(listener)
        btn2.setOnClickListener(listener)
        btn3.setOnClickListener(listener)
        btn4.setOnClickListener(listener)
        btn5.setOnClickListener(listener)
        btn6.setOnClickListener(listener)
        btn7.setOnClickListener(listener)
        btn8.setOnClickListener(listener)
        btn9.setOnClickListener(listener)
        btnDecimal.setOnClickListener(listener)
        btnPlusMinus.setOnClickListener(listener)
        btnPlus.setOnClickListener(listener)
        btnMinus.setOnClickListener(listener)
        btnMultiply.setOnClickListener(listener)
        btnDivide.setOnClickListener(listener)
        btnEquals.setOnClickListener(listener)
    }

    private fun numberClicked(number: String) {
        val currentValue = resultTextView.text.toString()
        resultTextView.text = if (currentValue == "0") number else "${currentValue}${number}"
    }

    private fun decimalClicked() {
        if (!resultTextView.text.contains(".")) {
            resultTextView.text = "${resultTextView.text}."
        }
    }

    private fun plusMinusClicked() {
        var currentValue = resultTextView.text.toString()
        if (currentValue.startsWith("-")) {
            currentValue = currentValue.substring(1)
        } else {
            currentValue = "-${currentValue}"
        }
        resultTextView.text = currentValue
    }

    private fun operationClicked(operation: String) {
        operand1 = resultTextView.text.toString().toDouble()
        this.operation = operation
        resultTextView.text = "0"
    }

    private fun equalsClicked() {
        if (operand1 == null) {
            return
        }

        val currentValue = resultTextView.text.toString().toDouble()
        var result = 0.0

        when (operation) {
            "+" -> result = operand1!! + currentValue
            "-" -> result = operand1!! - currentValue
            "*" -> result = operand1!! * currentValue
            "/" -> result = operand1!! / currentValue
        }

        val resultString = result.toString()
        if (resultString.endsWith(".0")) {
            resultTextView.text = result.toInt().toString()
        } else {
            resultTextView.text = resultString
        }
        operand1 = null
        operand2 = null
        operation = ""
    }
}









