package com.example.demo.learning.unifinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.demo.learning.unifinder.databinding.ActivityPlanetDetailBinding

class PlanetDetail : AppCompatActivity() {
    private lateinit var binding: ActivityPlanetDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlanetDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        window.decorView.apply {
            systemUiVisibility =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        val obj = intent.getParcelableExtra("planet") as? PlanetData
        val planetImg = intent.getIntExtra("planetImage", -1)
        setData(obj, planetImg)

        binding.buttonInfo.setOnClickListener {
            val intent = Intent(this, finalActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setData(obj: PlanetData?, planetImg: Int) {
        if (obj != null) {
            binding.titleInfo.text = obj.title
            binding.distanceInfo.text = "${obj.distance} m km"
            binding.gravityInfo.text = "${obj.gravity} m/ss"
            binding.overviewInfo.text = obj.overview
            binding.galaxyInfo.text = obj.galaxy
            binding.planetImgInfo.setImageResource(planetImg)
        }
    }
}
