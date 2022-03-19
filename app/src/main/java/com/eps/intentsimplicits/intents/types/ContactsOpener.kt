package com.eps.intentsimplicits.intents.types

import android.app.Activity
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.provider.ContactsContract
import com.eps.intentsimplicits.intents.PermissionCommand
import com.eps.intentsimplicits.permissions.PermissionRequester

class ContactsOpener(permission: PermissionRequester, private val activity: Activity) :
    PermissionCommand(permission) {

    override fun action() {
        val intent = Intent(ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI)
        activity.startActivity(intent)
    }

}