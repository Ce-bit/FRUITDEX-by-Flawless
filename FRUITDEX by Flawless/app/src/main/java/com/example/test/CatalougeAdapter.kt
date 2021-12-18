package com.example.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fruit_item.view.*
import models.Fruit

class CatalougeAdapter(
    private val fruits : List<Fruit>
    ) : RecyclerView.Adapter<CatalougeAdapter.FruitViewHolder>(){

    class FruitViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val IMAGE_BASE = "https://api.spoonacular.com/food/products/"
        fun bindFruit(fruit: Fruit){
            itemView.fruit_name.text = fruit.name
            itemView.fruit_family.text = fruit.family
            Glide.with(itemView).load(IMAGE_BASE + "banana/" + "nutritionLabel.png/?apiKey=d17305ebeaa24898a370216e0a2e0b6f").into(itemView.fruit_nutrition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        return FruitViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)
        )
    }

    override fun getItemCount(): Int = fruits.size

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        holder.bindFruit(fruits.get(position))
    }
}