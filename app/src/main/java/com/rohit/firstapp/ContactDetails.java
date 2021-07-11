package com.rohit.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ContactDetails extends AppCompatActivity {
    Cursor c;
    ListView songslist;
    ArrayList<String> ar=new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);
        songslist=findViewById(R.id.songlist);
        c=getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,
                null,null,null,null);
        while (c.moveToNext())
        {
            ar.add(c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
        }
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,ar);
        songslist.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkAndRequestPermission();
    }

    public boolean checkAndRequestPermission() {
        int read = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
        List<String> l = new ArrayList();
        if (read != PackageManager.PERMISSION_GRANTED) {
            l.add(Manifest.permission.READ_CONTACTS);
        }
        if (l.size() > 0) {
            ActivityCompat.requestPermissions(this, l.toArray(new String[l.size()]), 2000);
            return false;
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
