package com.example.my22.ui.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

abstract class BasePresenter {

    val customScope= CoroutineScope(Dispatchers.Main)

}