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

public class LegsFragment extends Fragment implements DataAdapter.onItemClick {

    private List<Gym> gyms = new ArrayList<>();
    private DataAdapter.onItemClick mListener;
    private DataAdapter adapter;
    private Context mContext;


    public LegsFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_legs, container, false);
        init();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rcL);
        LinearLayoutManager linearLayout = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayout);
        adapter = new DataAdapter(getActivity(), gyms, mListener);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    private void init() {
        gyms.add(new Gym(getString(R.string.squats), R.drawable.squats));
        gyms.add(new Gym(getString(R.string.leg_press), R.drawable.leg_press));
        gyms.add(new Gym(getString(R.string.deadlift), R.drawable.deadlift));
        gyms.add(new Gym(getString(R.string.r_deadlift), R.drawable.r_deadlift));
        gyms.add(new Gym(getString(R.string.lifting_to_socks), R.drawable.lifting_to_socks));
    }

    @Override
    public void onItemClick(View view, int pos) {
        Intent intent = new Intent(getActivity(), InfoActivity.class);

        switch (pos) {
            case 0:
                intent.putExtra(Gym.TEXT, getResources().getString(R.string.squats_info));
                intent.putExtra(Gym.POSITION, R.drawable.squats);
                break;
            case 1:
                intent.putExtra(Gym.TEXT, getResources().getString(R.string.leg_press_info));
                intent.putExtra(Gym.POSITION, R.drawable.leg_press);
                break;
            case 2:
                intent.putExtra(Gym.TEXT, getResources().getString(R.string.deadlift_info));
                intent.putExtra(Gym.POSITION, R.drawable.deadlift);
                break;
            case 3:
                intent.putExtra(Gym.TEXT, getResources().getString(R.string.r_deadlift_info));
                intent.putExtra(Gym.POSITION, R.drawable.r_deadlift);
                break;
            case 4:
                intent.putExtra(Gym.TEXT, getResources().getString(R.string.lifting_to_socks_info));
                intent.putExtra(Gym.POSITION, R.drawable.lifting_to_socks);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}