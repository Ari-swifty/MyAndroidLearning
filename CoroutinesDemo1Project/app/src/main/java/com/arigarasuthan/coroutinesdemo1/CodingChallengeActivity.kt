package com.arigarasuthan.coroutinesdemo1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.arigarasuthan.coroutinesdemo1.databinding.ActivityCodingChallengeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CodingChallengeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCodingChallengeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_coding_challenge)
        binding.launchButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                Log.i("CodingChallenge","${Thread.currentThread().name}")

            }
            CoroutineScope(Dispatchers.Main).launch {
                Log.i("CodingChallenge","${Thread.currentThread().name}")

            }
        }
    }
}