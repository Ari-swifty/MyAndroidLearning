package com.arigarasuthan.servicedemoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.arigarasuthan.servicedemoapp.MyBackgroundService.Companion.KEY_NAME
import com.arigarasuthan.servicedemoapp.MyBackgroundService.Companion.MARKS
import com.arigarasuthan.servicedemoapp.MyBackgroundService.Companion.TAG
import com.arigarasuthan.servicedemoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val serviceIntent = Intent(this,MyBackgroundService::class.java)
        serviceIntent.putExtra(KEY_NAME,"Arigarasuthan")
        serviceIntent.putExtra(MARKS,65)
        binding.apply {
            btnStart.setOnClickListener {
                Log.i(TAG,"Starting Service")
                startService(serviceIntent)
            }

            btnStop.setOnClickListener {
                Log.i(TAG,"Stopping Service")
                stopService(serviceIntent)
            }
        }
    }
}