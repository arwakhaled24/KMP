package com.example.lab1

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel (){
    val scope: CoroutineScope
}