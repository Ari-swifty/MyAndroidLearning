package com.arigarasuthan.navdemo1.codingchallenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.arigarasuthan.navdemo1.R
import com.arigarasuthan.navdemo1.databinding.ActivityCodingChallengeBinding

class CodingChallengeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCodingChallengeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coding_challenge)
    }
}