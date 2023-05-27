package com.arigarasuthan.flowdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myFlow = flow<Int> {
            for(i in 1..1000) {
                emit(i)
                delay(1000)
            }
        }
        var textView = findViewById<TextView>(R.id.tvResult)
        CoroutineScope(Dispatchers.Main).launch {
            myFlow.collect {
                textView.text = "Current index is $it"
            }
        }
    }
}