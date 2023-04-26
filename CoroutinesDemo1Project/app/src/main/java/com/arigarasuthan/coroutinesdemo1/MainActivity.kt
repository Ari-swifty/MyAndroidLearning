package com.arigarasuthan.coroutinesdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.arigarasuthan.coroutinesdemo1.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.apply {
            btnCount.setOnClickListener {
                tvCount.text = count++.toString()
            }
            downloadUserData.setOnClickListener {
                CoroutineScope(Dispatchers.Main).launch {
                    //tvMessage.text = UserDataManager().getTotalUserCount().toString()
                    tvMessage.text = UserDataManager2().getTotalUserCount().toString()
                }
            }
        }
    }

    private suspend fun downloadUserDataValue() {
        for(i in 1..200000)
        {
            withContext(Dispatchers.Main){
                binding.tvMessage.text = "Downloading user $i in ${Thread.currentThread().name}"
            }
        }
    }
}