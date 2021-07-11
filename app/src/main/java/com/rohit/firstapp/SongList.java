package com.rohit.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ListView;

import com.rohit.firstapp.adapter.SongAdapter;

public class SongList extends AppCompatActivity {
    Cursor c;
    SongAdapter sa;
    ListView songslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);
        songslist=findViewById(R.id.songlist);
        c=getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                null,null,null,null);
        sa=new SongAdapter(this,c,10);
        songslist.setAdapter(sa);
    }
}
