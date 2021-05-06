package com.example.getyoked;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getyoked.models.ExerciseEntry;

public class GoalEntriesAdapter extends RecyclerView.Adapter<GoalEntriesAdapter.ViewHolder> {

    ObservableArrayList<ExerciseEntry> entries;
    public GoalEntriesAdapter(ObservableArrayList<ExerciseEntry> entries) {
        this.entries = entries;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.goal_entry_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView workoutText = holder.itemView.findViewById(R.id.workout_goal_text);
        TextView quantityText = holder.itemView.findViewById(R.id.quantity_goal_text);
        TextView unitText = holder.itemView.findViewById(R.id.unit_goal_text);
        TextView amountText = holder.itemView.findViewById(R.id.amount_goal_text);
        TextView unitAmountText = holder.itemView.findViewById(R.id.unit_amount_goal_text);

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
