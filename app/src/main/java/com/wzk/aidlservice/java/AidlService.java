package com.wzk.aidlservice.java;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;


public class AidlService extends Service {
    IBinder iBinder = new IServiceBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }
}
