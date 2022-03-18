package com.eps.intentsimplicits.intents.types

import android.app.Activity
import android.content.Intent
import android.net.Uri
import com.eps.intentsimplicits.R
import com.eps.intentsimplicits.intents.Command

class SmsSender(private val activity: Activity): Command {

    override fun execute() {
        val number = activity.getText(R.string.sms_number)
        val uri = Uri.parse("smsto:$number");
        val it = Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", activity.getText(R.string.sms_body));
        activity.startActivity(it);
    }

}