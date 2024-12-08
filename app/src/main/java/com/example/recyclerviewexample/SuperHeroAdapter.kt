package com.example.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewexample.databinding.SuperheroeslayoutBinding

class SuperHeroAdapter(private val superHeroes: List<SuperHero>, private val superHeroClickListener: (SuperHero) -> Unit): RecyclerView.Adapter<SuperHeroAdapter.ViewHolder>() {


    class ViewHolder (val binding: SuperheroeslayoutBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(superHero: SuperHero) {
            binding.textViewHeroe.text = superHero.nombre
            Glide.with(binding.root.context).load(superHero.cover).into(binding.imageHeroe)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroAdapter.ViewHolder {
       val binding = SuperheroeslayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SuperHeroAdapter.ViewHolder, position: Int) {
        val superHero = superHeroes[position]
        holder.bind(superHero)
        holder.itemView.setOnClickListener {
            superHeroClickListener(superHero)
        }
    }

    override fun getItemCount(): Int = superHeroes.size


}

//    class SuperHeroClickListener {
//        fun onSuperHeroClicked(superHero: SuperHero){
//
//        }
//    }