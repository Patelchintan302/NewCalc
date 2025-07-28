package com.example.newcalc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.newcalc.databinding.ActivityMainBinding
import com.udojava.evalex.Expression
import android.util.Log
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import java.math.BigDecimal


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    lateinit var expression: TextView
    var isBracketPresent = false
    var mathExpression : String = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // Inside your Activity's onCreate method:
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { view, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())

            // insets.top will give you the height of the status bar
            // (which includes the space occupied by the battery indicator, time, etc.)
            view.updatePadding(top = insets.top)

            // If you also want to avoid the navigation bar at the bottom (for gestures or buttons)
            // view.updatePadding(bottom = insets.bottom)

            WindowInsetsCompat.CONSUMED
        }

        expression = binding.input
        expression.text = "0"

        binding.btn0.setOnClickListener { append('0') }
        binding.btn1.setOnClickListener { append('1') }
        binding.btn2.setOnClickListener { append('2') }
        binding.btn3.setOnClickListener { append('3') }
        binding.btn4.setOnClickListener { append('4') }
        binding.btn5.setOnClickListener { append('5') }
        binding.btn6.setOnClickListener { append('6') }
        binding.btn7.setOnClickListener { append('7') }
        binding.btn8.setOnClickListener { append('8') }
        binding.btn9.setOnClickListener { append('9') }
        binding.btnDot.setOnClickListener { append('.') }
        binding.braket.setOnClickListener {
            if(!isBracketPresent) {
                append('(')
                isBracketPresent = true
            }else {
                append(')')
                isBracketPresent = false
            }
        }
        binding.add.setOnClickListener { append('+') }
        binding.subtract.setOnClickListener { append('-') }
        binding.multiply.setOnClickListener { append('×') }
        binding.divide.setOnClickListener { append('÷') }
        binding.percent.setOnClickListener { append('%') }

        binding.clear.setOnClickListener { clear() }
        binding.backspace.setOnClickListener { backspace() }

        binding.equal.setOnClickListener { calculate() }

        binding.historybtn.setOnClickListener {
            if(binding.historyScroll.visibility == View.GONE) {
                binding.historyScroll.visibility = View.VISIBLE
                binding.historybtn.text = "History ▲"
            }else{
                binding.historyScroll.visibility = View.GONE
                binding.historybtn.text = "History ▼"
            }
        }

    }

    private fun calculate() {
        Log.d("TAG", "$mathExpression")

        try {
            if (mathExpression.isBlank() || mathExpression == "" || mathExpression == "0") {
                Log.d("TAG", "Blank Calculation")
                return
            }
            val exp = Expression(mathExpression)
            val result: BigDecimal = exp.eval()
            binding.history.text = binding.history.text.toString()+"\n"+expression.text.toString() + " = " + result.stripTrailingZeros().toPlainString()
            expression.text = result.stripTrailingZeros().toPlainString()
            mathExpression = result.stripTrailingZeros().toPlainString()
        }
        catch (e: Exception) {
            mathExpression = ""
            expression.text = "0"

        }

    }

    fun append(c : Char) {
        if(expression.text == "0") {
            expression.text = ""
        }
        when(c) {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', '(', ')', '+', '-', '%' -> {
                expression.text = (expression.text.toString() + c)
                mathExpression = "$mathExpression$c"
            }
            '×' -> {
                expression.text = (expression.text.toString() + c)
                mathExpression = "$mathExpression*"
            }
            '÷' -> {
                expression.text = (expression.text.toString() + c)
                mathExpression = "$mathExpression/"
            }
            else -> {}
        }
    }

    fun clear() {
        expression.text = "0"
        mathExpression = ""
        isBracketPresent = false
    }

    fun backspace() {
        val length = expression.text.length
        if(length > 1) {
            if(expression.text[length - 1] == ')') isBracketPresent = true
            if(expression.text[length - 1] == '(') isBracketPresent = false
            expression.text = expression.text.dropLast(1)
            mathExpression = mathExpression.dropLast(1)
        }else {
            expression.text = "0"
            mathExpression = ""
            isBracketPresent = false
        }

    }





}