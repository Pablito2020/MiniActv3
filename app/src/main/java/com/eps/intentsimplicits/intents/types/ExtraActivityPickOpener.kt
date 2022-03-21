package com.eps.intentsimplicits.intents.types

import android.app.Activity
import android.content.Intent
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.eps.intentsimplicits.intents.Command

class ExtraActivityPickOpener : Command {

    object Initializer {
        private val KEY_RESULT = "RESULT"
        lateinit var launcher: ActivityResultLauncher<Intent>

        fun setUp(activity: ComponentActivity, textView: TextView) {
            this.launcher =
                activity.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                    if (it.resultCode == Activity.RESULT_OK) {
                        val intent: Intent? = it.data
                        val text = intent?.getStringExtra(KEY_RESULT)
                        textView.text = text.toString()
                    }
                }

        }
    }

    override fun execute() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "text/plain"
        Initializer.launcher.launch(intent)
    }
}