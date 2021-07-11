package com.rohit.firstapp.broadcast;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.util.Random;

public class MyBoundedService extends Service {
    private final IBinder binder=new MyBinder();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
    public class MyBinder extends Binder
    {
        public MyBoundedService getService()
        {
            return MyBoundedService.this;
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }
    public int generateNumber()
    {
        Random random=new Random();
        int num=random.nextInt();
        return num;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
