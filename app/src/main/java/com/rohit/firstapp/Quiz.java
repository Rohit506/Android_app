package com.rohit.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity implements View.OnClickListener {
    String que[]={"Identify the device through which data and instructions are entered into a computer",
            "Computer Moniter is also known as _______",
            "The World Largest desert is ?",
            "Mount Everest is located in ?",
            "Which soil is suitable for agriculture ?"};

    String op1[]={"Software","DVU","Thar","India","Red soil"};
    String op2[]={"Output device","UVD","Kalahari","Nepal","Sand"};
    String op3[]={"Input device","VDU","Sahara","Tibet","Black soil"};
    String op4[]={"Memory","CCTV","Sonoran","China","Peaty soil"};

    String answer[]={"Input device","VDU","Sahara","Nepal","Peaty soil"};

    RadioButton r1,r2,r3,r4;
    RadioGroup rg;
    Button next;
    TextView ques;
    int i=0;
    int result=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        r1=findViewById(R.id.r1);
        r2=findViewById(R.id.r2);
        r3=findViewById(R.id.r3);
        r4=findViewById(R.id.r4);
        rg=findViewById(R.id.rg);
        next=findViewById(R.id.button);
        ques=findViewById(R.id.ques);
        setQuestion();
        next.setOnClickListener(this);
    }
    public void setQuestion()
    {
        ques.setText(que[i]);
        r1.setText(op1[i]);
        r2.setText(op2[i]);
        r3.setText(op3[i]);
        r4.setText(op4[i]);

    }

    @Override
    public void onClick(View v) {
        if(i<=4)
        {
            RadioButton r=findViewById(rg.getCheckedRadioButtonId());
            if(r!=null)
            {
                if(r.getText().toString().equals(answer[i]))
                {
                    result+=10;
                    rg.clearCheck();
                }
            }
            if(i==4)
            {
                hideView();
                Intent intent=new Intent(Quiz.this,QuizResult.class);
                intent.putExtra("Result",String.valueOf(result));
                startActivity(intent);
                Toast.makeText(this,""+String.valueOf(result),Toast.LENGTH_SHORT).show();
            }
        }
        if(i<4)
        {
            i++;
            setQuestion();
        }

    }
    public void hideView()
    {
        ques.setVisibility(View.GONE);
        r1.setVisibility(View.GONE);
        r2.setVisibility(View.GONE);
        r3.setVisibility(View.GONE);
        r4.setVisibility(View.GONE);
        next.setVisibility(View.GONE);
    }
}
