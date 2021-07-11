package com.rohit.firstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Permissions;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileTest extends AppCompatActivity implements View.OnClickListener {
    Button add, search;
    EditText fname, fdata;
    File f,f1;
    FileInputStream fis;
    FileOutputStream fos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_test);
        search=findViewById(R.id.search);
        add=findViewById(R.id.add);
        fname=findViewById(R.id.fname);
        fdata=findViewById(R.id.fdata);
        f1= Environment.getExternalStorageDirectory();
        add.setOnClickListener(this);
        search.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkAndRequestPermission();
    }

    @Override
    protected void onStart() {
        super.onStart();
        f=new File(f1,"MyFirstApp");
        if (!f.exists())
        {
            f.mkdir();
            Toast.makeText(this, "Folder Created...", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Folder Exists Already", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean checkAndRequestPermission()
    {
        int read= ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int write= ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        List<String> l=new ArrayList();
        if (read!= PackageManager.PERMISSION_GRANTED)
        {
            l.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        if (write!=PackageManager.PERMISSION_GRANTED)
        {
            l.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (l.size()>0)
        {
            ActivityCompat.requestPermissions(this,l.toArray(new String[l.size()]),2000);
            return false;
        }
        return true;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.add:
                addFileData();
                break;
            case R.id.search:
                searchFileData();
                break;
        }

    }
    public void addFileData()
    {
        try
        {
            String name=fname.getText().toString();
            String data=fdata.getText().toString();
            fos=new FileOutputStream(f.getAbsolutePath()+File.separator+name,true);
            fos.write(data.getBytes());
            Toast.makeText(this, "Data Stored...!", Toast.LENGTH_SHORT).show();
            fname.setText("");
            fdata.setText("");
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Error : "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void searchFileData()
    {
        try
        {
            String name=fname.getText().toString();
            File f2=new File(f,name);
            if (f2.exists())
            {
                fis=new FileInputStream(f2.getAbsolutePath());
                Scanner sc= new Scanner(fis);
                while (sc.hasNext())
                {
                    fdata.append(sc.nextLine());
                }
            }
            else
            {
                fdata.setText("");
                Toast.makeText(this, "File Not Exists...!!", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Error : "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
