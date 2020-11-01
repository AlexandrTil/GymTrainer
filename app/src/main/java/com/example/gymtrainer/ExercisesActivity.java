package com.example.gymtrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.gymtrainer.fragments.BackFragment;
import com.example.gymtrainer.fragments.BicFragment;
import com.example.gymtrainer.fragments.DeltaFragment;
import com.example.gymtrainer.fragments.LegsFragment;
import com.example.gymtrainer.fragments.PectoralFragment;
import com.example.gymtrainer.fragments.TricFragment;

public class ExercisesActivity extends AppCompatActivity {

    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);
        init();
    }

    private void init() {
        Intent intent = getIntent();
        pos = intent.getIntExtra(Gym.POSITION, 0);

        switch (pos) {
            case 0:
                PectoralFragment fragment0 = new PectoralFragment();
                FragmentTransaction fragmentTransaction0 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction0.add(R.id.container,fragment0);
                fragmentTransaction0.commit();
                break;
            case 1:
                LegsFragment fragment1 = new LegsFragment();
                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.add(R.id.container,fragment1);
                fragmentTransaction1.commit();
                break;
            case 2:
                BackFragment fragment2 = new BackFragment();
                FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction2.add(R.id.container,fragment2);
                fragmentTransaction2.commit();
                break;
            case 3:
                BicFragment fragment3 = new BicFragment();
                FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction3.add(R.id.container,fragment3);
                fragmentTransaction3.commit();
                break;
            case 4:
                TricFragment fragment4 = new TricFragment();
                FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction4.add(R.id.container,fragment4);
                fragmentTransaction4.commit();
                break;
            case 5:
                DeltaFragment fragment5 = new DeltaFragment();
                FragmentTransaction fragmentTransaction5 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction5.add(R.id.container,fragment5);
                fragmentTransaction5.commit();
                break;
            default:
                break;
        }
    }
}