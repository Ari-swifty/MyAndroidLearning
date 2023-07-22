package com.arigarasuthan.unitconverterapp.compose.conversion

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import com.arigarasuthan.unitconverterapp.ConversionMenu
import com.arigarasuthan.unitconverterapp.data.Conversion
import java.lang.reflect.Modifier
import java.math.RoundingMode

@Composable
fun TopScreen(
    list: List<Conversion>,
    selectedConversion: MutableState<Conversion?>,
    inputString: MutableState<String>,
    typedValue: MutableState<String>,
    isLandScape: Boolean,
    save: (String, String) -> Unit
) {
//    val selectedConversion: MutableState<Conversion?> = remember {
//        mutableStateOf(null)
//    }
//    val inputString:MutableState<String> = remember {
//        mutableStateOf("")
//    }
//    val typedValue:MutableState<String> = remember {
//        mutableStateOf("0.0")
//    }

    var toSave by remember {
        mutableStateOf(false)
    }
    Column(modifier = androidx.compose.ui.Modifier.verticalScroll(rememberScrollState())) {
        ConversionMenu(list = list, isLandScape = isLandScape) {
            selectedConversion.value = it
            typedValue.value = "0.0"
        }

        selectedConversion.value?.let {
            InputBlock(
                conversion = it,
                inputText = inputString,
                isLandScape = isLandScape
            ) { input ->
                Log.d("MYTAG", "Typed Text $input")
                typedValue.value = input
                toSave = true
            }
        }

        if (typedValue.value != "0.0") {
            val input = typedValue.value.toDouble()
            val multiply = selectedConversion.value!!.multiplyBy
            val result = input * multiply

            val df = java.text.DecimalFormat("#.####")
            df.roundingMode = RoundingMode.DOWN
            val roundingResult = df.format(result)

            val message1 =
                "${typedValue.value} ${selectedConversion.value!!.convertFrom} is equal to"
            val message2 = "$roundingResult ${selectedConversion.value!!.convertTo}"
            if (toSave) {
                save(message1, message2)
                toSave = false
            }

            ResultBlock(message1 = message1, message2 = message2)

        }
    }
}