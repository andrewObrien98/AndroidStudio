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

import java.util.ArrayList;

public class courseAdapter extends RecyclerView.Adapter<courseAdapter.ViewHolder> {
    Course[] results;
    public courseAdapter(Course[] result){
        results = result;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_list_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Course result = results[position];
        TextView courseName = holder.itemView.findViewById(R.id.course_text);
        courseName.setText(result.name);
        //courseName.setBackgroundColor(R.color.course_background_color);
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
