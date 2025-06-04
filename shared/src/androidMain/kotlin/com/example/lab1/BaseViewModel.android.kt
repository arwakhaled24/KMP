package com.example.lab1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

actual open class BaseViewModel actual constructor() :ViewModel(){
    actual val scope: CoroutineScope=viewModelScope
}