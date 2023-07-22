package com.arigarasuthan.unitconverterapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arigarasuthan.unitconverterapp.data.Conversion
import com.arigarasuthan.unitconverterapp.data.ConversionRepo
import com.arigarasuthan.unitconverterapp.data.ConversionResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConversionViewModel(private val repo: ConversionRepo) :  ViewModel() {

    val selectedConversion: MutableState<Conversion?> = mutableStateOf(null)

    val inputString: MutableState<String> = mutableStateOf("")

    val typedValue: MutableState<String> = mutableStateOf("0.0")
    fun getConversions() = listOf(
        Conversion(1,"Pounds to Kilograms","lbs","kg",0.453952),
        Conversion(2,"Kilograms to Pounds","kg","lbs",0.20462),
        Conversion(3,"Yards to Meters","yd","m",0.9144),
        Conversion(4,"Meters to Yards","m","yd",1.09361),
        Conversion(5,"Miles to Kilometers","mi","km",1.60934),
        Conversion(6,"Kilometers to Miles","km","mi",0.621371)

    )

    val result = repo.getSavedResults()

    fun addResult(message1:String,message2:String) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.insertResult(ConversionResult(0,message1,message2))
        }
    }

    fun removerResult(item:ConversionResult) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteResult(item)
        }
    }

    fun clearAll() {
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteAll()
        }
    }
}