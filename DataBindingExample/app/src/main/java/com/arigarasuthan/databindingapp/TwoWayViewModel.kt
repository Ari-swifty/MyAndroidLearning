package com.arigarasuthan.databindingapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TwoWayViewModel : ViewModel() {
     val userName = MutableLiveData<String>()
    val inputText = MutableLiveData<String>()
     val addData = MutableLiveData<Int>()

    init {
        userName.value = "Ari"
        addData.value = 0
    }

    fun updateData()
    {
        val input = inputText.value?.toInt()
        addData.value = (addData.value)?.plus(input ?: 0)
    }

}