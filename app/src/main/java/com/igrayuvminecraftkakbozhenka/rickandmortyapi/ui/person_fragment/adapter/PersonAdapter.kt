package com.igrayuvminecraftkakbozhenka.rickandmortyapi.ui.person_fragment.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.R
import com.igrayuvminecraftkakbozhenka.rickandmortyapi.domain.models.Character
import com.squareup.picasso.Picasso

class PersonAdapter(private val listener: PersonListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val characters: ArrayList<Character> = ArrayList()

    //abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //    abstract var image: ImageView
    //    abstract var description: TextView
    //}

    inner class PersonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.person_image)
        var description: TextView = itemView.findViewById(R.id.description)
    }

    inner class AddPersonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
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



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_item, parent, false)
        lateinit var holder: RecyclerView.ViewHolder
        Log.d("debug", "${viewType}")
        when(viewType) {
            0 -> holder = AddPersonViewHolder(itemView)
            1 -> holder = PersonViewHolder(itemView)
        }
        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("debug", "${holder.itemViewType}/ ${position}")
        when(holder.itemViewType) {
            0 -> {
                val addPersonHolder = holder as AddPersonViewHolder
                addPersonHolder.bind()
            }
            1 -> {
                val personHolder = holder as PersonViewHolder
                val characterDescription = "Name: " + characters[position].name + "\n" +
                            "Gender: " + characters[position].gender + "\n" +
                            "Species: " + characters[position].species + "\n" +
                            "Status: " + characters[position].status + "\n"
                    personHolder.description.text = characterDescription
                    Picasso.get().load(characters[position].image).into(holder.image)
            }
        }



        //if (position == characters.size) {
        //    holder.bind()
        //} else {
        //    (holder as PersonViewHolder)
        //    val characterDescription = "Name: " + characters[position].name + "\n" +
        //            "Gender: " + characters[position].gender + "\n" +
        //            "Species: " + characters[position].species + "\n" +
        //            "Status: " + characters[position].status + "\n"
        //    holder.description.text = characterDescription
        //    Picasso.get().load(characters[position].image).into(holder.image)
        //}
    }

    override fun getItemViewType(position: Int): Int {
        Log.d("debug", "${itemCount}, ${position}")
        if (position == itemCount - 1) {
            return 0
        }
        return 1
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

