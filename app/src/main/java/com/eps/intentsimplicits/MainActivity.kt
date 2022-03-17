package com.eps.intentsimplicits

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.eps.intentsimplicits.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpButtonComponents()
    }

    fun setUpButtonComponents() {
        binding.callButton.setOnClickListener {
            val caller = Caller(this)
            caller.execute()
        }
        binding.contactsButton.setOnClickListener {
            val contacts = ContactsOpener(this)
            contacts.execute()
        }
    }

}