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


public class BicFragment extends Fragment implements DataAdapter.onItemClick {

    private List<Gym> gyms = new ArrayList<>();
    private DataAdapter.onItemClick mListener;
    private DataAdapter adapter;
    private Context mContext;


    public BicFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_bic, container, false);
        init();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.rcBic);
        LinearLayoutManager linearLayout = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayout);
        adapter = new DataAdapter(getActivity(), gyms, mListener);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        return rootView;
    }

    private void init() {
        gyms.add(new Gym(getString(R.string.lifting_biceps), R.drawable.lifting_biceps));
        gyms.add(new Gym(getString(R.string.hummer_bic), R.drawable.hummer_bic));
        gyms.add(new Gym(getString(R.string.conc_bic_curls), R.drawable.conc_bic_curls));
        gyms.add(new Gym(getString(R.string.rev_pull_ups), R.drawable.rev_pull_ups));
    }

    @Override
    public void onItemClick(View view, int pos) {
        Intent intent = new Intent(getActivity(), InfoActivity.class);

        switch (pos) {
            case 0:
                intent.putExtra(Gym.TEXT, getResources().getString(R.string.lifting_biceps_info));
                intent.putExtra(Gym.POSITION, R.drawable.lifting_biceps);
                break;
            case 1:
                intent.putExtra(Gym.TEXT, getResources().getString(R.string.hummer_bic_info));
                intent.putExtra(Gym.POSITION, R.drawable.hummer_bic);
                break;
            case 2:
                intent.putExtra(Gym.TEXT, getResources().getString(R.string.conc_bic_curls_info));
                intent.putExtra(Gym.POSITION, R.drawable.conc_bic_curls);
                break;
            case 3:
                intent.putExtra(Gym.TEXT, getResources().getString(R.string.rev_pull_ups_info));
                intent.putExtra(Gym.POSITION, R.drawable.rev_pull_ups);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}