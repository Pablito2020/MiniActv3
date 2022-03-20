package com.eps.intentsimplicits.intents.types

import android.app.Activity
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.widget.Toast
import com.eps.intentsimplicits.R
import com.eps.intentsimplicits.intents.Command

class LocateCoordinates(private val activity: Activity) : Command {

    private val lat = activity.getText(R.string.lat)
    private val lon = activity.getText(R.string.lon)

    override fun execute() {
        val uri = getUri()
        val intent = Intent(ACTION_VIEW, uri)
        activity.startActivity(intent)
        Toast.makeText(activity, activity.getText(R.string.opening_maps_coordinates), Toast.LENGTH_LONG).show()
    }

    private fun getUri() = Uri.parse("geo: ${lat},${lon}?q=${lat},${lon}")

}