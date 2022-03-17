package com.eps.intentsimplicits.intents

import android.app.Activity
import com.eps.intentsimplicits.permissions.PermissionRequester

abstract class PermissionCommand(requester: PermissionRequester, internal val activity: Activity) :
    Command {

    protected val permissionRequester = requester

    abstract fun action()

    override fun execute() {
        if (!permissionRequester.hasPermissions())
            permissionRequester.requestPermission()
        else
            action()
    }

}