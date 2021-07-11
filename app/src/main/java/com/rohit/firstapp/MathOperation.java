package com.rohit.firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MathOperation extends AppCompatActivity implements View.OnClickListener {
    TextView result;
    EditText n1, n2;
    Button a,s,d,m;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_operation);
        result=findViewById(R.id.res);
        n1=findViewById(R.id.num1);
        n2=findViewById(R.id.num2);
        a=findViewById(R.id.add);
        s=findViewById(R.id.sub);
        d=findViewById(R.id.div);
        m=findViewById(R.id.mul);
        a.setOnClickListener(this);
        s.setOnClickListener(this);
        d.setOnClickListener(this);
        m.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        double num1=Double.parseDouble(n1.getText().toString());
        double num2=Double.parseDouble(n2.getText().toString());
        switch (v.getId())
        {
            case R.id.add:
                result.setText(String.valueOf(num1+num2));
                break;
            case R.id.sub:
                result.setText(String.valueOf(num1-num2));
                break;
            case R.id.mul:
                result.setText(String.valueOf(num1*num2));
                break;
            case R.id.div:
                result.setText(String.valueOf(num1/num2));
                break;
        }

    }
}
