package com.eps.intentsimplicits.intents

import android.app.Activity

abstract class PermissionCommand(internal val activity: Activity) : Command {

    abstract fun hasPermissions(): Boolean

    abstract fun requestPermissions()

    abstract fun action()

    override fun execute() {
        if (!hasPermissions())
            requestPermissions()
        else
            action()
    }

}