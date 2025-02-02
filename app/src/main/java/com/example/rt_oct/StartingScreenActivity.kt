package com.example.rt_oct

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class StartingScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.starting_screen) // Set the layout for the starting screen

        // Initialize the buttons only once and set up their click listeners
        val signUpButton: Button = findViewById(R.id.sign_up_button)
        val signInButton: Button = findViewById(R.id.sign_in_button)

        // Use a common method to handle button clicks to reduce repetition
        signUpButton.setOnClickListener { navigateTo(SignUpScreenActivity::class.java) }
        signInButton.setOnClickListener { navigateTo(SignInScreenActivity::class.java) }
    }

    // A helper method to handle screen transitions, reducing code repetition
    private fun navigateTo(targetActivity: Class<*>) {
        startActivity(Intent(this, targetActivity))
    }
}
