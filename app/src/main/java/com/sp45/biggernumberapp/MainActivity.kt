package com.sp45.biggernumberapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sp45.biggernumberapp.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLeft.setOnClickListener {
            //code here will run everytime left button is clicked
            //1.Compare the numbers in the boxes
            checkAnswer(true)
            //2.Pick new numbers
            assignNumbersToButton()
        }
        binding.btnRight.setOnClickListener {
            //1. Compare the numbers in the boxes
            checkAnswer(false)
            //2. Pick new random numbers
            assignNumbersToButton()

        }
    }

    private fun checkAnswer(isLeftButtonSelected: Boolean) {
        val leftNum: Int = binding.btnLeft.text.toString().toInt()
        val rightNum: Int = binding.btnRight.text.toString().toInt()
        val isAnswerCorrect: Boolean =
            if (isLeftButtonSelected) leftNum > rightNum else rightNum > leftNum
        if (isAnswerCorrect) {
            //Correct answer
            //Change background color
            binding.backgroundView.setBackgroundColor(Color.GREEN)
            //show notification - toast
            Toast.makeText(applicationContext, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            //Wrong answer
            binding.backgroundView.setBackgroundColor(Color.RED)
            Toast.makeText(applicationContext, "Wrong!", Toast.LENGTH_SHORT).show()
        }

    }

    private fun assignNumbersToButton() {
        val leftNum: Int = Random.nextInt(0, 100)
        var rightNum: Int = leftNum
        while (rightNum == leftNum) {
            rightNum = Random.nextInt(0, 100)
        }
        binding.btnLeft.text = leftNum.toString()
        binding.btnRight.text = rightNum.toString()
    }
}