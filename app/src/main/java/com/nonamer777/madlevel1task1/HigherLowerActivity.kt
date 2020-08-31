package com.nonamer777.madlevel1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nonamer777.madlevel1task1.databinding.ActivityHigherLowerBinding

class HigherLowerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHigherLowerBinding
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHigherLowerBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initViews()
    }

    /** Set the initial (UI) state of the game. */
    private fun initViews() {
        updateUI()

        binding.btnLower.setOnClickListener {
            onLowerClick()
        }

        binding.btnEquals.setOnClickListener {
            onEqualsClick()
        }

        binding.btnHigher.setOnClickListener {
            onHigherClick()
        }
    }

    /** Calls `rollDice` and checks if the user guested right. */
    private fun onLowerClick() {
        rollDice()

        if (lastThrow > currentThrow) onAnswerCorrect()
        else onAnswerIncorrect()
    }

    /** Calls `rollDice` and checks if the user guested right. */
    private fun onEqualsClick() {
        rollDice()

        if (lastThrow == currentThrow) onAnswerCorrect()
        else onAnswerIncorrect()
    }

    /** Calls `rollDice` and checks if the user guested right. */
    private fun onHigherClick() {
        rollDice()

        if (lastThrow < currentThrow) onAnswerCorrect()
        else onAnswerIncorrect()
    }

    /** Displays a successful Toast message. */
    private fun onAnswerCorrect() =
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show()

    /** Displays a successful Toast message. */
    private fun onAnswerIncorrect() =
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_LONG).show()

    /**
     * Replaces the previous dice roll with the current one and replaces the current dice roll
     * with a new dice roll.
     */
    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()

        updateUI()
    }

    /** update the last throw text and the dice image resource drawable with the current throw. */
    private fun updateUI() {
        binding.tvLastThrown.text = getString(R.string.last_throw_label, lastThrow)

        when(currentThrow) {
            1 -> binding.imgCurrentThrow.setImageResource(R.drawable.dice1)
            2 -> binding.imgCurrentThrow.setImageResource(R.drawable.dice2)
            3 -> binding.imgCurrentThrow.setImageResource(R.drawable.dice3)
            4 -> binding.imgCurrentThrow.setImageResource(R.drawable.dice4)
            5 -> binding.imgCurrentThrow.setImageResource(R.drawable.dice5)
            6 -> binding.imgCurrentThrow.setImageResource(R.drawable.dice6)
        }
    }
}