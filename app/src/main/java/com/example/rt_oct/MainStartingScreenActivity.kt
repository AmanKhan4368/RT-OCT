package com.example.rt_oct

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class MainStartingScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_starting_screen) // Set the layout for the main starting screen

        // Delay the transition to MainScreenActivity by 2 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            // Start the main screen activity after the delay
            navigateTo(MainScreenActivity::class.java)

            // Optionally finish the current activity to prevent it from being in the back stack
            finish()
        }, 2000) // 2000 milliseconds = 2 seconds
    }

    // A helper method to navigate to different activities, reducing code repetition
    private fun navigateTo(targetActivity: Class<*>) {
        val intent = Intent(this, targetActivity)
        startActivity(intent)
    }
}
