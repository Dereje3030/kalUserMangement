package com.kal.usermangement;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText userFirstName, userLastName, Una, userEmail, userPassword, userMobile, userGender;
    Button regester, loginpagedisp,signup;
     TextView text;
  // HelperClass openHelper;
    SQLiteDatabase databse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       userFirstName = (EditText) findViewById(R.id.firstName);
        userLastName = (EditText) findViewById(R.id.lastName);
        Una = (EditText) findViewById(R.id.Uname);
        userEmail = (EditText) findViewById(R.id.email);
        userPassword = (EditText) findViewById(R.id.upassword);
        userMobile = (EditText) findViewById(R.id.uphone);
        userGender = (EditText) findViewById(R.id.Gender);
        regester = (Button) findViewById(R.id.buttonRegester);
        loginpagedisp = (Button) findViewById(R.id.loginpage);

        signup=(Button)findViewById(R.id.signup);
        text=(TextView)findViewById(R.id.tv);
        regester.setVisibility(View.INVISIBLE);



    //make invissible
        text.setVisibility(View.INVISIBLE);
     userFirstName.setVisibility(View.INVISIBLE);
     userLastName.setVisibility(View.INVISIBLE);
     Una.setVisibility(View.INVISIBLE);
     userEmail.setVisibility(View.INVISIBLE);
     userPassword.setVisibility(View.INVISIBLE);
     userMobile.setVisibility(View.INVISIBLE);
     userGender.setVisibility(View.INVISIBLE);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signup.setVisibility(View.INVISIBLE);

                text.setVisibility(View.VISIBLE);
                userFirstName.setVisibility(View.VISIBLE);
                userLastName.setVisibility(View.VISIBLE);
                Una.setVisibility(View.VISIBLE);
                userEmail.setVisibility(View.VISIBLE);
                userPassword.setVisibility(View.VISIBLE);
                userMobile.setVisibility(View.VISIBLE);
                userGender.setVisibility(View.VISIBLE);

                regester.setVisibility(View.VISIBLE);
            }
        });




        regester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inserINformation()) {
                    showMessage();
                }
            }
        });


        //call loging page
        loginpagedisp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,Login_Form.class);
                startActivity(i);
            }
        });
    }




    public boolean inserINformation() {
        HelperClass openHelper = new HelperClass(this);
        ContentValues content1 = new ContentValues();
        databse = openHelper.getWritableDatabase();

        content1.put(ModelClass.modelInnerClass.coulmnOne, userFirstName.getText().toString());
        content1.put(ModelClass.modelInnerClass.coulmnTwo, userLastName.getText().toString());
        content1.put(ModelClass.modelInnerClass.coulmnThree, Una.getText().toString());
        content1.put(ModelClass.modelInnerClass.coulmnFour, Integer.parseInt(userPassword.getText().toString()));
        content1.put(ModelClass.modelInnerClass.coulmnFive, Integer.parseInt(userMobile.getText().toString()));
        content1.put(ModelClass.modelInnerClass.coulmnSix, userEmail.getText().toString());
        content1.put(ModelClass.modelInnerClass.coulmnSeven, userGender.getText().toString());

        if (databse.insert(ModelClass.modelInnerClass.tablename, null, content1)==-1) {
            return false;
        }
        else
            return true;
       }

    //read data
    public Cursor readData()
    {
        HelperClass openHelper = new HelperClass(this);
        databse = openHelper.getWritableDatabase();
        String query="select *from "+ModelClass.modelInnerClass.tablename;
    Cursor result=databse.rawQuery(query,null);
       return result;
    }


    public void showMessage() {
        Toast.makeText(this, "DATA STORED SUCCESSFULLY", Toast.LENGTH_LONG).show();

        //aded first
       userFirstName.setText("");
       userLastName.setText("");
       Una.setText("");
       userPassword.setText("");
       userMobile.setText("");
       userGender.setText("");
       userEmail.setText("");
    }

    public  void  displayData(Cursor c)
    {
        Toast.makeText(this,"password"+Integer.parseInt(c.getString(3)),Toast.LENGTH_LONG).show();
    }


}
