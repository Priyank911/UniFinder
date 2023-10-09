package com.example.demo.learning.unifinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    private lateinit var planetCard: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        planetCard = findViewById(R.id.planetCard)

        planetCard.setOnClickListener {
            val intent = Intent(this@MainActivity, planetActivity::class.java)
            startActivity(intent)
        }
    }
}
