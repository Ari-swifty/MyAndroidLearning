package com.arigarasuthan.databindingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.arigarasuthan.databindingapp.databinding.CodingChallengeTwoWayBinding

class CodingChallengeTwoWay : AppCompatActivity() {
    private lateinit var binding:CodingChallengeTwoWayBinding
    private lateinit var viewModel: TwoWayViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.coding_challenge_two_way)
        viewModel = ViewModelProvider(this)[TwoWayViewModel::class.java]
        binding.myViewModel = viewModel
        binding.lifecycleOwner = this
    }
}