package com.example.gymtrainer.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gymtrainer.Gym;
import com.example.gymtrainer.InfoActivity;
import com.example.gymtrainer.R;
import com.example.gymtrainer.adapter.DataAdapter;

import java.util.ArrayList;
import java.util.List;


public class DeltaFragment extends Fragment implements DataAdapter.onItemClick {

    private List<Gym> gyms = new ArrayList<>();
    private DataAdapter.onItemClick mListener;
    private DataAdapter adapter;
    private Context mContext;


    public DeltaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_delta, container, false);
        init();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rcD);
        LinearLayoutManager linearLayout = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayout);
        adapter = new DataAdapter(getActivity(), gyms, mListener);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    private void init() {
        gyms.add(new Gym(getString(R.string.bench_press_stand), R.drawable.bench_press_stand));
        gyms.add(new Gym(getString(R.string.pull_bar_chin), R.drawable.pull_bar_chin));
        gyms.add(new Gym(getString(R.string.dumb_press_seat), R.drawable.dumb_press_seat));
        gyms.add(new Gym(getString(R.string.stand_dumb_swing), R.drawable.stand_dumb_swing));
    }

    @Override
    public void onItemClick(View view, int pos) {
        Intent intent = new Intent(getActivity(), InfoActivity.class);

        switch (pos) {
            case 0:
                intent.putExtra(Gym.TEXT, getResources().getString(R.string.bench_press_stand_info));
                intent.putExtra(Gym.POSITION, R.drawable.bench_press_stand);
                break;
            case 1:
                intent.putExtra(Gym.TEXT, getResources().getString(R.string.pull_bar_chin_info));
                intent.putExtra(Gym.POSITION, R.drawable.pull_bar_chin);
                break;
            case 2:
                intent.putExtra(Gym.TEXT, getResources().getString(R.string.dumb_press_seat_info));
                intent.putExtra(Gym.POSITION, R.drawable.dumb_press_seat);
                break;
            case 3:
                intent.putExtra(Gym.TEXT, getResources().getString(R.string.stand_dumb_swing_info));
                intent.putExtra(Gym.POSITION, R.drawable.stand_dumb_swing);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}