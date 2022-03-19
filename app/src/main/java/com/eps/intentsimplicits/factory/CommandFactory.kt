package com.eps.intentsimplicits.factory

import com.eps.intentsimplicits.intents.Command
import com.eps.intentsimplicits.permissions.PermissionRequester

interface CommandFactory {
    fun getCommandFromButton(buttonId: Int): Command
    fun getPermissionRequesters(): Collection<PermissionRequester>
}