package com.eps.intentsimplicits.intents.types

import android.app.Activity
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.widget.Toast
import com.eps.intentsimplicits.R
import com.eps.intentsimplicits.intents.Command

class LocateAddress(private val activity: Activity) : Command {

    private val address = activity.getText(R.string.address)

    override fun execute() {
        val uri = Uri.parse("geo:0,0?q=$address")
        val intent = Intent(ACTION_VIEW, uri)
        activity.startActivity(intent)
        Toast.makeText(activity, activity.getText(R.string.opening_maps_address), Toast.LENGTH_LONG).show()
    }


}