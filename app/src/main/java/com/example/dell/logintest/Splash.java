package com.example.dell.logintest;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // we are using handler thread because of handling splash screem timing
        // this run on main UI thread

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // here we are taking intent for this class(MainActivity)
                Intent i = new Intent(Splash.this, MainActivity.class);
                startActivity(i);
                finish();

            }
            // 5 second for the splash screen
        }, 5000);

    }
}
