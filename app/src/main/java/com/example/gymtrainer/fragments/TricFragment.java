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


public class TricFragment extends Fragment implements DataAdapter.onItemClick {


    private List<Gym> gyms = new ArrayList<>();
    private DataAdapter.onItemClick mListener;
    private DataAdapter adapter;
    private Context mContext;


    public TricFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_tric, container, false);
        init();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rcT);
        LinearLayoutManager linearLayout = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayout);
        adapter = new DataAdapter(getActivity(), gyms, mListener);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    private void init() {
        gyms.add(new Gym(getString(R.string.narrow_bench_press), R.drawable.narrow_bench_press));
        gyms.add(new Gym(getString(R.string.ext_arm_block), R.drawable.ext_arm_block));
        gyms.add(new Gym(getString(R.string.dumbbell_bench_press_head), R.drawable.dumbbell_bench_press_head));
        gyms.add(new Gym(getString(R.string.french_bench_press), R.drawable.french_bench_press));
    }

    @Override
    public void onItemClick(View view, int pos) {
        Intent intent = new Intent(getActivity(), InfoActivity.class);

        switch (pos) {
            case 0:
                intent.putExtra(Gym.TEXT, getResources().getString(R.string.narrow_bench_press_info));
                intent.putExtra(Gym.POSITION, R.drawable.narrow_bench_press);
                break;
            case 1:
                intent.putExtra(Gym.TEXT, getResources().getString(R.string.ext_arm_block_info));
                intent.putExtra(Gym.POSITION, R.drawable.ext_arm_block);
                break;
            case 2:
                intent.putExtra(Gym.TEXT, getResources().getString(R.string.dumbbell_bench_press_head_info));
                intent.putExtra(Gym.POSITION, R.drawable.dumbbell_bench_press_head);
                break;
            case 3:
                intent.putExtra(Gym.TEXT, getResources().getString(R.string.french_bench_press_info));
                intent.putExtra(Gym.POSITION, R.drawable.french_bench_press);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}