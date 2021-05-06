package com.example.getyoked;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getyoked.Fragment.Workout;
import com.example.getyoked.models.ExerciseEntry;

import java.util.ArrayList;

public class WorkOutEntriesAdapter extends RecyclerView.Adapter<WorkOutEntriesAdapter.ViewHolder> {
    ArrayList<ExerciseEntry> entries;
    public WorkOutEntriesAdapter(ArrayList<ExerciseEntry> entries){
        this.entries = entries;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_specific_date_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView workoutText = holder.itemView.findViewById(R.id.workout_date_text);
        TextView quantityText = holder.itemView.findViewById(R.id.quantity_date_text);
        TextView unitText = holder.itemView.findViewById(R.id.unit_date_text);
        TextView amountText = holder.itemView.findViewById(R.id.amount_date_text);
        TextView unitAmountText = holder.itemView.findViewById(R.id.unit_amount_date_text);

        workoutText.setText(entries.get(position).workout);
        quantityText.setText(entries.get(position).quantity);
        unitText.setText(entries.get(position).unit);
        amountText.setText(entries.get(position).amount);
        unitAmountText.setText(entries.get(position).amountUnit);
    }

    @Override
    public int getItemCount() {
        return entries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
