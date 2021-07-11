package com.rohit.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.rohit.firstapp.broadcast.MyBroadCast;

public class FirstActivity extends Activity {

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_first);
        }

    public void generateBroadCast(View view) {
        Intent intent=new Intent(FirstActivity.this, MyBroadCast.class);
        sendBroadcast(intent);
    }
}

