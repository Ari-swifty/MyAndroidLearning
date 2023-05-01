package com.arigarasuthan.roomdemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arigarasuthan.roomdemoapp.databinding.ActivityMainBinding
import com.arigarasuthan.roomdemoapp.db.Subscriber
import com.arigarasuthan.roomdemoapp.db.SubscriberDataBase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var subscriberViewModel: SubscriberViewModel
    private lateinit var adapter: MyRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao = SubscriberDataBase.getInstance(this).subscriberDao
        val repo = SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repo)
        subscriberViewModel = ViewModelProvider(this, factory)[SubscriberViewModel::class.java]
        binding.myViewModel = subscriberViewModel
        binding.lifecycleOwner = this
        initRecyclerView()
        subscriberViewModel.message.observe(this){
            it.getContentIfNotHandled()?.let { msg->
                Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun initRecyclerView() {
        binding.subscriberList.layoutManager = LinearLayoutManager(this)
        adapter = MyRecyclerViewAdapter {selectedItem: Subscriber -> listItemClicked(selectedItem)  }
        binding.subscriberList.adapter = adapter
        displaySubscriberList()
    }

    private fun displaySubscriberList() {
        subscriberViewModel.subscribers.observe(this) { subscribersList ->
            Log.d("MyTag", subscribersList.toString())
            adapter.setList(subscribersList)
            adapter.notifyDataSetChanged()
        }
    }

    private fun listItemClicked(subscriber: Subscriber) {
        subscriberViewModel.initUpdateAndDelete(subscriber)
        //Toast.makeText(this, "Selected Name Is ${subscriber.name}", Toast.LENGTH_LONG).show()
    }
}