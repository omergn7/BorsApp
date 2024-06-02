package com.example.borsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.borsapp.model.Hisse

class MainViewModel : ViewModel() {

    val hisseData : MutableLiveData<Hisse> = MutableLiveData()
    val hisseLoad : MutableLiveData<Boolean> = MutableLiveData()
    val hisseError : MutableLiveData<Boolean> = MutableLiveData()

}