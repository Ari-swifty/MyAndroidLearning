package com.arigarasuthan.databindingapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import com.arigarasuthan.databindingapp.databinding.CodingChallengeBinding

class CodingChallengeActivity : AppCompatActivity() {
    private lateinit var binding: CodingChallengeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.coding_challenge)
        binding.apply {
            codProgressBar.visibility = View.GONE
            button.text = "Start"
            button.setOnClickListener {
                startOrStopProgressBar()
            }

        }
    }

    private fun startOrStopProgressBar() {
        binding.apply {
            if(codProgressBar.isGone)
            {
                    codProgressBar.visibility = View.VISIBLE
                    button.text = "Stop"
            }else {
                codProgressBar.visibility = View.GONE
                button.text = "Start"
            }
        }
    }
}