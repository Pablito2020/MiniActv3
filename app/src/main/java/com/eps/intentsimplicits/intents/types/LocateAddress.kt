package com.eps.intentsimplicits.intents.types

import android.app.Activity
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import com.eps.intentsimplicits.R
import com.eps.intentsimplicits.intents.Command

class LocateAddress(private val activity: Activity) : Command {

    val address = activity.getText(R.string.address)

    override fun execute() {
        val uri = Uri.parse("geo:0,0?q=$address")
        val intent = Intent(ACTION_VIEW, uri)
        activity.startActivity(intent)
    }


}