package com.example.dell.logintest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Reg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        Button btn = (Button) findViewById(R.id.submit);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set your own toast  message
                Intent intent = new Intent(Reg.this, Main3Activity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Welcome to Home",Toast.LENGTH_LONG).show();
            }
        });
    }
}
