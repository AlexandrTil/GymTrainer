package com.example.gymtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        Handler handler = new Handler();
        Runnable run = new Runnable() {
           @Override
           public void run() {
               Intent intent = new Intent(LoginActivity.this, MainActivity.class);
               startActivity(intent);
               finish();
           }
       };
       handler.postDelayed(run,1500);
    }
}