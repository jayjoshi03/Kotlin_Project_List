package com.example.storageshredprefrence

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedDispatcher
import com.example.storageshredprefrence.databinding.ActivitySignUpBinding
import com.example.storageshredprefrence.prefrences.PreManager

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSingup.setOnClickListener {

            val name = binding.etName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            register(name, email, password)
        }
    }

    private fun register(name: String, email: String, password: String) {
        val manager = PreManager(this)
        manager.registerUser(name,email,password)

        startActivity(Intent(this, LoginActivity::class.java))
        Toast.makeText(this, "Register SuccessFully", Toast.LENGTH_SHORT).show()
    }

}