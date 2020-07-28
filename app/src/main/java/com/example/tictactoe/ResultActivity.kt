package com.example.tictactoe

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val winSound: MediaPlayer = MediaPlayer.create(this, R.raw.win_sound)
        val drawSound: MediaPlayer = MediaPlayer.create(this, R.raw.draw_sound)

        val winner = intent.getIntExtra("winner", 0)
        if (winner == 0) {
            drawSound.start()
            image.setImageResource(R.drawable.draw)
            resultText.text = "Match Draw"
        } else {
            winSound.start()
            resultText.text = "Player $winner Wins"
        }

        replayBtn.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
            drawSound.stop()
            winSound.stop()
            finish()
        }
    }
}