package com.arigarasuthan.unitconverterapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.arigarasuthan.unitconverterapp.data.ConversionRepo
import javax.inject.Inject


class ConversionViewModelFactory @Inject constructor(private val repo: ConversionRepo) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ConversionViewModel(repo) as T
    }
}