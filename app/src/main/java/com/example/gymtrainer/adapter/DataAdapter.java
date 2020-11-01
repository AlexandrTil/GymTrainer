package com.example.gymtrainer.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.gymtrainer.Gym;
import com.example.gymtrainer.R;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<Gym> gyms;
    private onItemClick listener;

    public DataAdapter(Context context, List<Gym> gyms, onItemClick listener) {
        this.gyms = gyms;
        this.inflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_layout, parent, false);
        //final ViewHolder holder = new ViewHolder(parent);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DataAdapter.ViewHolder holder, final int position) {
        Gym gym = gyms.get(position);
        holder.tvName.setText(gym.getName());
        holder.imViewLogo.setImageResource(gym.getImage());
    }

    @Override
    public int getItemCount() {
        Log.d("MyLog", "gyms.size(): " + gyms.size());
        return gyms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final ImageView imViewLogo;
        final TextView tvName;

        ViewHolder(View view) {
            super(view);
            imViewLogo = (ImageView) view.findViewById(R.id.imViewLogo);
            tvName = (TextView) view.findViewById(R.id.tvName);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener != null) listener.onItemClick(view, getAdapterPosition());
        }
    }

    public void setClickListener(onItemClick itemClickListener) {
        this.listener = itemClickListener;
    }

    public interface onItemClick {
        void onItemClick(View view, int pos);
    }
}
