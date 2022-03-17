package com.eps.intentsimplicits

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.requestPermissions

class Caller(activity: Activity) : IntentExecutioner(activity) {

    override fun hasPermissions(): Boolean {
        return ActivityCompat.checkSelfPermission(
            activity.applicationContext,
            Manifest.permission.CALL_PHONE
        ) == PackageManager.PERMISSION_GRANTED
    }

    override fun requestPermissions() {
        requestPermissions(activity, arrayOf(Manifest.permission.CALL_PHONE), 0)
    }

    override fun action() {
        val uri = getPhoneFromActivity()
        val intent = Intent(Intent.ACTION_CALL, uri)
        activity.startActivity(intent)
    }

    private fun getPhoneFromActivity(): Uri {
        val phone = activity.getText(R.string.telephone)
        return Uri.parse("tel: $phone")
    }

}

