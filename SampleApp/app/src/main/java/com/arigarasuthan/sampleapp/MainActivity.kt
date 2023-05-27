package com.arigarasuthan.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.arigarasuthan.sampleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var textValue:String = ""
    private lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MyViewModel::class.java]
        viewModel.getString()
        viewModel.stringValue.observe(this) {value->
            Log.d("PrintTheValue",value)
            var sampleData = SampleData(value)
            textValue = value
            binding.myValue = sampleData
        }

        binding.button1.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            val fragment = BlankFragment()

            val bundle = Bundle()
            bundle.putString("Key_myValue",textValue)
            fragment.arguments = bundle
            fragmentTransaction.add(fragment,"").commit()

        }



        // var sampleData = SampleData("Hello World")
    }

    fun getString() {

    }


}