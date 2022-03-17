package com.eps.intentsimplicits

import android.app.Activity

abstract class IntentExecutioner(internal val activity: Activity){

    abstract fun hasPermissions(): Boolean

    abstract fun requestPermissions()

    abstract fun action()

    fun execute() {
        if (!hasPermissions())
            requestPermissions()
        else
            action()
    }

}