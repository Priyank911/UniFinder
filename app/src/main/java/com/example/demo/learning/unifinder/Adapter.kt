package com.example.demo.learning.unifinder

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.learning.unifinder.databinding.ViewBinding

class Adapter(private val planet: List<PlanetData>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    class MyViewHolder(private val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.title
        val planetImg = binding.planetImg
        val galaxy = binding.galaxy
        val distance = binding.distance
        val gravity = binding.gravity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var dummyImage: Int = R.drawable.mars // Initialize with a default image

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, PlanetDetail::class.java)
            intent.putExtra("planet", planet[position])
            intent.putExtra("planetImage", dummyImage)
            holder.itemView.context.startActivity(intent)
        }

        holder.title.text = planet[position].title
        holder.galaxy.text = planet[position].galaxy
        holder.distance.text = planet[position].distance + " m km"
        holder.gravity.text = planet[position].title + " m/ss"

        dummyImage = when (planet[position].title?.toLowerCase()) {
            "mars" -> R.drawable.mars
            "neptune" -> R.drawable.neptune
            "earth" -> R.drawable.earth
            "moon" -> R.drawable.moon
            "venus" -> R.drawable.venus
            "jupiter" -> R.drawable.jupiter
            "saturn" -> R.drawable.saturn
            "uranus" -> R.drawable.uranus
            "mercury" -> R.drawable.mercury
            "sun" -> R.drawable.sun
            else -> dummyImage // Keep the default image if the planet name is not recognized
        }

        holder.planetImg.setImageResource(dummyImage)
    }

    override fun getItemCount(): Int {
        return planet.size
    }
}
