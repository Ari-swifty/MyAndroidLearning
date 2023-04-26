package com.arigarasuthan.viewmodelscopedemoapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class MainActivityViewModel : ViewModel() {
    private var userRepo = UserRepo()
    var usersData : MutableLiveData<List<User>> = MutableLiveData()
    fun getUserData() {
        viewModelScope.launch {
            var results : List<User>? = null
            withContext(Dispatchers.IO) {
                results = userRepo.getUsers()
            }
            usersData.value = results
        }
    }


}