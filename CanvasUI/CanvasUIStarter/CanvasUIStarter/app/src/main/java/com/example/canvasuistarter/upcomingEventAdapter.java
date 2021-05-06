package com.example.canvasuistarter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.canvasuistarter.api.models.Course;
import com.example.canvasuistarter.api.models.UpcomingEvent;

import java.util.ArrayList;

public class upcomingEventAdapter extends RecyclerView.Adapter<upcomingEventAdapter.ViewHolder> {
    UpcomingEvent[] results;
    public upcomingEventAdapter(UpcomingEvent[] result){
        results = result;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upcoming_event_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UpcomingEvent result = results[position];
        TextView event = holder.itemView.findViewById(R.id.event_text);
        event.setText(result.title);
    }

    @Override
    public int getItemCount() {
        return results.length;
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}