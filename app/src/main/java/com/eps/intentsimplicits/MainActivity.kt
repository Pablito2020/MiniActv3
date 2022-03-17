package com.eps.intentsimplicits

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.eps.intentsimplicits.databinding.ActivityMainBinding
import com.eps.intentsimplicits.intents.Command
import com.eps.intentsimplicits.intents.types.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun getCommandFromButton(buttonId: Int): Command = when (buttonId) {
        binding.callButton.id -> Caller(this)
        binding.contactsButton.id -> ContactsOpener(this)
        binding.coordinatesButton.id -> LocateCoordinates(this)
        binding.directionButton.id -> LocateAddress(this)
        binding.urlButton.id -> WebOpener(this)
        else -> throw IllegalArgumentException("Unsupported button")
    }

    override fun onClick(p0: View?) {
        if (p0 != null)
            getCommandFromButton(p0.id).execute()
    }

}