package com.arigarasuthan.unitconverterapp.data

import kotlinx.coroutines.flow.Flow

class ConverterRepoImpl(private val dao: ConverterDAO) : ConversionRepo {
    override suspend fun insertResult(result: ConversionResult) {
        dao.insertResult(result)
    }

    override suspend fun deleteResult(result: ConversionResult) {
        dao.deleteResult(result)
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }

    override fun getSavedResults(): Flow<List<ConversionResult>> = dao.getResults()
}