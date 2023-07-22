package com.arigarasuthan.unitconverterapp.data

import kotlinx.coroutines.flow.Flow

interface ConversionRepo {

    suspend fun insertResult(result: ConversionResult)
    suspend fun deleteResult(result: ConversionResult)
    suspend fun deleteAll()
    fun getSavedResults(): Flow<List<ConversionResult>>
}