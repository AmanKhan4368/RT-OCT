package com.example.rt_oct

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CreateContactBottomSheet : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.create_contact, container, false)

        // Find the cancel button and set the click listener
        val cancelButton: ImageButton = view.findViewById(R.id.cancel_button)
        cancelButton.setOnClickListener {
            dismiss() // Close the bottom sheet
        }

        return view
    }
}
