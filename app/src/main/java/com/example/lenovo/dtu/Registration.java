package com.example.lenovo.dtu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText et5,et6,et7,et8,et9;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        myDb=new DatabaseHelper(this);

        et6=(EditText)findViewById(R.id.editText6);
        et5=(EditText)findViewById(R.id.editText5);
        et7=(EditText)findViewById(R.id.editText7);
        et8=(EditText)findViewById(R.id.editText8);
        et9=(EditText)findViewById(R.id.editText9);
        b=(Button) findViewById(R.id.button5);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData
                        (et5.getText().toString(),et6.getText().toString(),et7.getText().toString(),et8.getText().toString(),et9.getText().toString());
                if (isInserted == true) {
                    Toast.makeText(Registration.this, "Registered Successfully",
                            Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }

                else
                    Toast.makeText(Registration.this, "Not Registered", Toast.LENGTH_SHORT).show();
            }


        });
//



    }
}
