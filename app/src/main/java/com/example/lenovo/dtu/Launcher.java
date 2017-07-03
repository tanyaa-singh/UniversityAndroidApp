package com.example.lenovo.dtu;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Launcher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                    Intent i = new Intent(Launcher.this,MainActivity.class);
                    startActivity(i);
                }catch (Exception e)
                {

                }
            }
        }).start();
    }
}
