package com.arigarasuthan.coroutinesdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.arigarasuthan.coroutinesdemo1.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
                CoroutineScope(Dispatchers.IO).launch {
                    downloadUserDataValue()
                }
            }
        }
    }

    private fun downloadUserDataValue() {
        for(i in 1..200000)
        {
            Log.i("MyTag","Downloading user $i in ${Thread.currentThread().name}")
        }
    }
}