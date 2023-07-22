package com.arigarasuthan.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
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
            val bundle = Bundle()
            bundle.putString("Key_myValue",textValue)
            val nav = findNavController(R.id.fragmentContainerView)
            nav.navigate(R.id.blank2,bundle)
//             val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
//             val navController = navHostFragment.navController
//              navController.navigateUp()
//              navController.navigate(R.id.blank2)
//            val fragmentManager = supportFragmentManager
//            val fragmentTransaction = fragmentManager.beginTransaction()
//            val fragment = BlankFragment()
//
//            val bundle = Bundle()
//            bundle.putString("Key_myValue",textValue)
//            fragment.arguments = bundle
//            fragmentTransaction.replace(R.id.fragment_container,fragment).commit()

        }



        // var sampleData = SampleData("Hello World")
    }

    fun sliceList(collection:List<Int>,limit:Int) {
        val collection = collection.withIndex().groupBy { indexeValue->
            indexeValue / limit
        }.map {
            it.value.map { it.value }
        }
    }




}