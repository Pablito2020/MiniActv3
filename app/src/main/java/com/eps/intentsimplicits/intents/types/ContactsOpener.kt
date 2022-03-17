package com.eps.intentsimplicits.intents.types

import android.Manifest.permission.READ_CONTACTS
import android.app.Activity
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.content.pm.PackageManager
import android.provider.ContactsContract
import androidx.core.app.ActivityCompat
import com.eps.intentsimplicits.intents.PermissionCommand

class ContactsOpener(activity: Activity): PermissionCommand(activity){

    override fun hasPermissions(): Boolean = ActivityCompat.checkSelfPermission(
        activity.applicationContext,
        READ_CONTACTS
    ) == PackageManager.PERMISSION_GRANTED

    override fun requestPermissions() {
        ActivityCompat.requestPermissions(activity, arrayOf(READ_CONTACTS), 0)
    }

    override fun action() {
        val intent = Intent(ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI)
        activity.startActivity(intent)
    }

}