package com.arigarasuthan.unitconverterapp

import android.icu.text.DecimalFormat
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import java.math.RoundingMode

@Composable
fun TopScreen(list: List<Conversion>) {
    val selectedConversion: MutableState<Conversion?> = remember {
        mutableStateOf(null)
    }
    val inputString:MutableState<String> = remember {
        mutableStateOf("")
    }
    val typedValue:MutableState<String> = remember {
        mutableStateOf("0.0")
    }
    ConversionMenu(list = list) {
        selectedConversion.value = it
    }

    selectedConversion.value?.let {
        InputBlock(conversion = it, inputText =inputString) { input->
            Log.d("MYTAG","Typed Text $input")
            typedValue.value = input
        }
    }

    if(typedValue.value != "0.0") {
        val input = typedValue.value.toDouble()
        val multiply = selectedConversion.value!!.multiplyBy
        val result = input*multiply

        val df = java.text.DecimalFormat("#.####")
        df.roundingMode = RoundingMode.DOWN
        val roundingResult = df.format(result)

        val message1 = "${typedValue.value} ${selectedConversion.value!!.convertFrom} is equal to"
        val message2 = "$roundingResult ${selectedConversion.value!!.convertTo}"

        ResultBlock(message1 = message1, message2 = message2)

    }
}