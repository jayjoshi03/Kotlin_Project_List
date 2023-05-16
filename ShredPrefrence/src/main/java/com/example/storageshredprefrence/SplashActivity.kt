package com.example.storageshredprefrence

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.storageshredprefrence.prefrences.PreManager

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Thread(Runnable{
            Thread.sleep(3000)

            var manager = PreManager(this)
            var status = manager.getLoginStatus()

            if(status){
                // navigate to Home
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }else{
                //navigate to login
                startActivity(Intent(this,LoginActivity::class.java))
            }

        }).start()
    }
}