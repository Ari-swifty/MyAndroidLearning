package com.arigarasuthan.unitconverterapp.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.arigarasuthan.unitconverterapp.ConversionViewModel
import com.arigarasuthan.unitconverterapp.ConversionViewModelFactory
import com.arigarasuthan.unitconverterapp.compose.conversion.TopScreen
import com.arigarasuthan.unitconverterapp.compose.history.HistoryScreen

@Composable
fun BaseScreen(
    factory: ConversionViewModelFactory,
    modifier: Modifier = Modifier,
    conversionViewModel: ConversionViewModel = viewModel(factory = factory)
) {
    val list = conversionViewModel.getConversions()
    val historyList = conversionViewModel.result.collectAsState(initial = emptyList())

    val configuration = LocalConfiguration.current
    var isLandsScape by remember {
        mutableStateOf(false)
    }
    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            isLandsScape = true
            Row(
                modifier = modifier
                    .padding(30.dp)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                TopScreen(
                    list,
                    conversionViewModel.selectedConversion,
                    conversionViewModel.inputString,
                    conversionViewModel.typedValue,
                    isLandsScape
                ) { msg1, msg2 ->
                    conversionViewModel.addResult(message1 = msg1, message2 = msg2)
                }
                Spacer(modifier = modifier.width(10.dp))
                HistoryScreen(
                    list = historyList,
                    onCloseTask = { item->
                        conversionViewModel.removerResult(item = item)
                    },
                    onClearAllTask = {
                        conversionViewModel.clearAll()
                    }
                )
            }

        }
        else -> {
            isLandsScape = false
            Column(modifier = modifier.padding(30.dp)) {
                TopScreen(
                    list,
                    conversionViewModel.selectedConversion,
                    conversionViewModel.inputString,
                    conversionViewModel.typedValue,
                    isLandsScape
                ) { msg1, msg2 ->
                    conversionViewModel.addResult(message1 = msg1, message2 = msg2)
                }
                Spacer(modifier = modifier.height(20.dp))
                HistoryScreen(
                    list = historyList,
                    onCloseTask = { item ->
                        conversionViewModel.removerResult(item = item)
                    },
                    onClearAllTask = {
                        conversionViewModel.clearAll()
                    }
                )
            }

        }
    }
}