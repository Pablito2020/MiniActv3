package com.eps.intentsimplicits.intents.types

import android.app.Activity
import android.app.SearchManager
import android.content.Intent
import android.content.Intent.ACTION_WEB_SEARCH
import com.eps.intentsimplicits.R
import com.eps.intentsimplicits.intents.Command


class GoogleSearcher(private val activity: Activity): Command {

    private val textToSearch = activity.getString(R.string.text_to_search)

    override fun execute() {
        val intent = Intent(ACTION_WEB_SEARCH)
        intent.putExtra(SearchManager.QUERY, textToSearch)
        activity.startActivity(intent)
    }

}