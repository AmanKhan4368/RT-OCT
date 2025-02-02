package com.example.rt_oct

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class ForgotPasswordScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forgot_password_screen) // Ensure this is correct

        val backArrowButton = findViewById<ImageButton>(R.id.back_arrow_icon)
        backArrowButton.setOnClickListener {
            val intent = Intent(this, SignInScreenActivity::class.java)
            startActivity(intent)
            finish() // Optional: Closes ForgotPasswordActivity to prevent going back
        }
    }
}
