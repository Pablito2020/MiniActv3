package com.eps.intentsimplicits.intents.types

import android.app.Activity
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import com.eps.intentsimplicits.R
import com.eps.intentsimplicits.intents.Command

class LocateCoordinates(private val activity: Activity) : Command {

    private val lat = activity.getText(R.string.lat)
    private val lon = activity.getText(R.string.lon)

    override fun execute() {
        val uri = getUri()
        val intent = Intent(ACTION_VIEW, uri)
        activity.startActivity(intent)
    }

    private fun getUri() = Uri.parse("geo: ${lat},${lon}?q=${lat},${lon}")

}