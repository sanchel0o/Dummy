package com.sanchelo.dummy.core.mvi

import android.util.Log

interface MviLogger {
    fun log(tag: String, message: String)
}

internal object MviLoggerDefault : MviLogger {
    override fun log(tag: String, message: String) {
        Log.d("MVI_$tag", message)
    }
}
