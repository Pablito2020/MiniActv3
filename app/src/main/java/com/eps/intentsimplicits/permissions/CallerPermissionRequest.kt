package com.eps.intentsimplicits.permissions

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

class CallerPermissionRequest(private val activity: Activity) : PermissionRequester {

    override fun requestPermission() =
        ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.CALL_PHONE), 0)

    override fun hasPermissions(): Boolean {
        return ActivityCompat.checkSelfPermission(
            activity.applicationContext,
            Manifest.permission.CALL_PHONE
        ) == PackageManager.PERMISSION_GRANTED
    }

    override fun getRequest(): String {
        return Manifest.permission.CALL_PHONE
    }

}