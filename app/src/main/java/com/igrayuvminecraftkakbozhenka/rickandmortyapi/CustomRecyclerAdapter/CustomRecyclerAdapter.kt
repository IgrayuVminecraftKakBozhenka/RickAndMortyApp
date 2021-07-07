package com.igrayuvminecraftkakbozhenka.rickandmortyapi.CustomRecyclerAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.R
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.Character
import com.squareup.picasso.Picasso

class CustomRecyclerAdapter(private val characters: List<Character>): RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        lateinit var image: ImageView
        lateinit var description: TextView

        init {
            image = itemView.findViewById(R.id.person_image)
            description = itemView.findViewById(R.id.description)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.description.text = characters[position].name
        Picasso.get().load(characters[position].image).into(holder.image)
    }

    override fun getItemCount() = characters.size
}