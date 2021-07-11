package com.rohit.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String activity[]={"StudentRegistration","MapsActivity","BoundedServiceDemo","BlueToothDemo","WifiDemo","SliderImage","WebViewDemo",
                            "LightSensor","ProxySensor","AccSensorDemo","SensorList","ContactDetails",
                            "SongList", "NotificationDemo","FileTest","ShowRecord","Registration",
                            "Previous","ContextDemo", "OptionDemo","Quiz","SpinnerDemo","AutoComplete",
                            "ColorPicker","CounterActivity", "MathOperation", "FirstActivity"};
    ListView lv;
    ArrayAdapter<String> adapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        lv = findViewById(R.id.menu);
        adapter = new ArrayAdapter<String>(this,
                R.layout.custom_list_view_layout, R.id.text,activity);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        try {
            String s= "com.rohit.firstapp."+activity[position];
            Class c = Class.forName(s);
                Intent intent = new Intent(MenuActivity.this,c);
                startActivity(intent);

        }catch (Exception e)
        {

        }

    }
}
