package com.rohit.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.rohit.firstapp.adapter.StudentAdapter;
import com.rohit.firstapp.model.StudentContact;
import com.rohit.firstapp.model.StudentHelper;

public class ShowRecord extends AppCompatActivity {
    ListView lv;
    SQLiteDatabase sd;
    StudentHelper sh;
    StudentAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_record);
        lv=findViewById(R.id.records);
        sh=new StudentHelper(this);
        sd=sh.getReadableDatabase();
        sa=new StudentAdapter(this,sh.getRecord(sd),0);
        lv.setAdapter(sa);
    }
}
