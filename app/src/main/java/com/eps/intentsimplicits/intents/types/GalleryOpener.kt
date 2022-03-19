package com.eps.intentsimplicits.intents.types

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.Intent.ACTION_PICK
import android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.eps.intentsimplicits.intents.Command

class GalleryOpener() : Command {

    object Initializer {
        lateinit var launcher: ActivityResultLauncher<Intent>

        fun setUp(launcher: ActivityResultLauncher<Intent>) {
            this.launcher = launcher
        }
    }

    override fun execute() {
        val intent = Intent(ACTION_PICK, EXTERNAL_CONTENT_URI)
        Initializer.launcher.launch(intent)
    }

}