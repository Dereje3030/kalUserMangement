package com.kal.usermangement;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
SQLiteDatabase databse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        EditText text=findViewById(R.id.tv);
        Intent i=getIntent();
        int postion=i.getIntExtra("fn",0);
       String fname=i.getStringExtra("fn");
        String lname=i.getStringExtra("ln");
        Cursor c=readData();

        text.setText(fname);
        text.setText(lname);
        //while (c.getInt(postion))
    }
    public Cursor readData()
    {
        HelperClass openHelper = new HelperClass(this);
        databse = openHelper.getWritableDatabase();
        String query="select *from "+ModelClass.modelInnerClass.tablename;
        Cursor result=databse.rawQuery(query,null);
        return result;
    }
}
