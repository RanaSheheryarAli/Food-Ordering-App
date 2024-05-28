package com.example.foodorderingapp.MVVMODEL.Viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class subscribeViewmodel: AndroidViewModel(Application()) {
    var txt=MutableLiveData<String>()
    var btntxt=MutableLiveData<String>()
    init {
        txt.value="Hello Subscrib to Sherry Channel"
        btntxt.value="Subscribe"
    }
    fun update(){

        txt.value="Thanks for Subscribe our Channel"
        btntxt.value="Subscribed"
    }

}