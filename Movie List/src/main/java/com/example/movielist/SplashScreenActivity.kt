package com.example.movielist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Thread{
            Thread.sleep(2000)
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }.start()
    }
}