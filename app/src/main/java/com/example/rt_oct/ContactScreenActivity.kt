package com.example.rt_oct

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContactScreenActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_screen)

        val searchContact: EditText = findViewById(R.id.search_contact)
        searchContact.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(view: View, event: MotionEvent): Boolean {
                if (event.action == MotionEvent.ACTION_UP) {
                    val drawableEnd = searchContact.compoundDrawablesRelative[2] // Get drawableEnd icon
                    if (drawableEnd != null) {
                        val drawableEndX = searchContact.right - searchContact.paddingEnd - drawableEnd.bounds.width()
                        if (event.rawX >= drawableEndX) {
                            // Open BottomSheetDialogFragment when clicked
                            val bottomSheet = CreateContactBottomSheet()
                            bottomSheet.show(supportFragmentManager, "CreateContactBottomSheet")

                            // Perform click for accessibility
                            view.performClick()
                            return true
                        }
                    }
                }
                return false
            }
        })

        // Override performClick to remove warning
        searchContact.setOnClickListener {
            // Handle normal clicks if needed
        }

        // Example: Open MainScreenActivity when recent is clicked
        val recentButton: TextView = findViewById(R.id.recent_icon)
        recentButton.setOnClickListener {
            val intent = Intent(this, MainScreenActivity::class.java)
            val options = ActivityOptions.makeCustomAnimation(this, 0, 0) // No animation
            startActivity(intent, options.toBundle())
        }

        // Example: Open ContactScreenActivity when contact is clicked
        val contactButton: TextView = findViewById(R.id.contact_icon)
        contactButton.setOnClickListener {
            val intent = Intent(this, ContactScreenActivity::class.java)
            val options = ActivityOptions.makeCustomAnimation(this, 0, 0)
            startActivity(intent, options.toBundle())
        }
    }
}
