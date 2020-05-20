package com.example.mvvmtemplate.ui.third

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalcModel : ViewModel() {
    var augened = MutableLiveData<String>()
    var addend = MutableLiveData<String>()

    init {
        augened.value = "0"
        addend.value = "0"
    }
}
