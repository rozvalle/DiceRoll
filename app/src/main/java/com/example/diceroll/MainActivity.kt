package com.example.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.*;
import android.view.animation.AnimationUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var btnRoll: Button = findViewById(R.id.btnRoll)
        btnRoll.setOnClickListener() {
            //Toast.makeText(this,"Dice Rolled!",Toast.LENGTH_SHORT).show()
            rollDice()
        }
    }

    var totalRolled = 0

    private fun diceRolled(dice: ImageView): Int {
        val randomInt = Random().nextInt(6) + 1
        val animationRotate = AnimationUtils.loadAnimation(this, R.anim.rotate)
        dice.startAnimation(animationRotate)

        var imgResources = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }

        dice.setImageResource(imgResources)
        return randomInt
    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1
        var imgDice: ImageView = findViewById(R.id.imgDice)
        var imgDice2: ImageView = findViewById(R.id.imgDice2)
        var txtResult: TextView = findViewById(R.id.txtResult)
        var result = 0;

        result = diceRolled(imgDice) + diceRolled(imgDice2)
        txtResult.text = result.toString()

    }
}