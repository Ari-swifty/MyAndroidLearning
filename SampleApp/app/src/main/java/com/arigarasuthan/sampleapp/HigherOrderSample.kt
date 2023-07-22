package com.arigarasuthan.sampleapp

class HigherOrderSample {

    init {
        var lambda = {a:Int,b:Int -> a+b}
        higherOrder(lambda)
    }


    fun higherOrder(lmbd:(Int,Int)->Int) {
        val result = lmbd(10,10)
        print("Result Is $result")
    }
}