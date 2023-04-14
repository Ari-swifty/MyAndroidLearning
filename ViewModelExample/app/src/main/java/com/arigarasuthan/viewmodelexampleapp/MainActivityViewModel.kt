package com.arigarasuthan.viewmodelexampleapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal:Int) : ViewModel() {
    private var count = MutableLiveData<Int>()
    val countTotalData:LiveData<Int>
    get() = count
    private var inputValue = MutableLiveData<Int>()
    val totalData:LiveData<Int>
    get() = inputValue

    init {
        count.value = startingTotal
        inputValue.value = startingTotal
    }

    fun updateInutValue(input:Int){
        inputValue.value = (inputValue.value)?.plus(input)
    }

    fun getUpdatedCount() {
        count.value = (count.value)?.plus(1)
        Log.d("Count",""+count.value)
    }
}