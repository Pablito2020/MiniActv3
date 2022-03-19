package com.eps.intentsimplicits

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.eps.intentsimplicits.databinding.ActivityMainBinding
import com.eps.intentsimplicits.factory.ActivityMainCommandFactory
import com.eps.intentsimplicits.factory.CommandFactory
import com.eps.intentsimplicits.helpers.getButtons

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var factory: CommandFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        factory = ActivityMainCommandFactory(binding, this)
        binding.getButtons().forEach { it.setOnClickListener(this) }
        checkPermissions()
    }

    private fun checkPermissions() {
        val permissions =
            factory.getPermissionRequesters().map { permission -> permission.getRequest() }
                .toTypedArray()
        requestPermissions(permissions, 0)
    }

    override fun onClick(p0: View?) {
        if (p0 != null)
            factory.getCommandFromButton(p0.id).execute()
    }

}