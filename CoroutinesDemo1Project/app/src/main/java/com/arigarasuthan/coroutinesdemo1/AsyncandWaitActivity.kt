package com.arigarasuthan.coroutinesdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.*

class AsyncandWaitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asyncand_wait)
        CoroutineScope(Dispatchers.Main).launch {
            Log.d("MyTag", "Calculation started")
            val stock1 = async(Dispatchers.IO) {
                getStock()
            }
            val stock2 = async(Dispatchers.IO) {
                getStock2()
            }
            val total = stock1.await() + stock2.await()
            Toast.makeText(this@AsyncandWaitActivity,"Total is $total",Toast.LENGTH_LONG).show()
        }
    }

    private suspend fun getStock(): Int {
        delay(10000)
        Log.d("MyTag", "Stock 1 retured")
        return 55000
    }

    private suspend fun getStock2(): Int {
        delay(8000)
        Log.d("MyTag", "Stock 2 retured")
        return 35000
    }

}