package com.eps.intentsimplicits.intents.types

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.Intent.ACTION_PICK
import android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.eps.intentsimplicits.R
import com.eps.intentsimplicits.intents.Command

class GalleryOpenerChooser(private val activity: Activity) : Command {

    object Initializer {
        lateinit var launcher: ActivityResultLauncher<Intent>

        fun setUp(activity: ComponentActivity, imageGallery: ImageView) {
            this.launcher =
                activity.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                    if (it.resultCode == RESULT_OK) {
                        val intent: Intent? = it.data
                        val uri = intent?.data
                        imageGallery.setImageURI(uri)
                    }
                }

        }
    }

    override fun execute() {
        val intent = Intent(ACTION_PICK, EXTERNAL_CONTENT_URI)
        Initializer.launcher.launch(intent)
        Toast.makeText(activity, activity.getText(R.string.opening_gallery), Toast.LENGTH_LONG).show()
    }

}