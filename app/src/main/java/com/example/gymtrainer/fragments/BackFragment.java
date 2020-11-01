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


public class BackFragment extends Fragment implements DataAdapter.onItemClick {
    private List<Gym> gyms = new ArrayList<>();
    private DataAdapter.onItemClick mListener;
    private DataAdapter adapter;
    private Context mContext;


    public BackFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_back, container, false);
        init();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rcBack);
        LinearLayoutManager linearLayout = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayout);
        adapter = new DataAdapter(getActivity(), gyms, mListener);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    private void init() {
        gyms.add(new Gym(getString(R.string.barbell_thrust), R.drawable.barbell_thrust));
        gyms.add(new Gym(getString(R.string.pull_ups), R.drawable.pull_ups));
        gyms.add(new Gym(getString(R.string.lower_block_thrust), R.drawable.lower_block_thrust));
        gyms.add(new Gym(getString(R.string.upper_block_thrust), R.drawable.upper_block_thrust));
    }

    @Override
    public void onItemClick(View view, int pos) {
        Intent intent = new Intent(getActivity(), InfoActivity.class);

        switch (pos) {
            case 0:
                intent.putExtra(Gym.TEXT, getResources().getString(R.string.barbell_thrust_info));
                intent.putExtra(Gym.POSITION, R.drawable.barbell_thrust);
                break;
            case 1:
                intent.putExtra(Gym.TEXT, getResources().getString(R.string.pull_ups_info));
                intent.putExtra(Gym.POSITION, R.drawable.pull_ups);
                break;
            case 2:
                intent.putExtra(Gym.TEXT, getResources().getString(R.string.lower_block_thrust_info));
                intent.putExtra(Gym.POSITION, R.drawable.lower_block_thrust);
                break;
            case 3:
                intent.putExtra(Gym.TEXT, getResources().getString(R.string.upper_block_thrust_info));
                intent.putExtra(Gym.POSITION, R.drawable.upper_block_thrust);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}