package com.arigarasuthan.unitconverterapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.arigarasuthan.unitconverterapp.data.Conversion

@Composable
fun ConversionMenu(
    isLandScape: Boolean,
    list: List<Conversion>,
    modifier: Modifier = Modifier, convert: (Conversion) -> Unit
) {
    var displayingText by remember { mutableStateOf("Select the conversion type") }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    var expanded by remember {
        mutableStateOf(false)
    }

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown
    Column {
        if(isLandScape) {
            OutlinedTextField(
                value = displayingText,
                onValueChange = { displayingText = it },
                textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                modifier = modifier
                    .onGloballyPositioned { coordinates ->
                        textFieldSize = coordinates.size.toSize()
                    },
                label = { Text(text = "Conversion Type") },
                trailingIcon = {
                    Icon(icon, contentDescription = "icon",
                        modifier.clickable {
                            expanded = !expanded
                        })
                },
                readOnly = true
            )

        } else {
            OutlinedTextField(
                value = displayingText,
                onValueChange = { displayingText = it },
                textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                modifier = modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        textFieldSize = coordinates.size.toSize()
                    },
                label = { Text(text = "Conversion Type") },
                trailingIcon = {
                    Icon(icon, contentDescription = "icon",
                        modifier.clickable {
                            expanded = !expanded
                        })
                },
                readOnly = true
            )
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            list.forEach { conversion ->
                DropdownMenuItem(onClick = {
                    displayingText = conversion.description
                    expanded = false
                    convert(conversion)
                }) {
                    Text(
                        text = conversion.description,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }


    }

}