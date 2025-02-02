package com.example.rt_oct

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignInScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_in_screen) // Set the layout for the Sign In screen

        // Initialize views once
        val signUpText: TextView = findViewById(R.id.sign_up_text)
        val forgotPasswordText: TextView = findViewById(R.id.forgot_password)
        val signInButton: TextView = findViewById(R.id.sign_in_button)

        // Set click listeners for each element
        signUpText.setOnClickListener { navigateTo(SignUpScreenActivity::class.java) }
        forgotPasswordText.setOnClickListener { navigateTo(ForgotPasswordScreenActivity::class.java) }
        signInButton.setOnClickListener { navigateTo(MainStartingScreenActivity::class.java) }
    }

    // A helper method to navigate to different activities, reducing code repetition
    private fun navigateTo(targetActivity: Class<*>) {
        val intent = Intent(this, targetActivity)
        startActivity(intent)
    }
}
