package com.umn.n0.view.services

import android.content.ComponentName
import android.content.ServiceConnection
import android.os.IBinder

class DownloadConnection(
    private val onServiceConnected: (DownloadConnection) -> Unit = {}
) : ServiceConnection {

    lateinit var downloadService: DownloadService

    override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
        if (service is DownloadService.Binder) {
            downloadService = service.getService()
            onServiceConnected(this)
        } else {
            throw IllegalArgumentException()
        }
    }

    override fun onServiceDisconnected(name: ComponentName?) {
        println("onServiceDisconnected")
    }
}