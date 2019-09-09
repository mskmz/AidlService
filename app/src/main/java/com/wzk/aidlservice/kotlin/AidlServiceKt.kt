package com.wzk.aidlservice.kotlin

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.wzk.aidlservice.java.IServiceBinder

class AidlService : Service() {
    private var iBinder: IBinder = IServiceBinder()

    override fun onBind(intent: Intent): IBinder? {
        return iBinder
    }
}