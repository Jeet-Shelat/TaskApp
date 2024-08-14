package com.example.grocerylistapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val groceryList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextGroceryItem: EditText = findViewById(R.id.editTextGroceryItem)
        val buttonAdd: Button = findViewById(R.id.buttonAdd)
        val buttonViewList: Button = findViewById(R.id.buttonViewList)

        buttonAdd.setOnClickListener {
            val groceryItem = editTextGroceryItem.text.toString()

            if (groceryItem.isEmpty()) {
                editTextGroceryItem.error = "Please enter a grocery item"
                return@setOnClickListener
            }

            groceryList.add(groceryItem)
            editTextGroceryItem.text.clear()
            Toast.makeText(this, "$groceryItem added to the list", Toast.LENGTH_SHORT).show()
        }

        buttonViewList.setOnClickListener {
            val intent = Intent(this, DisplayActivity::class.java).apply {
                putStringArrayListExtra("GROCERY_LIST", ArrayList(groceryList))
            }
            startActivity(intent)
        }
    }
}
