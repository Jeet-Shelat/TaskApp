package com.example.grocerylistapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val groceryList: ArrayList<String>? = intent.getStringArrayListExtra("GROCERY_LIST")

        val textViewGroceryItem: TextView = findViewById(R.id.textViewGroceryItem)

        if (groceryList != null && groceryList.isNotEmpty()) {
            val displayText = groceryList.joinToString(separator = "\n")
            textViewGroceryItem.text = displayText
        } else {
            textViewGroceryItem.text = "No items in the list"
        }
    }
}
