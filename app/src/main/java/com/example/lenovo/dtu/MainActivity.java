package com.example.lenovo.dtu;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    Button button;
    EditText et1, et2;
    TextView tv;
    static SQLiteDatabase db;
    static final String table = DatabaseHelper.Table_Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);
        button = (Button) findViewById(R.id.email_sign_in_button);
        et1 = (EditText) findViewById(R.id.email);
        et2 = (EditText) findViewById(R.id.password);
        tv = (TextView) findViewById(R.id.forgotPass);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(getApplicationContext(), Registration.class);
                startActivity(register);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = et1.getText().toString();
                String pass = et2.getText().toString();
                getData(email, pass);


//                if(!ValidateEmail(email)){
//                    et1.setError("Invalid!");
//                    et1.requestFocus();
//                }
//                else if(!ValidatePassword(pass)){
//                    et2.setError("Invalid!");
//                    et2.requestFocus();
//                }
//                else
//                    startActivity(intent);


            }
        });


    }

    public void getData(String email, String password) {

        String storedPassword=myDb.check(email);
        if(password.equals(storedPassword)){
            Intent home=new Intent(getApplicationContext(),Home.class);
            startActivity(home);
        }
        else {
            Toast.makeText(getApplicationContext(), "Please check your login credentials and try again ", Toast.LENGTH_LONG).show();
            et1.requestFocus();

        }



    }
//    @Override
//    protected void onDestroy() {
//        // Close The Database
//        super.onDestroy();
//        myDb.close();
//    }
}
//
//    public void getData(String email,String password){
//
//db=myDb.getWritableDatabase();
//        Cursor c= db.rawQuery("select * from " +
//                table , null);
//        if(c!=null)
//        {
//            do{
//                String m=c.getString(4);
//                String p=c.getString(5);
//
//                if((m.equals(email))&& p.equals(password)){
//                    Intent login=new Intent(getApplicationContext(),Home.class);
//                    startActivity(login);
//
//
//                }
//            }while (c.moveToNext());
//        }
//
//
//
//    }
//
//    private boolean ValidateEmail(String s){
//        String emailExp="^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
//        Pattern pattern=Pattern.compile(emailExp,Pattern.CASE_INSENSITIVE);
//        Matcher matcher=pattern.matcher(s);
//        return  (matcher.matches());
//    }
//
//    private boolean ValidatePassword(String s1){
//        if(s1!=null && s1.length()>8)
//            return true;
//        else
//            return false;
//    }
//
//}
