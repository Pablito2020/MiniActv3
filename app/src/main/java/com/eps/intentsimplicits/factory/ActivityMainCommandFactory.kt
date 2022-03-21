package com.eps.intentsimplicits.factory

import androidx.activity.ComponentActivity
import com.eps.intentsimplicits.databinding.ActivityMainBinding
import com.eps.intentsimplicits.intents.Command
import com.eps.intentsimplicits.intents.types.*
import com.eps.intentsimplicits.permissions.CallerPermissionRequest
import com.eps.intentsimplicits.permissions.ContactPermissionRequest
import com.eps.intentsimplicits.permissions.PermissionRequester

class ActivityMainCommandFactory(
    private val binding: ActivityMainBinding,
    private val activity: ComponentActivity
) : CommandFactory {

    private val callRequester = CallerPermissionRequest(activity)
    private val contactsRequester = ContactPermissionRequest(activity)

    init {
        GalleryOpenerChooser.Initializer.setUp(activity, binding.imageGallery)
        ContactsOpenerChooser.Initializer.setUp(activity, binding.contactNameTextview)
        ExtraActivityPickOpener.Initializer.setUp(activity, binding.resultExtraActivity)
    }

    override fun getCommandFromButton(buttonId: Int): Command = when (buttonId) {
        binding.callButton.id -> Caller(callRequester, activity)
        binding.contactsButton.id -> ContactsOpenerChooser(activity, contactsRequester)
        binding.coordinatesButton.id -> LocateCoordinates(activity)
        binding.directionButton.id -> LocateAddress(activity)
        binding.urlButton.id -> WebOpener(activity)
        binding.googleButton.id -> GoogleSearcher(activity)
        binding.dialButton.id -> DialPhone(callRequester, activity)
        binding.sendSmsButton.id -> SmsSender(activity)
        binding.sendEmailButton.id -> MailSender(activity)
        binding.openGalleryButton.id -> GalleryOpenerChooser(activity)
        binding.extraActivityButton.id -> ExtraActivityPickOpener()
        else -> throw IllegalArgumentException("Not implemented button listener")
    }

    override fun getPermissionRequesters(): Collection<PermissionRequester> {
        return listOf(callRequester, contactsRequester)
    }
}