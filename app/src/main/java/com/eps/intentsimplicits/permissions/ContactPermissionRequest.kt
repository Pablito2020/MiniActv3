package com.eps.intentsimplicits.permissions

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

class ContactPermissionRequest(private val activity: Activity) : PermissionRequester {

    override fun requestPermission() =
        ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.READ_CONTACTS), 0)

    override fun hasPermissions(): Boolean = ActivityCompat.checkSelfPermission(
        activity.applicationContext,
        Manifest.permission.READ_CONTACTS
    ) == PackageManager.PERMISSION_GRANTED

}