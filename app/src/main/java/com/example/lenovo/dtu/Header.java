package com.example.lenovo.dtu;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class Header extends AppCompatPreferenceActivity {
    static SQLiteDatabase db;
    DatabaseHelper myDb;
    TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header_home);

//        tv1=(TextView)findViewById(R.id.username);
//        tv2=(TextView)findViewById(R.id.email);

        


    }



}
