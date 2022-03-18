package com.eps.intentsimplicits

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.eps.intentsimplicits.databinding.ActivityMainBinding
import com.eps.intentsimplicits.helpers.getButtons
import com.eps.intentsimplicits.intents.Command
import com.eps.intentsimplicits.intents.types.*
import com.eps.intentsimplicits.permissions.CallerPermissionRequest
import com.eps.intentsimplicits.permissions.ContactPermissionRequest
import com.eps.intentsimplicits.permissions.PermissionRequester

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var callRequester: PermissionRequester
    private lateinit var contactsRequester: PermissionRequester

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpPermissionRequesters()
        binding.getButtons().forEach { it.setOnClickListener(this) }
        checkPermissions()
    }

    private fun setUpPermissionRequesters() {
        callRequester = CallerPermissionRequest(this)
        contactsRequester = ContactPermissionRequest(this)
    }

    private fun checkPermissions() {
        requestPermissions(
            arrayOf(
                callRequester.getRequest(),
                contactsRequester.getRequest()
            ), 0
        )
    }

    private fun getCommandFromButton(buttonId: Int): Command = when (buttonId) {
        binding.callButton.id -> Caller(callRequester, this)
        binding.contactsButton.id -> ContactsOpener(contactsRequester, this)
        binding.coordinatesButton.id -> LocateCoordinates(this)
        binding.directionButton.id -> LocateAddress(this)
        binding.urlButton.id -> WebOpener(this)
        binding.googleButton.id -> GoogleSearcher(this)
        binding.dialButton.id -> DialPhone(callRequester, this)
        binding.sendSmsButton.id -> SmsSender(this)
        binding.sendEmailButton.id -> MailSender(this)
        else -> throw IllegalArgumentException("Not implemented button listener")
    }

    override fun onClick(p0: View?) {
        if (p0 != null)
            getCommandFromButton(p0.id).execute()
    }

}