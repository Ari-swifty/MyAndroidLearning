package com.arigarasuthan.roommigrationdemoapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class StudentViewModelFactory(private val studentRepo: StudentRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(StudentViewModel::class.java))
        {
            return StudentViewModel(studentRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}