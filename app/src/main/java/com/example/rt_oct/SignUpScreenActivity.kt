package com.example.rt_oct

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.content.Intent
import android.widget.Button

class SignUpScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_screen) // Set the layout for the Sign Up screen

        // Initialize TextView and Button once
        val signInText: TextView = findViewById(R.id.sign_in_text)
        val signUpButton: Button = findViewById(R.id.sign_up_button)

        // Set click listeners for both elements
        signInText.setOnClickListener { navigateTo(SignInScreenActivity::class.java) }
        signUpButton.setOnClickListener { navigateTo(MainStartingScreenActivity::class.java) }
    }

    // A helper method to navigate to different activities, reducing code repetition
    private fun navigateTo(targetActivity: Class<*>) {
        val intent = Intent(this, targetActivity)
        startActivity(intent)
    }
}
