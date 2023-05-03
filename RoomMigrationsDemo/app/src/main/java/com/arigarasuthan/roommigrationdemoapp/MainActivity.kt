package com.arigarasuthan.roommigrationdemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.arigarasuthan.roommigrationdemoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var studentViewModel: StudentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val dao = StudentDataBase.getInstance(this).studentDAO
        val studentRepo = StudentRepo(dao)
        val factory = StudentViewModelFactory(studentRepo)
        studentViewModel = ViewModelProvider(this,factory)[StudentViewModel::class.java]
        binding.myViewModel = studentViewModel
        binding.lifecycleOwner = this
    }
}