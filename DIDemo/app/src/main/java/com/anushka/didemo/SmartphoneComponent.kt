package com.anushka.didemo

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MemoryCardModule::class,NCBatteryModule::class])
interface SmartphoneComponent {
    fun inject(mainActivity: MainActivity)
}