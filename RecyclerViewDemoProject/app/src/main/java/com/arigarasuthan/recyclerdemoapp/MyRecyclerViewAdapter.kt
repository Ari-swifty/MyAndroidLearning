package com.arigarasuthan.recyclerdemoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(private val fruitList:List<Fruit>,private val clickListener:(Fruit)->Unit) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item,parent,false)
        return MyViewHolder(listItem)
    }

    override fun getItemCount(): Int = fruitList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(fruitList[position],clickListener)
    }
}
class MyViewHolder(val view:View):RecyclerView.ViewHolder(view) {
    fun bind(fruit: Fruit,clickListener:(Fruit)->Unit) {
        val myTextView = view.findViewById<TextView>(R.id.tv_name)
        myTextView.text = fruit.name

        view.setOnClickListener {
            clickListener(fruit)
        }
    }

}