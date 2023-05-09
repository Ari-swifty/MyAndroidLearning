package com.anushka.didemo

import dagger.Module
import dagger.Provides

@Module
class NCBatteryModule {

    @Provides
    fun providesNCBattery(nickelCadmiumBattery: NickelCadmiumBattery): Battery =
        nickelCadmiumBattery
}