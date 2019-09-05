package com.wzk.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.wzk.aidlservice.IService;

public class AidlService extends Service {
    IBinder iBinder = new IServiceBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }
}
