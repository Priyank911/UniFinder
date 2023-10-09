package com.example.demo.learning.unifinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo.learning.unifinder.databinding.ActivityMainBinding
import com.example.demo.learning.unifinder.databinding.ActivityPlanetBinding

class planetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlanetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlanetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
        val adapter = Adapter(setData.SetPlanets())
        binding.myRecycler.adapter = adapter
        binding.myRecycler.layoutManager = LinearLayoutManager(this)
    }
}