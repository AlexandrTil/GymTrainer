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


public class PectoralFragment extends Fragment implements DataAdapter.onItemClick {
    private List<Gym> gyms = new ArrayList<>();
    private DataAdapter.onItemClick mListener;
    private DataAdapter adapter;
    private Context mContext;


    public PectoralFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_pectoral, container, false);
        init();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rcP);
        LinearLayoutManager linearLayout = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayout);
        adapter = new DataAdapter(getActivity(), gyms, mListener);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    private void init() {
        gyms.add(new Gym(getString(R.string.bench_press), R.drawable.bench_press));
        gyms.add(new Gym(getString(R.string.con_hands), R.drawable.con_hands));
        gyms.add(new Gym(getString(R.string.bench_press_incline), R.drawable.bench_press_incline));
        gyms.add(new Gym(getString(R.string.push_up_p), R.drawable.push_up_p));
        gyms.add(new Gym(getString(R.string.bench_press_dumb), R.drawable.bench_press_dumb));
    }

    @Override
    public void onItemClick(View view, int pos) {
        Intent intent = new Intent(getActivity(), InfoActivity.class);

        switch (pos){
            case 0:
                intent.putExtra(Gym.TEXT,getResources().getString(R.string.bench_press_info));
                intent.putExtra(Gym.POSITION,R.drawable.bench_press);
                break;
            case 1:
                intent.putExtra(Gym.TEXT,getResources().getString(R.string.con_hands_info));
                intent.putExtra(Gym.POSITION,R.drawable.con_hands);
                break;
            case 2:
                intent.putExtra(Gym.TEXT,getResources().getString(R.string.bench_press_incline_info));
                intent.putExtra(Gym.POSITION,R.drawable.bench_press_incline);
                break;
            case 3:
                intent.putExtra(Gym.TEXT,getResources().getString(R.string.push_up_p_info));
                intent.putExtra(Gym.POSITION,R.drawable.push_up_p);
                break;
            case 4:
                intent.putExtra(Gym.TEXT,getResources().getString(R.string.bench_press_dumb_info));
                intent.putExtra(Gym.POSITION,R.drawable.bench_press_dumb);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}