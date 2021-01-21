package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val score:Int = intent.getIntExtra("score", 0)
        val name: String? = intent.getStringExtra("username").toString()

        tv_name.text = "$name,"
        tv_score.text = "you got $score"
        btn_main.setOnClickListener {
            ActivityCompat.finishAffinity(this)
            val main = Intent(this, MainActivity::class.java)
            startActivity(main)
            finish()
        }
    }
}