package com.eps.intentsimplicits.intents.types

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.Intent.ACTION_PICK
import android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.eps.intentsimplicits.intents.Command

class GalleryOpener : Command {

    object Initializer {
        private lateinit var activity: ComponentActivity
        lateinit var onResultLauncher: ActivityResultLauncher<Intent>

        fun setUp(activity: ComponentActivity) {
            this.activity = activity
            this.onResultLauncher =
                Initializer.activity.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                    if (it.resultCode == RESULT_OK) {
                        val imageUri = it.data
                    }
                }

        }

    }

    override fun execute() {
        val intent = Intent(ACTION_PICK, EXTERNAL_CONTENT_URI)
        Initializer.onResultLauncher.launch(intent)
    }

}