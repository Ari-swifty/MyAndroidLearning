package com.arigarasuthan.roomdemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arigarasuthan.roomdemoapp.databinding.ActivityMainBinding
import com.arigarasuthan.roomdemoapp.db.SubscriberDataBase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var subscriberViewModel: SubscriberViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val dao = SubscriberDataBase.getInstance(this).subscriberDao
        val repo = SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repo)
        subscriberViewModel = ViewModelProvider(this,factory)[SubscriberViewModel::class.java]
        binding.myViewModel = subscriberViewModel
        binding.lifecycleOwner = this
        initRecyclerView()
    }

    private fun initRecyclerView()
    {
        binding.subscriberList.layoutManager = LinearLayoutManager(this)
        displaySubscriberList()
    }

    private fun displaySubscriberList()
    {
        subscriberViewModel.subscribers.observe(this) { subscribersList ->
            Log.d("MyTag",subscribersList.toString())
            binding.subscriberList.adapter = MyRecyclerViewAdapter(subscribersList)
        }
    }
}