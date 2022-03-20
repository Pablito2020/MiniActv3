package com.eps.intentsimplicits.intents.types

import android.app.Activity
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.provider.ContactsContract
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.eps.intentsimplicits.R
import com.eps.intentsimplicits.intents.PermissionCommand
import com.eps.intentsimplicits.permissions.PermissionRequester


class ContactsOpenerChooser(private val activity: Activity, permission: PermissionRequester) : PermissionCommand(permission) {

    object Initializer {
        lateinit var launcher: ActivityResultLauncher<Intent>

        fun setUp(activity: ComponentActivity, textView: TextView) {
            this.launcher =
                activity.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                    if (it.resultCode == Activity.RESULT_OK && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        val intent: Intent? = it.data
                        val uri: Uri = intent?.data!!
                        val cursor: Cursor? = activity.contentResolver.query(uri, null, null, null)
                        if (cursor!!.moveToFirst()) {
                            val nameIndex: Int =
                                cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)
                            val name = cursor.getString(nameIndex)
                            textView.text = name
                        }
                        cursor.close()
                    } else {
                        Toast.makeText(activity, activity.getText(R.string.low_api_message_contacts), Toast.LENGTH_LONG).show()
                    }
                }
        }

    }

    override fun action() {
        val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
        intent.type = ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE
        Initializer.launcher.launch(intent)
        Toast.makeText(activity, activity.getText(R.string.opening_contacts), Toast.LENGTH_LONG).show()
    }

}