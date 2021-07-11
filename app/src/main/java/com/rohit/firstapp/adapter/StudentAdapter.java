package com.rohit.firstapp.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.rohit.firstapp.R;
import com.rohit.firstapp.model.StudentContact;

public class StudentAdapter extends CursorAdapter {
    public StudentAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.custom_student_record_layout,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView id,name,add,age,branch;
        id=view.findViewById(R.id.id);
        name=view.findViewById(R.id.name);
        add=view.findViewById(R.id.address);
        age=view.findViewById(R.id.age);
        branch=view.findViewById(R.id.branch);


        id.setText(String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(StudentContact.ID))));
        age.setText(String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(StudentContact.AGE))));
        name.setText(cursor.getString(cursor.getColumnIndexOrThrow(StudentContact.NAME)));
        branch.setText(cursor.getString(cursor.getColumnIndexOrThrow(StudentContact.BRANCH)));
        add.setText(cursor.getString(cursor.getColumnIndexOrThrow(StudentContact.ADDRESS)));

    }
}
