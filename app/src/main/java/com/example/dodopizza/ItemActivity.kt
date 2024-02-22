package com.example.dodopizza

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val image: ImageView = findViewById(R.id.item_list_image_one)
        val title: TextView = findViewById(R.id.item_list_title_one)
        val text: TextView = findViewById(R.id.item_list_text)
        val price: TextView = findViewById(R.id.button_buy)
        val backButton: Button = findViewById(R.id.back_button)


        val itemImageResId = intent.getIntExtra("itemImage", 0)
        if (itemImageResId != 0) {
            image.setImageResource(itemImageResId)
        }
        title.text = intent.getStringExtra("itemTitle")
        text.text = intent.getStringExtra("itemText")
        price.text = intent.getStringExtra("itemPrice")

        backButton.setOnClickListener {
            // Navigate back to MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Optional: close this activity so it's removed from the back stack
        }
    }
}