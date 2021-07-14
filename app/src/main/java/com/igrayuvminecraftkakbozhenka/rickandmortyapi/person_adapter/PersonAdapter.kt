package com.igrayuvminecraftkakbozhenka.rickandmortyapi.person_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.R
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.Character
import com.squareup.picasso.Picasso

class PersonAdapter: RecyclerView.Adapter<PersonAdapter.MyViewHolder>() {

    private val characters: ArrayList<Character> = ArrayList()

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
        if (position == characters.size) {
            holder.image.setImageResource(R.drawable.plus)
            holder.description.setText(R.string.get_new_character)
            holder.itemView.setOnClickListener { it ->


            }
        } else {
            val characterDescription = "Name: " + characters[position].name + "\n" +
                    "Gender: " + characters[position].gender + "\n" +
                    "Species: " + characters[position].species + "\n" +
                    "Status: " + characters[position].status + "\n"
            holder.description.text = characterDescription
            Picasso.get().load(characters[position].image).into(holder.image)
        }
    }
    override fun getItemCount() = characters.size + 1

    fun setData(newCharacters: ArrayList<Character>) {
        characters.clear()
        characters.addAll(newCharacters)
        notifyDataSetChanged()
    }
}