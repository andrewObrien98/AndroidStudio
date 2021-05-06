package com.example.getyoked;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.RecyclerView;

import com.example.getyoked.models.ExerciseEntry;


public class DateEntriesAdapter extends RecyclerView.Adapter<DateEntriesAdapter.ViewHolder> {

    ObservableArrayList<String> entries;
    public interface onDateEntryClicked {
        public void onClick(String entry);
    }

    onDateEntryClicked listener;

    public DateEntriesAdapter(ObservableArrayList<String> entries, onDateEntryClicked listener) {
        this.entries = entries;
        this.listener = listener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.date_entry_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView date = holder.itemView.findViewById(R.id.date_text);
        date.setText(entries.get(position));

        holder.itemView.setOnClickListener(view -> {
            listener.onClick(entries.get(position));//we will get the date that they clicked on and pass to function
        });
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
