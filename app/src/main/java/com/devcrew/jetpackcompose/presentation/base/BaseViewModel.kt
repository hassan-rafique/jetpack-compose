package com.devcrew.jetpackcompose.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devcrew.jetpackcompose.presentation.utils.RequestState

open class BaseViewModel : ViewModel() {

    protected val _state = MutableLiveData<RequestState>()
    val state: LiveData<RequestState>

    init {
        state = _state
    }
}