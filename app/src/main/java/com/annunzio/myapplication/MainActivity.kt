package com.annunzio.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.btnRoll)


        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice rolled!", Toast.LENGTH_SHORT)
            toast.show()
            rollDice()

        }
        rollDice()
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRollOne = dice.roll()
        val diceImageOne: ImageView = findViewById(R.id.ivDiceOne)
        setDice(diceRollOne, diceImageOne)

        val diceTwo = Dice(6)
        val diceRollTwo = diceTwo.roll()
        val diceImageOTwo: ImageView = findViewById(R.id.ivDiceTwo)
        setDice(diceRollTwo, diceImageOTwo)

        if(diceRollOne + diceRollTwo == 7){ Toast.makeText(this,"You rolled 7, congrats you win!", Toast.LENGTH_LONG).show()}
        else{Toast.makeText(this, "You rolled a total of ${diceRollOne + diceRollTwo}.  You lose!", Toast.LENGTH_LONG).show()}
    }

    private fun setDice(diceRoll: Int, diceIV: ImageView){
        when(diceRoll){
            1 -> diceIV.setImageResource(R.drawable.dice_1)
            2 -> diceIV.setImageResource(R.drawable.dice_2)
            3 -> diceIV.setImageResource(R.drawable.dice_3)
            4 -> diceIV.setImageResource(R.drawable.dice_4)
            5 -> diceIV.setImageResource(R.drawable.dice_5)
            6 -> diceIV.setImageResource(R.drawable.dice_6)
        }
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}