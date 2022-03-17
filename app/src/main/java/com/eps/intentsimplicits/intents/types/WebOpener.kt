package com.eps.intentsimplicits.intents.types

import android.app.Activity
import android.content.Intent
import android.net.Uri
import com.eps.intentsimplicits.R
import com.eps.intentsimplicits.intents.Command

class WebOpener(private val activity: Activity) : Command {

    private val url = activity.getString(R.string.url)

    override fun execute() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        activity.startActivity(intent)
    }
}