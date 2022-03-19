package com.eps.intentsimplicits.intents.types

import android.app.Activity
import android.content.Intent
import android.net.Uri
import com.eps.intentsimplicits.R
import com.eps.intentsimplicits.intents.PermissionCommand
import com.eps.intentsimplicits.permissions.PermissionRequester

class DialPhone(permission: PermissionRequester, private val activity: Activity): PermissionCommand(permission) {

        override fun action() {
            val uri = getPhoneFromActivity()
            val intent = Intent(Intent.ACTION_DIAL, uri)
            activity.startActivity(intent)
        }

        private fun getPhoneFromActivity(): Uri {
            val phone = activity.getText(R.string.telephone)
            return Uri.parse("tel: $phone")
        }

    }