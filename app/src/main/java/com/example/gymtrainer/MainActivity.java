package com.example.gymtrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import com.example.gymtrainer.adapter.DataAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DataAdapter.onItemClick {

    List<Gym> gyms = new ArrayList<>();
    private DataAdapter.onItemClick mListener;
    DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayout);
        adapter = new DataAdapter(this, gyms, mListener);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    private void init() {
        gyms.add(new Gym(getString(R.string.pectoral_musc), R.drawable.pectoral_musc));
        gyms.add(new Gym(getString(R.string.legs_musc), R.drawable.legs_musc));
        gyms.add(new Gym(getString(R.string.back_musc), R.drawable.back_musc));
        gyms.add(new Gym(getString(R.string.bic_musc), R.drawable.bic_musc));
        gyms.add(new Gym(getString(R.string.tric_musc), R.drawable.tric_musc));
        gyms.add(new Gym(getString(R.string.delta_musc), R.drawable.delta_musc));
        Log.d("MyLog", "muscGroups.size(): " + gyms.size());
    }

    @Override
    public void onItemClick(View view, int pos) {
        Intent intent = new Intent(this, ExercisesActivity.class);
        intent.putExtra(Gym.POSITION, pos);
        startActivity(intent);
    }
}