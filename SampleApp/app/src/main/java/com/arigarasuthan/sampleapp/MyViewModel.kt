package com.arigarasuthan.sampleapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    var stringValue = MutableLiveData<String>()

    fun getString() {
        stringValue.value = "Hello World"
    }

}