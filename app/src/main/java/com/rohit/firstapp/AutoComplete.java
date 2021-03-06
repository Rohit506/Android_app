package com.rohit.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class AutoComplete extends AppCompatActivity {
    AutoCompleteTextView actv;
    MultiAutoCompleteTextView mactv;
    String name[]={"Anish","Shivam","Rohit","Stuti","Shilpi","Uttam","Lalit","Abhishekh","Sonu",
                        "Vishal","Manish","Aryan","Shreya","Raghav","Pinki"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);
        actv=findViewById(R.id.actv);
        mactv=findViewById(R.id.mactv);
        adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name);
        actv.setAdapter(adapter);
        mactv.setAdapter(adapter);
        actv.setThreshold(1); //It shows the suggestion after one world
        mactv.setThreshold(1);
        mactv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
