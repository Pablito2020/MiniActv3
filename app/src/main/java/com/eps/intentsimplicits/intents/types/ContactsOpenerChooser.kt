package com.eps.intentsimplicits.intents.types

import android.app.Activity
import android.database.Cursor
import android.net.Uri
import android.provider.ContactsContract
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.eps.intentsimplicits.R
import com.eps.intentsimplicits.intents.PermissionCommand
import com.eps.intentsimplicits.permissions.PermissionRequester


class ContactsOpenerChooser(private val activity: Activity, permission: PermissionRequester) :
    PermissionCommand(permission) {

    object Initializer {
        lateinit var launcher: ActivityResultLauncher<Void>

        fun setUp(activity: ComponentActivity, textView: TextView) {
            this.launcher =
                activity.registerForActivityResult(ActivityResultContracts.PickContact()) {
                    if (it == null)
                        showNotSelectedContact(activity)
                    else
                        printContactName(activity, it, textView)
                }
        }

        private fun showNotSelectedContact(activity: Activity) =
            Toast.makeText(activity, R.string.didnt_select_contact, Toast.LENGTH_LONG).show()

        private fun printContactName(activity: Activity, uri: Uri, textView: TextView) {
            val cursor: Cursor? = activity.contentResolver.query(uri, null, null, null, null, null)
            if (cursor?.moveToFirst()!!) {
                val nameIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
                textView.text = cursor.getString(nameIndex)
            }
            cursor.close()
        }
    }

    override fun action() {
        Initializer.launcher.launch(null)
        Toast.makeText(activity, activity.getText(R.string.opening_contacts), Toast.LENGTH_LONG)
            .show()
    }

}