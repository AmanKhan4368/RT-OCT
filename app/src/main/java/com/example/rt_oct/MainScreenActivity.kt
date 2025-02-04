package com.example.rt_oct

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainScreenActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen)

        val searchContact: EditText = findViewById(R.id.search_contact)

        searchContact.setOnTouchListener { view, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val drawableEnd = searchContact.compoundDrawablesRelative[2] // Get drawableEnd icon
                if (drawableEnd != null) {
                    val drawableEndX = searchContact.right - searchContact.paddingEnd - drawableEnd.bounds.width()
                    if (event.rawX >= drawableEndX) {
                        // Open BottomSheetDialogFragment when clicked
                        val bottomSheet = CreateContactBottomSheet()
                        bottomSheet.show(supportFragmentManager, "CreateContactBottomSheet")

                        view.performClick()
                        return@setOnTouchListener true
                    }
                }
            }
            false
        }

        // Set up click listeners for icon buttons with custom animations
        findViewById<TextView>(R.id.recent_icon).setOnClickListener { navigateTo(MainScreenActivity::class.java) }
        findViewById<TextView>(R.id.contact_icon).setOnClickListener { navigateTo(ContactScreenActivity::class.java) }
    }

    // Helper function to navigate between activities with custom animation
    private fun navigateTo(targetActivity: Class<*>) {
        val intent = Intent(this, targetActivity)
        val options = ActivityOptions.makeCustomAnimation(this, 0, 0)
        startActivity(intent, options.toBundle())
    }
}
