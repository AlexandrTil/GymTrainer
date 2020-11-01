package com.example.gymtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;

public class InfoActivity extends AppCompatActivity {
    private String text;
    private int image;
    private TextView textInfo;
    private PhotoView imageInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_item);
        init();
    }

    private void init() {
        textInfo = findViewById(R.id.textInfo);
        imageInfo = findViewById(R.id.imageInfo);
        Intent intent = getIntent();
        text = intent.getStringExtra(Gym.TEXT);
        image = intent.getIntExtra(Gym.POSITION, 0);
        textInfo.setText(text);
        imageInfo.setImageResource(image);
    }
}