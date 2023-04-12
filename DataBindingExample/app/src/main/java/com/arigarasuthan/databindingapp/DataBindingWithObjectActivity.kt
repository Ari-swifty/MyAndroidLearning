package com.arigarasuthan.databindingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.arigarasuthan.databindingapp.databinding.DataBindingIntoObjectBinding
import com.arigarasuthan.databindingapp.model.Student

class DataBindingWithObjectActivity :AppCompatActivity() {
    private lateinit var bindingIntoObjectBinding: DataBindingIntoObjectBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingIntoObjectBinding = DataBindingUtil.setContentView(this,R.layout.data_binding_into_object)
        bindingIntoObjectBinding.student = getStudent()
    }

    private fun getStudent():Student = Student(1,"Arigarasuthan","suthan@gmail.com")
}