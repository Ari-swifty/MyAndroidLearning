package com.arigarasuthan.roomdemoapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arigarasuthan.roomdemoapp.db.Subscriber
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SubscriberViewModel(private val subscriberRepository: SubscriberRepository) : ViewModel() {

    val subscribers = subscriberRepository.subscribers
    val inputName = MutableLiveData<String>()
    val inputEmail = MutableLiveData<String>()

    val saveorUpdateButtonText = MutableLiveData<String>()
    val clearAllorDeleteButtonText = MutableLiveData<String>()

    init {
        saveorUpdateButtonText.value = "Save"
        clearAllorDeleteButtonText.value = "Clear All"
    }

    fun saveOrUpdate() {
        val name = inputName.value ?: ""
        val email = inputEmail.value ?: ""
        insert(Subscriber(0,name,email))
        inputName.value = ""
        inputEmail.value = ""

    }

    fun clearAllOrDelete() {
        clearAll()
    }

    fun insert(subscriber: Subscriber) = viewModelScope.launch(Dispatchers.IO) {
        subscriberRepository.insert(subscriber)
    }

    fun update(subscriber: Subscriber) = viewModelScope.launch(Dispatchers.IO) {
        subscriberRepository.update(subscriber)
    }

    fun delete(subscriber: Subscriber) = viewModelScope.launch(Dispatchers.IO) {
        subscriberRepository.delete(subscriber)
    }

    fun clearAll()  = viewModelScope.launch(Dispatchers.IO) {
        subscriberRepository.deleteAll()
    }

}