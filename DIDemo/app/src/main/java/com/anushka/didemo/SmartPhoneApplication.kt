package com.anushka.didemo

import android.app.Application

class SmartPhoneApplication : Application() {
    lateinit var smartphoneComponent: SmartphoneComponent
    override fun onCreate() {
        smartphoneComponent = initDagger()
        super.onCreate()
    }

    private fun initDagger() : SmartphoneComponent  = DaggerSmartphoneComponent.create()
}