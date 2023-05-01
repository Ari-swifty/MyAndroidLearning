package com.arigarasuthan.roomdemoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.arigarasuthan.roomdemoapp.databinding.ListItemBinding
import com.arigarasuthan.roomdemoapp.db.Subscriber

class MyRecyclerViewAdapter(private val clickListener:(Subscriber)->Unit) : RecyclerView.Adapter<MyViewHolder>(){
    private val subscribers =  ArrayList<Subscriber>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding:ListItemBinding = DataBindingUtil.inflate(layoutInflater,R.layout.list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = subscribers.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(subscribers[position],clickListener)
    }
    fun setList(subscribersList:List<Subscriber>) {
        subscribers.clear()
        subscribers.addAll(subscribersList)
    }
}
class MyViewHolder(val binding:ListItemBinding) : RecyclerView.ViewHolder(binding.root)
{
    fun bind(subscriber: Subscriber,clickListener:(Subscriber)->Unit) {
        binding.nameText.text = subscriber.name
        binding.emailText.text = subscriber.email
        binding.listItemLayout.setOnClickListener {
            clickListener(subscriber)
        }
    }
}