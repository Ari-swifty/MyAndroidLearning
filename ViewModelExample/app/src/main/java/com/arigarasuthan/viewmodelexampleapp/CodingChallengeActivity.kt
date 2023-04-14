package com.arigarasuthan.viewmodelexampleapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.arigarasuthan.viewmodelexampleapp.databinding.ActivityCodingChallengeBinding

class CodingChallengeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCodingChallengeBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coding_challenge)
        viewModelFactory = MainActivityViewModelFactory(0)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainActivityViewModel::class.java]
        viewModel.totalData.observe(this, Observer {
            binding.outputTxt.text = "$it"
        })
        binding.apply {
            clickButton.setOnClickListener {
                if (inputTxt.text.isNotEmpty()) {
                    viewModel.updateInutValue(inputTxt.text.toString().toInt())
                }
            }
        }
    }
}