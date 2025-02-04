package com.example.rt_oct

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainScreenActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen)

        val searchContact: EditText = findViewById(R.id.search_contact)
        val dialpadIcon: ImageView = findViewById(R.id.dialpad_icon)
        val numberDisplay: EditText = findViewById(R.id.number_display)

        // Set Click Listener on dialpad icon
        dialpadIcon.setOnClickListener {
            if (numberDisplay.visibility == View.GONE) {
                numberDisplay.visibility = View.VISIBLE
            } else {
                numberDisplay.visibility = View.GONE
            }
        }

        dialpadIcon.setOnClickListener {
            numberDisplay.visibility = View.VISIBLE  // Show the EditText
            numberDisplay.requestFocus()  // Request focus

            // Show the keyboard
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(numberDisplay, InputMethodManager.SHOW_IMPLICIT)
        }



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

    // Hide keyboard when clicking outside of EditText
    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val view = currentFocus
            if (view is EditText) {
                val outRect = android.graphics.Rect()
                view.getGlobalVisibleRect(outRect)
                if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                    hideKeyboard()
                    view.clearFocus()
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }

    // Function to hide the keyboard
    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val view = currentFocus
        if (view != null) {
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    // Helper function to navigate between activities with custom animation
    private fun navigateTo(targetActivity: Class<*>) {
        val intent = Intent(this, targetActivity)
        val options = ActivityOptions.makeCustomAnimation(this, 0, 0)
        startActivity(intent, options.toBundle())
    }
}
