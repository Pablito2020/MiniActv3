package com.eps.intentsimplicits.intents.types

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.eps.intentsimplicits.R
import com.eps.intentsimplicits.intents.Command


class MailSender(private val activity: Activity) : Command {

    @SuppressLint("QueryPermissionsNeeded")
    override fun execute() {
        val destination = activity.getText(R.string.destination_mail)
        val subject = activity.getText(R.string.mail_subject)
        val message = activity.getText(R.string.mail_message)
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, arrayOf(destination))
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, message)
        }
        if (intent.resolveActivity(activity.packageManager) != null) {
            activity.startActivity(intent)
            Toast.makeText(activity, activity.getText(R.string.opening_mail), Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(activity, activity.getText(R.string.error_opening_mail), Toast.LENGTH_LONG).show()
        }
    }

}