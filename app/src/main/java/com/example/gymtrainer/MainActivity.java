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
//myList(recyclerView);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

 /*     switch (recyclerView.getId()){
            case 0:
                onItemClick(0);
                break;
            case 1:
                onItemClick(1);
                break;
            case 2:
                onItemClick(2);
                break;
            case 3:
                onItemClick(3);
                break;
            case 4:
                onItemClick(4);
                break;
            case 5:
                onItemClick(5);
                break;
            default: break;

        }*/

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


/*   private void myList(View view) {
        switch (view.getId()) {
            case 0:
                onItemClick(view,0);
                Log.d("MyLog", "pos: ");
                break;
            case 1:
                onItemClick(view,1);
                break;
            case 2:
                onItemClick(view,2);
                break;
            case 3:
                onItemClick(view,3);
                break;
            case 4:
                onItemClick(view,4);
                break;
            case 5:
                onItemClick(view,5);
                break;
            default:
                break;

        }
    }*/

    @Override
    public void onItemClick(View view, int pos) {
        Intent intent = new Intent(this, ExercisesActivity.class);
       /* switch (pos) {
            case 0:
                intent.putExtra(Gym.POSITION, pos);
                break;
            case 1:
                intent.putExtra(Gym.POSITION, pos);
                break;
            case 2:
                intent.putExtra(Gym.POSITION, pos);
                break;
            case 3:
                intent.putExtra(Gym.POSITION, pos);
                break;
            case 4:
                intent.putExtra(Gym.POSITION, pos);
                break;
            case 5:
                intent.putExtra(Gym.POSITION, pos);
                break;
            default:
                break;
        }*/
          intent.putExtra(Gym.POSITION, pos);
        startActivity(intent);
    }
}