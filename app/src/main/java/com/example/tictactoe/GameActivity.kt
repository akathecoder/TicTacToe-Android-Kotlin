package com.example.tictactoe

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_game_screen.*


class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)

    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    fun btnClick(view: View) {
        val btnSelected = view as Button
        var btnID = 0
        when (btnSelected.id) {
            R.id.btnR0C0 -> btnID = 1
            R.id.btnR0C1 -> btnID = 2
            R.id.btnR0C2 -> btnID = 3
            R.id.btnR1C0 -> btnID = 4
            R.id.btnR1C1 -> btnID = 5
            R.id.btnR1C2 -> btnID = 6
            R.id.btnR2C0 -> btnID = 7
            R.id.btnR2C1 -> btnID = 8
            R.id.btnR2C2 -> btnID = 9
        }
        playGame(btnID, btnSelected)
    }

    @SuppressLint("SetTextI18n")
    fun playGame(btnId: Int, btnSelected: Button) {
        if (activePlayer == 1) {
            btnSelected.text = "X"
            btnSelected.setBackgroundColor(Color.parseColor("#eeeeee"))
            player1.add(btnId)
            activePlayer = 2
            nextPlayer.text = "Player 2"
        } else {
            btnSelected.text = "O"
            btnSelected.setBackgroundColor(Color.parseColor("#eeeeee"))
            player2.add(btnId)
            activePlayer = 1
            nextPlayer.text = "Player 1"
        }
        btnSelected.isEnabled = false
        checkWinner()
    }

    fun checkWinner(){
        var winner = 0

        if (player1.size + player2.size == 9){
            declareWinner(winner)
        }

        // Row 0
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner=1
            declareWinner(winner)
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner=2
            declareWinner(winner)
        }

        // row 1
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner=1
            declareWinner(winner)
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner=2
            declareWinner(winner)
        }

        // row 2
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner=1
            declareWinner(winner)
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner=2
            declareWinner(winner)
        }

        // col 0
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner=1
            declareWinner(winner)
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner=2
            declareWinner(winner)
        }

        // col 1
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner=1
            declareWinner(winner)
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner=2
            declareWinner(winner)
        }

        // col 2
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner=1
            declareWinner(winner)
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner=2
            declareWinner(winner)
        }

        //diagonal forward-slash
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner=1
            declareWinner(winner)
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner=2
            declareWinner(winner)
        }

        //diagonal slash
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner=1
            declareWinner(winner)
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner=2
            declareWinner(winner)
        }

    }

    fun declareWinner(winner:Int){
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("winner", winner)
        startActivity(intent)
        finish()
    }
}