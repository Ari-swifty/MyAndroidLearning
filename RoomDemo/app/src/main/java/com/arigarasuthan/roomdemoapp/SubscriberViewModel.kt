package com.arigarasuthan.roomdemoapp

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arigarasuthan.roomdemoapp.db.Subscriber
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.regex.Pattern

class SubscriberViewModel(private val subscriberRepository: SubscriberRepository) : ViewModel() {

    val subscribers = subscriberRepository.subscribers
    private var isUpdateOrDelete = false
    private lateinit var subscriberToUpdateOrDelete: Subscriber
    val inputName = MutableLiveData<String>()
    val inputEmail = MutableLiveData<String>()

    val saveorUpdateButtonText = MutableLiveData<String>()
    val clearAllorDeleteButtonText = MutableLiveData<String>()

    private val statusMessage = MutableLiveData<Event<String>>()

    val message: LiveData<Event<String>>
        get() = statusMessage

    init {
        saveorUpdateButtonText.value = "Save"
        clearAllorDeleteButtonText.value = "Clear All"
    }

    fun saveOrUpdate() {
        if (inputName.value == null) {
            statusMessage.value = Event("Please enter subscriber's name")
        } else if (inputEmail.value == null) {
            statusMessage.value = Event("Please enter subscriber's email")
        } else if (!Patterns.EMAIL_ADDRESS.matcher(inputEmail.value!!).matches()) {
            statusMessage.value = Event("Please enter correct email address")
        } else {
            if (isUpdateOrDelete) {
                subscriberToUpdateOrDelete.name = inputName.value!!
                subscriberToUpdateOrDelete.email = inputEmail.value!!
                update(subscriberToUpdateOrDelete)
            } else {
                val name = inputName.value!!
                val email = inputEmail.value!!
                insert(Subscriber(0, name, email))
                inputName.value = ""
                inputEmail.value = ""
            }

        }
    }

    fun clearAllOrDelete() {
        if (isUpdateOrDelete) {
            delete(subscriberToUpdateOrDelete)
        } else {
            clearAll()
        }
    }

    fun insert(subscriber: Subscriber) = viewModelScope.launch(Dispatchers.IO) {
        val rowId = subscriberRepository.insert(subscriber)
        withContext(Dispatchers.Main) {
            if (rowId > -1) {
                statusMessage.value = Event("Subscriber Inserted Successfully $rowId")
            } else {
                statusMessage.value = Event("Error Occurred")
            }
        }
    }

    fun update(subscriber: Subscriber) = viewModelScope.launch(Dispatchers.IO) {
        val noOfRows = subscriberRepository.update(subscriber)
        withContext(Dispatchers.Main) {
            if (noOfRows > 0) {
                inputName.value = ""
                inputEmail.value = ""
                isUpdateOrDelete = false
                saveorUpdateButtonText.value = "Save"
                clearAllorDeleteButtonText.value = "Clear All"
                statusMessage.value = Event("$noOfRows Subscriber Updated Successfully")
            } else {
                statusMessage.value = Event("Error Occurred")
            }
        }
    }

    fun delete(subscriber: Subscriber) = viewModelScope.launch(Dispatchers.IO) {
        val noOfRows = subscriberRepository.delete(subscriber)
        withContext(Dispatchers.Main) {
            if (noOfRows > 0) {
                inputName.value = ""
                inputEmail.value = ""
                isUpdateOrDelete = false
                saveorUpdateButtonText.value = "Save"
                clearAllorDeleteButtonText.value = "Clear All"
                statusMessage.value = Event("$noOfRows Subscriber Deleted Successfully")
            } else {
                statusMessage.value = Event("Error Occurred")
            }
        }
    }

    fun clearAll() = viewModelScope.launch(Dispatchers.IO) {
        val noOfRows = subscriberRepository.deleteAll()
        withContext(Dispatchers.Main) {
            if (noOfRows > 0) {
                statusMessage.value = Event("$noOfRows All Subscribers Deleted Successfully")
            } else {
                statusMessage.value = Event("Error Occurred")
            }
        }
    }

    fun initUpdateAndDelete(subscriber: Subscriber) {
        inputName.value = subscriber.name
        inputEmail.value = subscriber.email
        isUpdateOrDelete = true
        subscriberToUpdateOrDelete = subscriber
        saveorUpdateButtonText.value = "Update"
        clearAllorDeleteButtonText.value = "Delete"
    }

}