package com.eps.intentsimplicits.permissions

interface PermissionRequester {
    fun requestPermission()
    fun hasPermissions(): Boolean
}