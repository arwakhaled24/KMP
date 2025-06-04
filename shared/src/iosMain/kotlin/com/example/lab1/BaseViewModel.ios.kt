package com.example.lab1

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel

actual open class BaseViewModel actual constructor() {
    actual val scope: CoroutineScope=CoroutineScope(Dispatchers.Main)
    fun clean() {
        scope.cancel()
    }

}