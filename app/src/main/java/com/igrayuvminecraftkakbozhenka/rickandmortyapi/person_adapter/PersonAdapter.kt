package com.igrayuvminecraftkakbozhenka.rickandmortyapi.person_adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.R
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.common.Character
import com.squareup.picasso.Picasso

class PersonAdapter(private val listener: PersonListener): RecyclerView.Adapter<PersonAdapter.MyViewHolder>() {

    private val characters: ArrayList<Character> = ArrayList()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.person_image)
        var description: TextView = itemView.findViewById(R.id.description)

        fun bind() {
            image.setImageResource(R.drawable.plus)
            description.setText(R.string.get_random_character)
            itemView.setOnClickListener { it ->
                Log.d("click", "апчихба")
                listener.getOnceRandomCharacter()

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (position == characters.size) {
            holder.bind()
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

    fun setDataList(newCharacters: ArrayList<Character>) {
        characters.clear()
        characters.addAll(newCharacters)
        notifyDataSetChanged()
    }

    fun setOneCharacter(character: Character) {
        characters.add(character)
        notifyDataSetChanged()
    }

    interface PersonListener {
        fun getOnceRandomCharacter()
    }
}

