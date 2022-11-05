package com.antdev99.amazing_tips

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import com.antdev99.amazing_tips.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalculate.setOnClickListener {
            if (binding.costOfService.text!!.isNotEmpty()) {
                displayTotalAmount()
            }
        }

        binding.costOfService.setOnKeyListener{
            view, key, _ -> hideKeyBoard(view, key)
        }
    }

    private fun displayTotalAmount() {
        val totalAmount = NumberFormat.getCurrencyInstance().format(calculateTotalAmount())
        binding.resultTxt.text = getString(R.string.txtv_total_amount, totalAmount)
    }

    private fun calculateTotalAmount(): Double {
        val costValue = binding.costOfService.text.toString().toDouble();
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_15_percent -> 0.15
            R.id.option_18_percent -> 0.18
            else -> 0.20
        }
        var tip = costValue * tipPercentage;
        if (binding.roundUpTip.isChecked) {
            tip = kotlin.math.ceil(tip)
        }
        return tip
    }

    private fun hideKeyBoard(view: View, keyCode:Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER){
            val inputmethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputmethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}
