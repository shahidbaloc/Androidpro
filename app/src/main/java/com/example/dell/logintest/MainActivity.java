package com.example.dell.logintest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends  AppCompatActivity implements View.OnClickListener {



        //views fields
        private Button logiinButton , registerButton , cancelButton;
        private EditText pwd, email;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);

            logiinButton = findViewById(R.id.logini);
            registerButton = findViewById(R.id.register);
            cancelButton = findViewById(R.id.cancel);
            pwd= findViewById(R.id.inputPasswd);

            email= findViewById(R.id.inputEmail);


            logiinButton.setOnClickListener(this);
            registerButton.setOnClickListener(this);
            cancelButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            switch (view.getId()){

                case R.id.logini:
                   if(email.getText().toString().equals("shahid")&& pwd.getText().toString().equals("abcdef")) {
                       Intent into = new Intent(MainActivity.this, Main3Activity.class);
                       startActivity(into);
                       Toast.makeText(this, "Welcom to Home Page", Toast.LENGTH_SHORT).show();
                   }
                   else {
                       Toast.makeText(this, "Worrn Password and Email", Toast.LENGTH_LONG).show();
                   }
                    break;

                case R.id.cancel:
                    finish();
                    break;
                case R.id.register:
                    Intent in = new Intent(MainActivity.this,Reg.class);
                    startActivity(in);
                    //Toast.makeText(this , "No Logic for register",Toast.LENGTH_SHORT).show();
                    break;

                default:
                    break;
            }



        }
    }


