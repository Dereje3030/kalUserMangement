package com.kal.usermangement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import static com.example.mypro.ModelClass.*;
import static com.example.mypro.ModelClass.modelInnerClass.*;
import static com.example.mypro.ModelClass.modelInnerClass.tablename;

//import static com.example.mypro.ModelClass.modelInnerClass.coulmnCount;

public class HelperClass extends SQLiteOpenHelper {

    public static final String database="user_regestery_db";
    public static final int databse_version=1;
//    public static  String CREATE_TABLE="create table "+ tablename +
//            "("+
//            + ","+ coulmnOne
//            +" TEXT,"+ coulmnTwo
//            + " TEXT,"+ coulmnThree
//            +" TEXT,"+ coulmnFour
//            + " INTEGER,"+ coulmnFive+" INTEGER,"
//            + coulmnSix+" TEXT,"
//            + coulmnSeven+" TEXT );";
    String command="create table "+ tablename+"(first_name TEXT,last_name TEXT,user_name TEXT,user_pssword INTEGER" +
        ",user_phone INTEGER,emaile TEXT,sex TEXT )";


    public HelperClass(@Nullable Context context) {
        super(context,database, null, databse_version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(command);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
     sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ tablename);
    }


    //accept value



}
