package com.rohit.firstapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class StudentRegistration extends AppCompatActivity implements View.OnClickListener {
    FirebaseDatabase fd;
    StorageReference storageReference;
    EditText name,id, age, branch;
    Button selectpic, register;
    ImageView iv;
    final static int PIC_REQ=1001;
    Uri imageuri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);
        name=findViewById(R.id.sname);
        id=findViewById(R.id.sid);
        branch=findViewById(R.id.sbranch);
        age=findViewById(R.id.sage);
        register=findViewById(R.id.register);
        selectpic=findViewById(R.id.select);
        iv=findViewById(R.id.image);
        selectpic.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.register:
                registerStudent();
                break;
            case R.id.select:
                openFileChooser();
                break;
        }

    }
    private void registerStudent()
    {

    }
    public void openFileChooser()
    {
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PIC_REQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==PIC_REQ && resultCode==RESULT_OK && data!=null)
        {
            imageuri=data.getData();
            Picasso.get().load(imageuri).into(iv);
        }
    }
}
