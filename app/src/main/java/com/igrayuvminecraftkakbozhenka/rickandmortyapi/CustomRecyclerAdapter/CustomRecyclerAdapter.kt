package com.igrayuvminecraftkakbozhenka.rickandmortyapi.CustomRecyclerAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.R
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.Character
import com.squareup.picasso.Picasso

class CustomRecyclerAdapter(private val characters: ArrayList<Character>): RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.person_image)
        var description: TextView = itemView.findViewById(R.id.description)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val characterDescription = "Name: " + characters[position].name + "\n" +
                "Gender: " + characters[position].gender + "\n" +
                "Species: " + characters[position].species + "\n" +
                "Status: " + characters[position].status + "\n"
        holder.description.text = characterDescription
        Picasso.get().load(characters[position].image).into(holder.image)
    }

    override fun getItemCount() = characters.size
}