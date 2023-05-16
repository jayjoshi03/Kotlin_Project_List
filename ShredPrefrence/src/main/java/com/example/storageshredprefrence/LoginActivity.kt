package com.example.storageshredprefrence

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.storageshredprefrence.databinding.ActivityLoginBinding
import com.example.storageshredprefrence.prefrences.PreManager

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            login(email, password)
        }

        binding.btnSignup.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

    private fun login(email: String, password: String) {
        val manager = PreManager(this)
        val mEmail = manager.getEmail()
        val mPassword = manager.getPassword()

        if(mEmail!=null && mPassword!=null){
            if(mEmail == email && mPassword==password){
                var manager = PreManager(this)
                manager.updateLoginStatus(true)
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }else{
                Toast.makeText(this, "Invalid Login!", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this, "Create Account First", Toast.LENGTH_SHORT).show()
        }
    }
}

