package com.eps.intentsimplicits.intents.types

import android.app.Activity
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import com.eps.intentsimplicits.intents.Command

class GalleryOpener(private val activity: Activity): Command {

    override fun execute() {
        val intent = Intent(ACTION_VIEW)
        intent.type = "image/*";
        // If we want to open it on another "tab"
        //images.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent)
    }

}