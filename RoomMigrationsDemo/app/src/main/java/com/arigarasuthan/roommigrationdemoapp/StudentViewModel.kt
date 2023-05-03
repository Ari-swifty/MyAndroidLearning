package com.arigarasuthan.roommigrationdemoapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class StudentViewModel(private val studentRepo: StudentRepo) : ViewModel() {
    val studentName = MutableLiveData<String>()
    val studentEmail = MutableLiveData<String>()
    val courseName = MutableLiveData<String>()

    fun submit() {
        inserStudent(Student(0, studentName.value ?: "", courseName.value ?: ""))
        studentName.value = ""
        studentEmail.value = ""
        courseName.value = ""
    }

    private fun inserStudent(student: Student) = viewModelScope.launch(Dispatchers.IO) {
        val rowId = studentRepo.insert(student)
        Log.d("StudentNameValue", "$rowId")

    }
}